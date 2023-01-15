# 풀이 요약
# - 문자열을 정렬하여 애너그램의 대표값을 만든다.
# - 같은 대표값을 가진 문자열들을 그룹으로 묶는다.

def groupAnagrams(strs):
    anagrams = {}

    for str in strs:
        representativeKey = "".join(sorted(str))
        if not representativeKey in anagrams:
            anagrams[representativeKey] = []
        anagrams[representativeKey].append(str)

    return anagrams.values()


def test_groupAnagrams():
    groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]) == [
        ["bat"], ["nat", "tan"], ["ate", "eat", "tea"]
    ]
