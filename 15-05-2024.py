from typing import List
from collections import defaultdict

class Solution:
    def find(self, s: str, p: dict) -> str:
        return s if p[s] == s else self.find(p[s], p)
    
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        owner = {}
        parents = {}
        unions = defaultdict(set)
        
        for account in accounts:
            for email in account[1:]:
                parents[email] = email
                owner[email] = account[0]
        
        for account in accounts:
            p = self.find(account[1], parents)
            for email in account[2:]:
                parents[self.find(email, parents)] = p
        
        for account in accounts:
            for email in account[1:]:
                unions[self.find(email, parents)].add(email)
        
        ans = []
        for parent, emails in unions.items():
            res = [owner[parent]] + sorted(list(emails))
            ans.append(res)
        
        return ans
