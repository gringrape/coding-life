from sync import encode, create_actions, abstractDirectory

from pathlib import Path


def test_encode():
    hash = encode(path=Path("./fixtures/file.txt"))
    assert hash != None


def test_create_actions_returns_copy_action():
    origin = {
        "abc": "name1",
        "bcd": "name2",
    }
    copy = {"abc": "name1"}

    actions = create_actions(origin, copy)

    assert actions == [("copy", "name2")]


def test_create_actions_returns_delete_action():
    origin = {
        "abc": "name1",
    }
    destination = {
        "abc": "name1",
        "bcd": "name2",
    }

    actions = create_actions(origin, destination)

    assert actions == [("delete", "name2")]


def test_create_actions_returns_rename_action():
    origin = {
        "abc": "name1",
    }
    destination = {
        "abc": "name2",
    }

    actions = create_actions(origin, destination)

    assert actions == [("rename", "name2", "name1")]


def test_abstractDirectory():
    assert abstractDirectory(path="./fixtures/origin") == {
        "16bbfb018c0da1f51b0cbd44dab579078612f097": "file2.txt",
        "907d14fb3af2b0d4f18c2d46abe8aedce17367bd": "file1.txt",
    }
