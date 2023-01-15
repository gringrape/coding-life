# #. 입력 테스트
# - 간단한 숫자 하나를 입력받아 출력하기.
# - 여러개의 숫자를 입력받아서 배열로 만들기.

# ##. 간단한 숫자
a = input()
print(type(a))
# 여기서 입력받은 a의 type은 string이기 때문에, int로 변환해주어야 한다.

# ##. 여러개의 숫자를 입력받아 배열로 변환하기
numbersString = input()
numbers = [int(numberString) for numberString in numbersString.split(' ')]
print(sum(numbers))
