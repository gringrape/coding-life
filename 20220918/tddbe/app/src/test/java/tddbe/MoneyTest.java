package tddbe;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 5$ * 2 = 10$ -> 해결!
// Dollar 부작용 -> 해결!
// amount public -> 해결!
// Dollar 정수형?
// equals -> 해결!

public class MoneyTest {
    @Test
    void dollarMultiplication() {
        Money five = Money.dollar(5);

        assertThat(five.times(2)).isEqualTo(Money.dollar(10));
        assertThat(five.times(3)).isEqualTo(Money.dollar(15));
    }

    @Test
    void francMultiplication() {
        Money five = Money.franc(5);

        assertThat(five.times(2)).isEqualTo(Money.franc(10));
        assertThat(five.times(3)).isEqualTo(Money.franc(15));
    }

    @Test
    void equality() {
        assertThat(Money.dollar(5)).isEqualTo(Money.dollar(5));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.dollar(6));
        assertThat(Money.franc(5)).isEqualTo(Money.franc(5));
        assertThat(Money.franc(5)).isNotEqualTo(Money.franc(6));
        assertThat(Money.dollar(5)).isNotEqualTo(Money.franc(5));
    }

    @Test
    void testCurrency() {
        assertThat(Money.dollar(0).currency()).isEqualTo("USD");
        assertThat(Money.franc(0).currency()).isEqualTo("CHF");
    }

    @Test
    void simpleAddition() {
        Expression five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }

    @Test
    void sum() {
        Money five = Money.dollar(5);
        Sum sum = (Sum) five.plus(five);
        assertThat(sum.augend).isEqualTo(five);
        assertThat(sum.addend).isEqualTo(five);
    }

    @Test
    void reduceSum() {
        Sum sum = (Sum) Money.dollar(3).plus(Money.dollar(4));
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(7));
    }

    @Test
    void exchange() {
        Money money = Money.franc(2);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(money, "USD");
        assertThat(result).isEqualTo(Money.dollar(1));
    }

    @Test
    void multipleCurrencyAddition() {
        Expression sum = Money.franc(10).plus(Money.dollar(5));
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money reduced = bank.reduce(sum, "USD");
        assertThat(reduced).isEqualTo(Money.dollar(10));
    }
}
