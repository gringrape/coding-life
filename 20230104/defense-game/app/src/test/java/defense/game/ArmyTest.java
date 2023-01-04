package defense.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmyTest {

    @Test
    void heal() {
        int soldier = 100;

        Army army = new Army(soldier, 1);

        army.defeat(90);
        army.defeat(40);
        army.defeat(40);

        assertTrue(army.hasSoldier());
    }

    @Test
    void healTheLargest() {
        int soldier = 100;

        Army army = new Army(soldier, 1);

        army.defeat(90);
        army.defeat(5);
        army.defeat(40);
        army.defeat(40);

        assertTrue(army.hasSoldier());
    }
}
