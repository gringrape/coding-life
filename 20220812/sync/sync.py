from pathlib import Path

import hashlib

import shutil

import os

BLOCK_SIZE = 65536


def encode(path: Path) -> str:
    hasher = hashlib.sha1()
    with path.open(mode="rb") as file:
        chunk = file.read(BLOCK_SIZE)
        while chunk:
            hasher.update(chunk)
            chunk = file.read(BLOCK_SIZE)
    return hasher.hexdigest()


def abstractDirectory(path):
    return {
        (hash := encode(Path(path) / file_name)): file_name
        for _, _, files in os.walk(path)
        for file_name in files
    }


def create_actions(origin, destination):
    actions = []

    for hash, file_name in origin.items():
        if hash not in destination:
            actions.append(("copy", file_name))
        elif file_name != (destination_file_name := destination[hash]):
            actions.append(("rename", destination_file_name, file_name))
    for hash, file_name in destination.items():
        if hash not in origin:
            actions.append(("delete", file_name))

    return actions


origin = Path("./fixtures/origin")
destination = Path("./fixtures/destination")


def copy(origin, destination, file_name):
    shutil.copy(src=origin / file_name, dst=destination)


def delete(origin, destination, file_name):
    os.remove(path=destination / file_name)


def rename(origin, destination, file_name_from, file_name_to):
    os.rename(src=destination / file_name_from, dst=destination / file_name_to)


def execute(action, origin, destination):
    name, *payload = action

    exectutor = {
        "copy": copy,
        "delete": delete,
        "rename": rename,
    }[name]

    exectutor(origin, destination, *payload)


def sync(origin, destination):
    actions = create_actions(
        origin=abstractDirectory(origin),
        destination=abstractDirectory(destination),
    )

    for action in actions:
        execute(action=action, origin=origin, destination=destination)


sync(origin, destination)
