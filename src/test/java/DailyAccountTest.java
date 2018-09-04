import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class DailyAccountTest {

private DailyAccount dailyAccount;

    @BeforeEach
    void init(){
        dailyAccount= new DailyAccount(100);

    }
    @Test
    void  testReceive(){
        dailyAccount.receiveMoney(50);
        assertEquals(dailyAccount.getMoneyPocket(),150);
        assertEquals(dailyAccount.getIncome(),50);
        assertEquals(dailyAccount.getExpense(),0);
        assertEquals(dailyAccount.show(),"My money pocket is "+150+"\nMy income of this month is "+50+"\nMy expense of this month is "+0);

    }
    @Test
    void testSpend() throws NotEnoughMoneyException {

        dailyAccount.spendMoney(50);
        assertEquals(dailyAccount.getMoneyPocket(),50);
        assertEquals(dailyAccount.getIncome(),0);
        assertEquals(dailyAccount.getExpense(),50);
        assertEquals(dailyAccount.show(),"My money pocket is "+50+"\nMy income of this month is "+0+"\nMy expense of this month is "+50);

    }
    @Test
    void testShow() throws NotEnoughMoneyException {
        dailyAccount.receiveMoney(100);
        dailyAccount.spendMoney(50);
        assertEquals(dailyAccount.getMoneyPocket(),150);
        assertEquals(dailyAccount.getIncome(),100);
        assertEquals(dailyAccount.getExpense(),50);
        assertEquals(dailyAccount.show(),"My money pocket is "+150+"\nMy income of this month is "+100+"\nMy expense of this month is "+50);
    }
}