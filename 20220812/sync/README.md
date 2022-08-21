# 디렉토리 동기화 어플리케이션
원본과 사본 디렉토리를 같은 상태로 동기화한다. 

## 작업 계획
원본, 사본 디렉토리를 추상화한다.
- 파일을 내용과 경로의 쌍으로 추상화한다.
- 디렉토리는 파일의 모음으로 추상화한다.
동기화에 필요한 액션을 나열한다.
- 복사, 삭제, 이름 바꾸기
각 액션마다 해야할 구체적인 일들을 구현한다.

## 테스트 방향
- 동기화 할때, 원하는 액션의 모음이 생성되는가?

## 구현
### 해시
Python - hashlib 이용
https://docs.python.org/3/library/hashlib.html

- hash update -> 해시에 저장된 문자열을 업데이트 -> 연속된 호출은 한번에 이어서 하는것과 같음.
- hash digest -> 해시에 저장된 문자열을 하나의 값으로 만든다. 

Hashing 에 대한 일반적인 개념은 무엇일까?

## 파일 복사 실험
Python에서 파일을 복사하는 방법에 대해 잘모르기 때문에 실험을 통해서 
확인하려 함. 

-> [Python Docs](https://docs.python.org/3/library/pathlib.html?highlight=path#module-pathlib)에서 검색을 통해 쓸만한 라이브러리를 조사함. 

-> 임시 폴더를 생성함.
-> REPL을 이용함.

```python
from shutil import copy
from pathlib import Path
```

shutil에 대한 설명. 

> Copies the file src to the file or directory dst. **src and dst should be path-like objects or strings**. If dst specifies a directory, the file will be copied into dst using the base filename from src. If dst specifies a file that already exists, it will be replaced. Returns the path to the newly created file.

```python
origin = Path("./temp/origin/file.txt")
destination = Path("./temp/destination")

copy(origin, destination)
```

### 파일 삭제
- https://docs.python.org/3/library/os.html?highlight=delete%20file%20os
```python
os.remove(
  # ...
)
```
### 파일 이름바꾸기
- https://docs.python.org/3/library/os.html?highlight=delete%20file%20os
```python
os.rename(
  #
)
```

## Iterable Unpacking
https://peps.python.org/pep-0448/