import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

//นายดิศรณ์  ฐิติกรโกวิท  5810400990
public class DailyAccount {


    private int income =0;
    private  int expense =0;
    private  int moneyPocket =0;

    ArrayList<Integer> incomeAccount = new ArrayList<>();
    ArrayList<Integer> expenseAccount = new ArrayList<>();


    public void receiveMoney(int income){

        incomeAccount.add(income);
        moneyPocket+=income;
        this.income+=income;
    }
    public void spendMoney(int expense) throws NotEnoughMoneyException {
        if (expense>moneyPocket){
            throw new NotEnoughMoneyException("Money Pocket is not enough");
        }else {


            expenseAccount.add(expense);
            this.expense += expense;
            moneyPocket -= expense;
        }
    }
    public String show(){

        return "Money pocket = "+moneyPocket+" Income = "+income+" Expense = "+expense;
    }

    public void edit(String t){
        String [] a = t.split("/");
        int index = Integer.parseInt(a[1]);
        int value = Integer.parseInt(a[2]);

        if (a[0].equals("income")){
            this.income-=incomeAccount.get(index);
            this.income+=value;
            this.moneyPocket-=incomeAccount.get(index);
            this.moneyPocket+=value;

            incomeAccount.set(index,value);


        }else if (a[0].equals("expense")){
            this.expense-=expenseAccount.get(index);
            this.expense+=value;
            this.moneyPocket-=expenseAccount.get(index);
            this.moneyPocket+=value;

            incomeAccount.set(index,value);



        }
    }


    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int getExpense() {
        return expense;
    }

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public int getMoneyPocket() {
        return moneyPocket;
    }

    public void setMoneyPocket(int moneyPocket) {
        this.moneyPocket = moneyPocket;
    }

    public ArrayList<Integer> getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(ArrayList<Integer> incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public ArrayList<Integer> getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(ArrayList<Integer> expenseAccount) {
        this.expenseAccount = expenseAccount;
    }


}
