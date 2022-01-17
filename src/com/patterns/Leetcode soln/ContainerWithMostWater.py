# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#
#         results = 0
#
#         j = len(height) - 1
#         i = 0
#
#         while i != j:
#
#             vol = min(height[i], height[j]) * (j - i)
#
#             if vol > results:
#                 results = vol
#
#             if height[i] < height[j]:
#                 i += 1
#             else:
#                 j -= 1
#
#         return results