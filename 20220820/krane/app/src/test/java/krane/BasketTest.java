package krane;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {
    @Test
    void put() {
        Basket basket = new Basket();

        basket.put(1);
        basket.put(1);

        assertEquals(2, basket.countBombs());
    }
}
