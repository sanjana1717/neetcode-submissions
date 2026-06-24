class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s)!=len(t):
            return False
        
        maps,mapt={},{}
        for i in range(len(s)):
            maps[s[i]]=1+maps.get(s[i],0)
            mapt[t[i]]=1+mapt.get(t[i],0)
        return maps==mapt