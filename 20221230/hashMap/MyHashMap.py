class MyHashMap:
    def __init__(self):
        capacity = 100
        self.table = [None] * capacity

    def put(self, key: int, value: int) -> int:
        if len(self.table) <= key:
            self.table += [None] * (key + 10 - len(self.table))
        self.table[key] = value

    def get(self, key: int) -> int:
        if len(self.table) <= key or self.table[key] == None:
            return -1
        return self.table[key]

    def remove(self, key: int) -> None:
        if len(self.table) <= key:
            return
        self.table[key] = None
