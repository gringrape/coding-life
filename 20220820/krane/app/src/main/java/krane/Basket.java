package krane;

import java.util.Stack;

public class Basket {
    private final Stack<Integer> dolls;
    private int bombs;

    public Basket() {
        this.dolls = new Stack<>();
        this.bombs = 0;
    }

    private boolean checkBomb(int doll) {
        if (dolls.isEmpty()) {
            return false;
        }

        return dolls.peek() == doll;
    }

    private void bomb() {
        if (dolls.isEmpty()) {
            return;
        }

        dolls.pop();
        bombs += 2;
    }

    private void add(int doll) {
        dolls.add(doll);
    }

    public void put(int doll) {
        if (checkBomb(doll)) {
            bomb();
            return;
        }
        add(doll);
    }

    public int countBombs() {
        return bombs;
    }
}
