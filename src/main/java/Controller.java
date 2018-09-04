
//นายดิศรณ์  ฐิติกรโกวิท  5810400990
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField mP;
    @FXML
    private TextField ic;
    @FXML
    private TextField exp;
    @FXML
    private Label acc;


    private DailyAccount dailyAccount;


    @FXML
    public void createAccount(ActionEvent event){
        dailyAccount= new DailyAccount();
        dailyAccount.setMoneyPocket(Integer.parseInt(mP.getText()));
        acc.setText(dailyAccount.show());
        mP.clear();
    }


    @FXML
    public void income(ActionEvent event){
        dailyAccount.receiveMoney(Integer.parseInt(ic.getText()));
        acc.setText(dailyAccount.show());
        ic.clear();
    }
    @FXML
    public void expense(ActionEvent event) throws NotEnoughMoneyException {
        dailyAccount.spendMoney(Integer.parseInt(exp.getText()));
        acc.setText(dailyAccount.show());
        exp.clear();
    }


}
