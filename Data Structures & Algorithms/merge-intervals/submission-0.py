from typing import List

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []

        # 1) sort by start time
        intervals.sort(key=lambda x: x[0])

        res = []
        cur_start, cur_end = intervals[0]

        # 2) merge by scanning
        for start, end in intervals[1:]:
            # overlap case: next interval starts before current ends
            if start <= cur_end:
                cur_end = max(cur_end, end)   # extend current interval
            else:
                res.append([cur_start, cur_end])  # close current interval
                cur_start, cur_end = start, end   # start new interval

        # 3) add the last interval
        res.append([cur_start, cur_end])
        return res
