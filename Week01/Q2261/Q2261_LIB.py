import sys


def get_dist(p1, p2):
    return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2


def get_min_dist(srt, end):
    min_dist = sys.maxsize

    for i in range(srt, end):
        for j in range(i + 1, end + 1):
            min_dist = min(min_dist, get_dist(point_list[i], point_list[j]))

    return min_dist


def calc(srt, end):
    if end - srt < 3:
        return get_min_dist(srt, end)

    mid = (srt + end) // 2
    min_dist = min(calc(srt, mid), calc(mid + 1, end))
    new_list = []

    for idx in range(srt, end + 1):
        if min_dist > (point_list[idx][0] - point_list[mid][0]) ** 2:
            new_list.append(point_list[idx])

    new_list.sort(key=lambda y: y[1])

    for i in range(len(new_list) - 1):
        point1 = new_list[i]
        for j in range(i + 1, len(new_list)):
            point2 = new_list[j]
            dist = get_dist(point1, point2)

            if min_dist > dist:
                min_dist = dist
                break

            if (point1[1] - point2[1]) ** 2 > min_dist:
                break

    return min_dist


if __name__ == "__main__":
    N = int(sys.stdin.readline().strip('\n'))
    temp_set = set()
    point_list = []

    for _ in range(N):
        point_list.append(tuple(map(int, sys.stdin.readline().strip('\n').split())))

    point_list.sort()
    print(calc(0, N - 1))

# 75%

# import sys
#
#
# def get_dist(p1, p2):
#     return (p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2
#
#
# def get_min_dist(srt, end):
#     dist_list = []
#
#     for i in range(srt, end):
#         for j in range(i + 1, end):
#             dist_list.append(get_dist(point_list[i], point_list[j]))
#
#     return min(dist_list)
#
#
# def calc(srt, end):
#     if srt == end:
#         return sys.maxsize
#
#     if end - srt < 3:
#         return get_min_dist(srt, end + 1)
#
#     mid = (srt + end) // 2
#     min_dist = min(calc(srt, mid), calc(mid + 1, end))
#     new_list = []
#
#     for idx in range(srt, end + 1):
#         if min_dist > (point_list[idx][0] - point_list[mid][0]) ** 2:
#             new_list.append(point_list[idx])
#
#     new_list.sort(key=lambda x: x[1])
#
#     for i in range(len(new_list) - 1):
#         point1 = new_list[i]
#         for j in range(i + 1, len(new_list)):
#             point2 = new_list[j]
#             dist = get_dist(point1, point2)
#
#             if min_dist > dist:
#                 min_dist = dist
#                 break
#
#             if dist > min_dist:
#                 break
#
#     return min_dist
#
#
# if __name__ == "__main__":
#     N = int(sys.stdin.readline().strip('\n'))
#     temp_set = set()
#     point_list = []
#
#     for _ in range(N):
#         point_list.append(tuple(map(int, sys.stdin.readline().strip('\n').split())))
#
#     point_list.sort()
#     print(calc(0, N - 1))

# 75%
# import sys
#
#
# def get_dist(srt, end):
#     return (point_list[srt][0] - point_list[end][0]) ** 2 + (point_list[srt][1] - point_list[end][1]) ** 2
#
#
# def calc(srt, end):
#     if srt == end:
#         return float('inf')
#
#     if end - srt == 1:
#         get_dist(srt, end)
#
#     mid = (srt + end) // 2
#     min_dist = min(calc(srt, mid), calc(mid + 1, end))
#     new_list = []
#
#     for idx in range(srt, end + 1):
#         if min_dist > (point_list[idx][0] - point_list[mid][0]) ** 2:
#             new_list.append(point_list[idx])
#
#     new_list.sort(key=lambda x: x[1])
#
#     for i in range(len(new_list) - 1):
#         for j in range(i + 1, len(new_list)):
#             dist = (new_list[i][0] - new_list[j][0]) ** 2 + (new_list[i][1] - new_list[j][1]) ** 2
#
#             if min_dist > dist:
#                 min_dist = dist
#                 break
#
#             if dist > min_dist:
#                 break
#
#     return min_dist
#
#
# if __name__ == "__main__":
#     N = int(sys.stdin.readline().strip('\n'))
#     temp_set = set()
#     point_list = []
#
#     for _ in range(N):
#         point_list.append(tuple(map(int, sys.stdin.readline().strip('\n').split())))
#
#     point_list.sort()
#     print(calc(0, N - 1))
