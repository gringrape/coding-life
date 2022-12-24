def insert(intervals, newInterval):
    def isOverlapped(interval1, interval2):
        start1, end1 = interval1
        start2, end2 = interval2
        return max(start1, start2) <= min(end1, end2)

    def merge(intervals):
        starts = [start for start, end in intervals]
        ends = [end for start, end in intervals]
        return [min(starts), max(ends)]

    overlappedIntervals = [
        interval for interval in intervals
        if isOverlapped(interval, newInterval)
    ]

    notOverlappedIntervals = [
        interval for interval in intervals
        if not isOverlapped(interval, newInterval)
    ]

    merged = merge([*overlappedIntervals, newInterval])

    return sorted(
        [*notOverlappedIntervals, merged],
        key=lambda interval: interval[0]
    )


def test_insert_interval():
    assert insert(
        intervals=[[1, 5]],
        newInterval=[2, 3]
    ) == [[1, 5]]

    assert insert(
        intervals=[[1, 3], [6, 9]],
        newInterval=[2, 5]
    ) == [[1, 5], [6, 9]]

    assert insert(
        intervals=[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]],
        newInterval=[4, 8]
    ) == [[1, 2], [3, 10], [12, 16]]
