from math import ceil


def solution(fees, records):
    base_time, base_cost, unit_time, cost_per_unit = fees

    def parse_time(time):
        hour, minute = (int(i) for i in time.split(":"))
        return (hour, minute)

    def difference_in_minute(start, end):
        start_hour, start_minute = parse_time(start)
        end_hour, end_minute = parse_time(end)
        return (end_hour - start_hour) * 60 + end_minute - start_minute

    def calculate_cost(time):
        if time <= base_time:
            return base_cost

        return base_cost + ceil((time - base_time) / unit_time) * cost_per_unit

    cars = {}
    for record in records:
        time, number, in_out = record.split(" ")

        if number not in cars:
            cars[number] = {"accumulated_time": 0}

        car = cars[number]

        if in_out == "OUT":
            car["accumulated_time"] += difference_in_minute(car["time"], time)

        car["flag"] = in_out
        car["time"] = time

    for number in cars:
        car = cars[number]

        if car["flag"] == "IN":
            car["flag"] = "OUT"
            car["accumulated_time"] += difference_in_minute(car["time"], "23:59")
            car["time"] = "23:59"

        cost = calculate_cost(car["accumulated_time"])
        cars[number] = cost

    return [cost for car, cost in sorted(cars.items(), key=lambda x: x[0])]


def test_sample():
    assert solution([1, 461, 1, 10], ["00:00 1234 IN"]) == [14841]
    assert (
        solution(
            [180, 5000, 10, 600],
            [
                "05:34 5961 IN",
                "06:00 0000 IN",
                "06:34 0000 OUT",
                "07:59 5961 OUT",
                "07:59 0148 IN",
                "18:59 0000 IN",
                "19:09 0148 OUT",
                "22:59 5961 IN",
                "23:00 5961 OUT",
            ],
        )
        == [14600, 34400, 5000]
    )
    assert (
        solution(
            [120, 0, 60, 591],
            [
                "16:00 3961 IN",
                "16:00 0202 IN",
                "18:00 3961 OUT",
                "18:00 0202 OUT",
                "23:58 3961 IN",
            ],
        )
        == [0, 591]
    )
