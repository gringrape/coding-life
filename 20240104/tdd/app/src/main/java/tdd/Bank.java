package tdd;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Pair, Integer> rates = new HashMap<>();

    public Money reduce(Expression expression, String to) {
        return expression.reduce(this, to);
    }

    // rate 만 테스트??
    public int rate(String from, String to) {
        // 환율표
        // - hashTable -> O(1)
        // - 객체 -> 값 -> 메모리 주소
        // hashTable -> key, value
        // key -> hashable, from 과 to 를 엮은 hashable 객체 => Array? Pair?
        if (from.equals(to)) {
            return 1;
        }
        Pair pair = new Pair(from, to);
        return rates.get(pair);
    }

    public void addRate(String from, String to, int rate) {
        Pair pair = new Pair(from, to);
        rates.put(pair, rate);
    }

}
