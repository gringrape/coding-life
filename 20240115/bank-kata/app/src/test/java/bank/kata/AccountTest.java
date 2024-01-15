/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bank.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {
    @Test
    void testDeposit() {
        int initialBalance = 0;
        int depositAmount = 500;
        Account account = new Account(initialBalance);

        Account result = account.deposit(depositAmount);

        assertEquals(initialBalance + depositAmount, result.balance());
    }

    @Test
    void testWithdraw() throws Exception {
        int initialBalance = 500;
        int withdrawalAmount = 100;
        Account account = new Account(initialBalance);

        Account result = account.withdraw(withdrawalAmount);

        assertEquals(initialBalance - withdrawalAmount, result.balance());
    }

    @Test
    void testWithdrawNotEnoughBalance() {
        int initialBalance = 100;
        int withdrawalAmount = 500;
        Account account = new Account(initialBalance);

        assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(withdrawalAmount);
        });
    }
}
