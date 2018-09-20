
//นายดิศรณ์  ฐิติกรโกวิท  5810400990
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Label textInc;
    @FXML
    private Label textExpense;
    @FXML
    private TextField textEdit;

    @FXML
    private TextField inc;

    @FXML
    private TextField exp;

    @FXML
    private Label summary;

    private DailyAccount dailyAccount = new DailyAccount();

    public void initialize(){
        int income = 0;
        int expense = 0;

        try {
            Path fileIncome = Paths.get("D:\\income.txt");
            BufferedReader readerIncome = Files.newBufferedReader(fileIncome ,
                    StandardCharsets.UTF_8);
            String lineIncome = null;
            while ((lineIncome = readerIncome.readLine()) != null) {
                dailyAccount.incomeAccount.add(Integer.parseInt(lineIncome));
                income += Integer.parseInt(lineIncome);
            }
            readerIncome.close();

            Path fileExpense = Paths.get("D:\\expense.txt");
            BufferedReader readerExpense = Files.newBufferedReader(fileExpense ,
                    StandardCharsets.UTF_8);
            String lineExpense = null;
            while ((lineExpense = readerExpense.readLine()) != null) {
                dailyAccount.expenseAccount.add(Integer.parseInt(lineExpense));
                expense += Integer.parseInt(lineExpense);
            }
            readerExpense.close();
        } catch (IOException e) {
            System.err.println("IOException: " + e.getMessage());
        }

        if (income != 0){
            dailyAccount.setIncome(income);
            dailyAccount.setExpense(expense);
            dailyAccount.setMoneyPocket(income - expense);
            summary.setTextFill(Color.GREEN);
            summary.setText(dailyAccount.show());

        }
    }
    @FXML
    public void receive_Money(ActionEvent e) {
        int money = Integer.parseInt(inc.getText());

               dailyAccount.receiveMoney(money);
            summary.setTextFill(Color.GREEN);
            summary.setText(dailyAccount.show());
            inc.clear();

            try {
                Path file = Paths.get("D:\\income.txt");
                BufferedWriter writer = Files.newBufferedWriter(file,
                        StandardCharsets.UTF_8, StandardOpenOption.APPEND);

                writer.write(money + "");
                writer.newLine();
                writer.close();
                textInc.setText(dailyAccount.incomeAccount.toString());
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
                //income ครั้งแรก
                try {
                    Path file = Paths.get("D:\\income.txt");
                    BufferedWriter writer = Files.newBufferedWriter(file,
                            StandardCharsets.UTF_8);

                    writer.write(money+"");
                    writer.newLine();
                    writer.close();
                    textInc.setText(dailyAccount.incomeAccount.toString());
                } catch (IOException ex2) {
                    System.err.println("IOException: " + ex2.getMessage());
                }
            }

    }


    @FXML
    public void spend_Money(ActionEvent e) throws NotEnoughMoneyException{

        int money = Integer.parseInt(exp.getText());
        if (money > dailyAccount.getMoneyPocket()){
            summary.setTextFill(Color.GREEN);
            summary.setText("Your money is not enough to pay."+"\nPlease try again."+"\nBalance : "+dailyAccount.getMoneyPocket());
            exp.clear();
        }else{

                dailyAccount.spendMoney(money);
                summary.setTextFill(Color.GREEN);
                summary.setText(dailyAccount.show());
                exp.clear();

                try {
                    Path file = Paths.get("D:\\expense.txt");
                    BufferedWriter writer = Files.newBufferedWriter(file,
                            StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                    writer.write(money + "");
                    writer.newLine();
                    writer.close();
                    textExpense.setText(dailyAccount.expenseAccount.toString());
                } catch (IOException ex) {
                    System.err.println("IOException: " + ex.getMessage());
                    //expense ครั้งแรก
                    try {
                        Path file = Paths.get("D:\\expense.txt");
                        BufferedWriter writer = Files.newBufferedWriter(file,
                                StandardCharsets.UTF_8);
                        writer.write(money+"");
                        writer.newLine();
                        writer.close();
                        textExpense.setText(dailyAccount.expenseAccount.toString());
                    } catch (IOException ex2) {
                        System.err.println("IOException: " + ex2.getMessage());
                    }

            }
        }
    }
    @FXML
    public void edit(ActionEvent e){

        int money = 0;

        String[] edit = textEdit.getText().split("/");
        System.out.println(edit);


        if (edit[0].equals("income")){
            dailyAccount.edit(textEdit.getText());

            try {
                Path file = Paths.get("D:\\income.txt");
                BufferedWriter writer = Files.newBufferedWriter(file,
                        StandardCharsets.UTF_8);
                for (int i = 0; i < dailyAccount.incomeAccount.size(); i++) {
                    money += dailyAccount.incomeAccount.get(i);
                    writer.write(dailyAccount.incomeAccount.get(i) + "");
                    writer.newLine();
                }
                writer.close();
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
            }

            textInc.setText(dailyAccount.getIncomeAccount().toString());

            dailyAccount.setIncome(money);
            textEdit.clear();
            summary.setText(dailyAccount.show());
            summary.setTextFill(Color.GREEN);

        }else if (edit[1].equals("expense")){
            dailyAccount.edit(textEdit.getText());

            try {
                Path file = Paths.get("D:\\expense.txt");
                BufferedWriter writer = Files.newBufferedWriter(file,
                        StandardCharsets.UTF_8);
                for (int i = 0; i < dailyAccount.expenseAccount.size(); i++) {
                    money += dailyAccount.expenseAccount.get(i);
                    writer.write(dailyAccount.expenseAccount.get(i) + "");
                    writer.newLine();
                }
                writer.close();
            } catch (IOException ex) {
                System.err.println("IOException: " + ex.getMessage());
            }

            textExpense.setText(dailyAccount.getExpenseAccount().toString());

            dailyAccount.setExpense(money);
            textEdit.clear();
            summary.setText(dailyAccount.show());
            summary.setTextFill(Color.GREEN);

        }

    }

    }




