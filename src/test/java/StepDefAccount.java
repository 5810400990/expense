//นายดิศรณ์  ฐิติกรโกวิท  5810400990
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefAccount {
    DailyAccount dailyAccount;

    @Before
    public void init() {
        dailyAccount = new DailyAccount();

    }

    @Given("a user with (\\d+) money in pocket")
    public void a_user_with_money_in_pocket(int money) {
        dailyAccount.setMoneyPocket(money);

    }

    @When("a user spend money with (\\d+)")
    public void a_user_spend_money_with(int money) throws NotEnoughMoneyException {
        if (money > dailyAccount.getMoneyPocket()){
            assertThrows(NotEnoughMoneyException.class,
                    () -> dailyAccount.spendMoney(money));
        }else{
            dailyAccount.spendMoney(money);
        }
    }

    @When("a user receive money with (\\d+)")
    public void a_user_receive_money_with(int money) {
        dailyAccount.receiveMoney(money);
    }

    @Then("account will show money in pocket is (\\d+) , expense money is (\\d+) and income money is (\\d+).")
    public void account_will_show_money_in_pocket_is_expense_money_is_and_income_money_is(int mp, int exp, int ic) {
        assertEquals(mp, dailyAccount.getMoneyPocket());
        assertEquals(exp, dailyAccount.getExpense());
        assertEquals(ic, dailyAccount.getIncome());
    }
}
