from functools import reduce

def add(*numbers):
  if not numbers:
    return 0
  
  first, *rest = numbers  
  return first + add(*rest)

assert add(1, 2) == 3
assert add(1, 2, 3) == 6
assert add(1, 2, 3, 4) == 10


def subtract(*numbers):
  first, *rest = numbers
  return first - sum(rest)
  
assert subtract(3, 1) == 2
assert subtract(5, 1, 3) == 1

# reduce 사용법: reduce(lambda x, y: x+y, [1, 2, 3, 4, 5]) 
def multiply(*numbers):
  return reduce(lambda x, y: x * y, numbers, 1)

assert multiply(1, 2, 5) == 10
assert multiply(5, 3) == 15
