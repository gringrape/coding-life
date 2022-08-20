package krane;

public class Game {
    private final Board board;
    private final Basket basket;

    public Game(Board board, Basket basket) {
        this.board = board;
        this.basket = basket;
    }

    public void handleChoose(int line) {
        Integer doll = board.pick(line);

        if (doll == null) {
            return;
        }

        basket.put(doll);
    }

    public int score() {
        return basket.countBombs();
    }
}
