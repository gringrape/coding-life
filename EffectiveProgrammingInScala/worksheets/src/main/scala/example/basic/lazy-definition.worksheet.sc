def lazyEvaluatedValue = 2 * 2

val notLazyEvaluatedValue = 3 * 5

lazyEvaluatedValue

// lazy 선언의 경우, 사용될때 비로소 평가가 일어나는 것을 확인할 수 있다.
