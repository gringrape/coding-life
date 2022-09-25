package ctci.java;

public class BitVector {
    int bits = 0;

    public int get(int index) {
        int value = bits & (1 << index);
        return value >> index;
    }

    public void toggle(int index) {
        bits ^= (1 << index);
    }

    public int sumOfDigits() {
        int sum = 0;
        int accumulator = bits;

        while(accumulator > 0) {
            sum += accumulator & 1;
            accumulator >>= 1;
        }

        return sum;
    }

    public boolean checkExactlyOneBitSet() {
        if (bits == 0) {
            return false;
        }

        return (bits & (bits - 1)) == 0;
    }
}
