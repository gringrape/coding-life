import hashlib
import os
import shutil
from pathlib import Path


def hash_file(path):
    hasher = hashlib.sha1()
    with path.open("rb") as file:
        buf = file.read(65536)
        while buf:
            hasher.update(buf)
            buf = file.read(65536)
        return hasher.hexdigest()


def main():
    source_hash = {}

    source = "./source"
    for folder, _, files in os.walk(source):
        for file_name in files:
            source_hash[hash_file(Path(folder) / file_name)] = file_name

    seen = set()

    destination = "./destination"
    for folder, _, files in os.walk(destination):
        for file_name in files:
            file_path = Path(folder) / file_name
            file_hash = hash_file(file_path)
            if file_hash not in source_hash:
                os.unlink(file_path)
            elif source_hash[file_hash] != file_name:
                os.rename(file_path, Path(folder) / source_hash[file_hash])
            seen.add(file_hash)

    for hash, file_name in source_hash.items():
        if hash not in seen:
            shutil.copy(Path(source) / file_name, Path(destination) / file_name)


main()
