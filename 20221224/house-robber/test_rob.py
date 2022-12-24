def rob_memoization(houses, index=0, memo=None):
    if not memo:
        memo = [0] * len(houses)

    if index >= len(houses):
        return 0

    if memo[index] == 0:
        memo[index] = max(
            houses[index] + rob_memoization(houses, index + 2, memo),
            rob_memoization(houses, index + 1, memo)
        )

    return memo[index]

def rob_bottom_up(houses):
    memo = [0] * len(houses)
    
    memo[0] = houses[0]
    memo[1] = max(houses[0], houses[1])
   
    for i in range(2, len(houses)):
        memo[i] = max(houses[i] + memo[i - 2], memo[i - 1])
    
    return memo[-1]

def rob_bottom_up_tail_recursion(houses):
    def rob_iterative(index = 2, a = houses[0], b=max(houses[0], houses[1])):
        if index >= len(houses):
            return b
        
        return rob_iterative(index + 1, a=b, b=max(houses[index] + a, b))
            
    return rob_iterative()

solutions = [rob_memoization, rob_bottom_up, rob_bottom_up_tail_recursion]

def test_rob():
    for rob in solutions:
        assert rob(houses=[1, 2, 3, 1]) == 4
        assert rob(houses=[2, 7, 9, 3, 1]) == 12
        assert rob(houses=[183, 219, 57, 193, 94, 233, 202, 154, 65, 240, 97, 234, 100, 249, 186, 66, 90, 238,
                                    168, 128, 177, 235, 50, 81, 185, 165, 217, 207, 88, 80, 112, 78, 135, 62, 228, 247, 211]) == 3365
