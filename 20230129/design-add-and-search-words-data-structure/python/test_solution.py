class TrieNode:
    def __init__(self, letter=None):
        self.letter = letter
        self.children = dict()
        self.isEnd = False

    def hasChild(self, letter):
        return letter in self.children

    def addChild(self, node):
        self.children[node.letter] = node


class WordDictionary:
    def __init__(self):
        self.root = TrieNode()

    def addWord(self, word, currentNode=None):
        if not word:
            currentNode.isEnd = True
            return

        if not currentNode:
            currentNode = self.root

        letter = word[0]
        if currentNode.hasChild(letter):
            self.addWord(word[1:], currentNode.children[letter])
            return

        newNode = TrieNode(letter)
        currentNode.addChild(newNode)
        self.addWord(word[1:], newNode)

    def search(self, word, current=None):
        if not current:
            current = self.root

        if not word:
            return current.isEnd

        letter = word[0]
        if letter == '.':
            return any(self.search(word[1:], current=node) for node in current.children.values())

        return current.hasChild(letter) and self.search(word[1:], current.children[letter])


def test_sample1():
    wordDictionary = WordDictionary()

    methodNames = ["addWord", "addWord", "addWord",
                   "search", "search", "search", "search"]

    argumentsList = [["bad"], ["dad"], ["mad"],
                     ["pad"], ["bad"], [".ad"], ["b.."]]

    expectedResults = [None, None, None, False, True, True, True]

    for methodName, arguments, expectedResult in zip(methodNames, argumentsList, expectedResults):
        method = getattr(wordDictionary, methodName)
        assert method(*arguments) == expectedResult


def test_sample2():
    wordDictionary = WordDictionary()

    methodNames = ["addWord", "addWord", "addWord", "addWord", "search", "search",
                   "addWord", "search", "search", "search", "search", "search", "search"]

    argumentsList = [["at"], ["and"], ["an"], ["add"], ["a"], [".at"], [
        "bat"], [".at"], ["an."], ["a.d."], ["b."], ["a.d"], ["."]]

    expectedResults = [None, None, None, None, False,
                       False, None, True, True, False, False, True, False]

    for methodName, arguments, expectedResult in zip(methodNames, argumentsList, expectedResults):
        method = getattr(wordDictionary, methodName)
        assert method(*arguments) == expectedResult
