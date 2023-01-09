package defense.game;

import java.util.PriorityQueue;

public class Army {

    private int soldier;
    private int healCount;
    private final PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    public Army(int soldier, int healCount) {
        this.soldier = soldier;
        this.healCount = healCount;
    }

    public boolean hasSoldier() {
        return this.soldier > 0;
    }

    public boolean defeat(int enemy) {
        if (soldier >= enemy) {
            fight(enemy);
            return true;
        }

        return maxHealAmount() < enemy ? skip() : healAndDefeat(enemy);
    }

    private void fight(int enemy) {
        queue.add(enemy);
        this.soldier -= enemy;
    }

    private boolean healAndDefeat(int enemy) {
        if (healCount == 0) {
            this.soldier = 0;
            return false;
        }

        heal();
        return defeat(enemy);
    }

    private boolean skip() {
        if (healCount == 0) {
            return false;
        }
        healCount -= 1;
        return true;
    }

    private int maxHealAmount() {
        return queue.isEmpty() ? 0 : queue.peek();
    }

    private void heal() {
        int healAmount = largest();
        if (healAmount == 0) {
            return;
        }
        soldier += healAmount;
        healCount -= 1;
    }

    private int largest() {
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
