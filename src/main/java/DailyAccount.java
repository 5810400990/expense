

public class DailyAccount {
    private int moneyPocket=0;
    private int income =0;
    private int expense=0;


    public DailyAccount(){

    }

    public DailyAccount(int moneyPocket) {
        this.moneyPocket = moneyPocket;
    }

    public void setMoneyPocket(int moneyPocket) {
        this.moneyPocket = moneyPocket;
    }

    public void receiveMoney(int m){
        this.moneyPocket+=m;
        this.income+=m;
    }

    public void spendMoney(int m)throws NotEnoughMoneyException{
        if (m<=this.moneyPocket) {
            this.moneyPocket -= m;
            this.expense += m;
        }else {
            throw new NotEnoughMoneyException("Money in pocket not enought to spend");
        }
    }

    public String show(){

        return "My money pocket is "+this.moneyPocket +"\nMy income of this month is "+this.income+"\nMy expense of this month is "+this.expense;
    }

    public int getMoneyPocket() {
        return moneyPocket;
    }

    public int getIncome() {
        return income;
    }

    public int getExpense() {
        return expense;
    }
}
