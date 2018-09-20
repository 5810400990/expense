import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyAccountTest {
    DailyAccount dailyAccount;
    @BeforeEach
    void init(){
        dailyAccount = new DailyAccount();
        dailyAccount.setMoneyPocket(100);
    }

    @Test
    void testReceive(){
        dailyAccount.receiveMoney(100);
        assertEquals(200,dailyAccount.getMoneyPocket());
        assertEquals(100,dailyAccount.getIncome());
        assertEquals(0,dailyAccount.getExpense());
        assertEquals("Money pocket = 200 Income = 100 Expense = 0",dailyAccount.show());

    }
    @Test
    void testSpend() throws NotEnoughMoneyException {
        dailyAccount.spendMoney(20);
        assertEquals(80,dailyAccount.getMoneyPocket());
        assertEquals(0,dailyAccount.getIncome());
        assertEquals(20,dailyAccount.getExpense());
        assertEquals("Money pocket = 80 Income = 0 Expense = 20",dailyAccount.show());



    }

    @Test
    void testSpendIncorrect() throws NotEnoughMoneyException {

        assertThrows(NotEnoughMoneyException.class,
                () -> dailyAccount.spendMoney(120));
        assertEquals(100,dailyAccount.getMoneyPocket());
        assertEquals(0,dailyAccount.getIncome());
        assertEquals(0,dailyAccount.getExpense());
        assertEquals("Money pocket = 100 Income = 0 Expense = 0",dailyAccount.show());

    }

    @Test
    void testEdit(){
        dailyAccount.receiveMoney(100);
        dailyAccount.edit("income/0/50");
        assertEquals(150,dailyAccount.getMoneyPocket());
        assertEquals(50,dailyAccount.getIncome());
        assertEquals(0,dailyAccount.getExpense());
        assertEquals("Money pocket = 150 Income = 50 Expense = 0",dailyAccount.show());



    }





}