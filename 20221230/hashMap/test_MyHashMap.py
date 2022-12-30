from MyHashMap import MyHashMap


def test_get_returns_not_exist():
    map = MyHashMap()
    assert map.get(1) == -1


def test_put():
    map = MyHashMap()
    map.put(2, 5)
    assert map.get(2) == 5


def test_remove():
    map = MyHashMap()

    map.put(2, 3)

    map.remove(2)

    assert map.get(2) == -1
