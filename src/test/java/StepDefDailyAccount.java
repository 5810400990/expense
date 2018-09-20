import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StepDefDailyAccount {
    DailyAccount dailyAccount;

    @Before
    public void init(){
        dailyAccount = new DailyAccount();

    }
    @Given("^a user with (\\d+) money in pocket$")
    public void a_user_with_money_in_pocket(int money) {
        dailyAccount.receiveMoney(money);
    }

    @When("^a user spend money with (\\d+)$")
    public void a_user_spend_money_with(int arg1)throws NotEnoughMoneyException {
      assertThrows(NotEnoughMoneyException.class,()->dailyAccount.spendMoney(5000));
    }

    @Then("^account will show money in pocket is (\\d+) , expense money is (\\d+) and income money is (\\d+)\\.$")
    public void account_will_show_money_in_pocket_is_expense_money_is_and_income_money_is(int arg1, int arg2, int arg3) throws Throwable {
      dailyAccount.show();
    }

    @When("^a user receive money with (\\d+)$")
    public void a_user_receive_money_with(int arg1) {
        dailyAccount.receiveMoney(100);
    }
    @Given("^a user with income (\\d+) and expense (\\d+)$")
    public void a_user_with_income_and_expense(int arg1, int arg2)  {

     dailyAccount.receiveMoney(100);
    }

    @When("^I edit income in index (\\d+) to (\\d+)$")
    public void i_edit_income_in_index_to(int arg1, int arg2)  {

        dailyAccount.edit("income/0/50");
    }

    @Then("^my money book balance is (\\d+)$")
    public void my_money_book_balance_is(int arg1)  {
       dailyAccount.show();
    }
    @When("^I edit expense in index (\\d+) to (\\d+)$")
    public void i_edit_expense_in_index_to(int arg1, int arg2) throws NotEnoughMoneyException {
        dailyAccount.spendMoney(20);
        dailyAccount.edit("expense/0/50");
    }


}
