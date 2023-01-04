package defense.game;

public class Solution {
    public int solution(int n, int k, int[] enemies) {
        Army army = new Army(n, k);

        int round = 0;
        while (round != enemies.length && army.defeat(enemies[round])) {
            round += 1;
        }

        return round;
    }
}
