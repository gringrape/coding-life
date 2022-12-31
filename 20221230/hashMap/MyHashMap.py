from Bucket import Bucket


class MyHashMap:
    def __init__(self):
        self.capacity = 1000
        self.table = [None] * self.capacity

    def hash(self, key):
        return key % self.capacity

    def put(self, key: int, value: int) -> int:
        bucket = self.get_bucket(key)
        bucket.push(key, value)

    def get_bucket(self, key):
        index = self.hash(key)
        if not self.table[index]:
            self.table[index] = Bucket()

        return self.table[index]

    def get(self, key: int) -> int:
        if not self.has(key):
            return -1
        bucket = self.get_bucket(key)
        if (value := bucket.get_value(key)) == None:
            return -1
        return value

    def remove(self, key: int) -> None:
        if not self.has(key):
            return
        bucket = self.get_bucket(key)
        bucket.remove(key)

    def has(self, key):
        index = self.hash(key)
        return self.table[index] != None
