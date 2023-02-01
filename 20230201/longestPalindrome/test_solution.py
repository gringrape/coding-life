class Solution:
    longestPalindromes = dict()
    palindromeChecks = dict()

    def isPalindrome(self, string):
        if not string:
            return True

        if string not in self.palindromeChecks:
            self.palindromeChecks[string] = \
                string[0] == string[-1] and self.isPalindrome(string[1:-1])

        return self.palindromeChecks[string]

    def longestPalindrome(self, s: str) -> str:
        if self.isPalindrome(s):
            return s

        if s not in self.longestPalindromes:
            self.longestPalindromes[s] = max(
                self.longestPalindrome(s[1:]),
                self.longestPalindrome(s[:-1]),
                key=lambda x: len(x)
            )

        return self.longestPalindromes[s]

# 시간 복잡도 n ^ 2 (탐색) => palindrome check n => n ^ 3


def test_logestPalndrome():
    solution = Solution()
    assert solution.longestPalindrome("cbbd") == "bb"
    assert solution.longestPalindrome("babad") == "aba"
    assert solution.longestPalindrome(
        "abbcccbbbcaaccbababcbcabca"
    ) == "cbababc"
