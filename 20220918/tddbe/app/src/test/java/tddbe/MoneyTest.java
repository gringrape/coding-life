package tddbe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 5$ * 2 = 10$ -> 해결!
// Dollar 부작용 -> 해결!
// amount public
// Dollar 정수형?
// equals

public class MoneyTest {
    @Test void dollarMultiplication() {
        Dollar five = new Dollar(5);

        assertThat(five.times(2)).isEqualTo(new Dollar(10));
        assertThat(five.times(3)).isEqualTo(new Dollar(15));
    }

    @Test void francMultiplication() {
        Franc five = new Franc(5);

        assertThat(five.times(2)).isEqualTo(new Franc(10));
        assertThat(five.times(3)).isEqualTo(new Franc(15));
    }

    @Test void equality() {
        assertThat(new Dollar(5)).isEqualTo(new Dollar(5));
        assertThat(new Dollar(5)).isNotEqualTo(new Dollar(6));
        assertThat(new Franc(5)).isEqualTo(new Franc(5));
        assertThat(new Franc(5)).isNotEqualTo(new Franc(6));
    }
}
