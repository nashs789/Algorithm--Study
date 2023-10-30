class Solution:
    def isPalindrome(self, x: int) -> bool:
        org_list = list(map(int, str(x)))
        rev_list = list(map(int, str(x)))
        rev_list.reverse()

        print(org_list == rev_list)