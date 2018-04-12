package CalculatorScreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CalculatorController {
    public Label CurrentNumber;
    public Label History;
    private String mOperetor = "", Number = "", HistoryText = "";
    private CalculatorWorking mWorking = new CalculatorWorking();

    @FXML
    public void setCurrentNumber() {
        if (Number == "" && mOperetor == "") {
            CurrentNumber.setText("you entered nothing");
        } else {
            CurrentNumber.setText(mOperetor + Number);
        }
    }

    @FXML
    public void setHistory() {
        if (mWorking.getOperator() == "") {
            HistoryText += mWorking.getNum1();
        }//if its 1st num
        else if (mWorking.getOperator().equals("ChangingSign")) {
            setOperetorSign();
            HistoryText += mOperetor + "=" + mWorking.getTotalnum();
        } else {
            setOperetorSign();
            HistoryText += mOperetor + mWorking.getNum2() + "=" + mWorking.getTotalnum();
        }
        if (HistoryText.length() > 40) {
            char[] temporary = HistoryText.toCharArray();
            HistoryText = "... ";
            for (int i = (temporary.length - 35); i < temporary.length; i++) {
                HistoryText += temporary[i];
            }
        }
        History.setText(HistoryText);
    }

    private void setOperetorSign() {
        switch (mWorking.getOperator()) {
            case "Combining":
                mOperetor = "+";
                break;
            case "Subtraction":
                mOperetor = "-";
                break;
            case "Multiplication":
                mOperetor = "*";
                break;
            case "Division":
                mOperetor = "/";
                break;
            case "ChangingSign":
                mOperetor = "*(-1)";
                break;
            case "Percentage":
                mOperetor = "%";
                break;
        }
    }

    private void Operetion(String operetion) {
        if (mWorking.getOperator() != "" && Number.equals("")) {
            mWorking.setOperator(operetion);
            if (operetion.equals("Equals")) mWorking.setOperator("Combining");
            if (operetion.equals("ChangingSign") && Number.equals("")) {
                mWorking.setTotalnum(mWorking.getTotalnum() * (-1));
                mWorking.setNum1(mWorking.getTotalnum());
            }
            setOperetorSign();
            setCurrentNumber();
        } else if (operetion.equals("Equals")) {
            mWorking.setNum2(mWorking.SetNum(Number));
            mWorking.setTotalnum(mWorking.totalnum(mWorking.getNum1(), mWorking.getNum2(), mWorking.getOperator()));
            setHistory();
            mWorking.setOperator("Combining");
            setOperetorSign();
            Number = "";
            setCurrentNumber();
            mWorking.setNum1(mWorking.getTotalnum());
        } else if (operetion.equals("ChangingSign")) {
            Number = "" + mWorking.SetNum(Number) * (-1);
            setCurrentNumber();
        } else if (mWorking.getOperator().equals("")) {
            mWorking.setNum1(mWorking.SetNum(Number));
            Number = "";
            setHistory();
            mWorking.setOperator(operetion);
            setOperetorSign();
            setCurrentNumber();
        } else {
            mWorking.setNum2(mWorking.SetNum(Number));
            mWorking.setTotalnum(mWorking.totalnum(mWorking.getNum1(), mWorking.getNum2(), mWorking.getOperator()));
            setHistory();
            mWorking.setOperator(operetion);
            setOperetorSign();
            Number = "";
            setCurrentNumber();
            mWorking.setNum1(mWorking.getTotalnum());
        }
    }

    public void Combining(ActionEvent event) {
        Operetion("Combining");
    }

    public void Subtraction(ActionEvent event) {
        Operetion("Subtraction");
    }

    public void Multiplication(ActionEvent event) {
        Operetion("Multiplication");
    }

    public void Division(ActionEvent event) {
        Operetion("Division");
    }

    public void ChangingSign(ActionEvent event) {
        Operetion("ChangingSign");
    }

    public void Percentage(ActionEvent event) {
        Operetion("Percentage");
    }

    public void No0(ActionEvent event) {
        Number += "0";
        setCurrentNumber();
    }

    public void No1(ActionEvent event) {
        Number += "1";
        setCurrentNumber();
    }

    public void No2(ActionEvent event) {
        Number += "2";
        setCurrentNumber();
    }

    public void No3(ActionEvent event) {
        Number += "3";
        setCurrentNumber();
    }

    public void No4(ActionEvent event) {
        Number += "4";
        setCurrentNumber();
    }

    public void No5(ActionEvent event) {
        Number += "5";
        setCurrentNumber();
    }

    public void No6(ActionEvent event) {
        Number += "6";
        setCurrentNumber();
    }

    public void No7(ActionEvent event) {
        Number += "7";
        setCurrentNumber();
    }

    public void No8(ActionEvent event) {
        Number += "8";
        setCurrentNumber();
    }

    public void No9(ActionEvent event) {
        Number += "9";
        setCurrentNumber();
    }

    public void DecimalPoint(ActionEvent event) {
        Number += ".";
        setCurrentNumber();
    }

    public void Delete(ActionEvent event) {
        char[] temp = Number.toCharArray();
        Number = "";
        for (int i = 0; i < (temp.length - 1); i++) {
            Number += temp[i];
        }
        setCurrentNumber();
    }

    public void Equals(ActionEvent event) {
        Operetion("Equals");
    }

    public void Clear(ActionEvent event) {
        History.setText("We are Clear");
        mWorking.setNum1(0);
        mWorking.setNum2(0);
        mWorking.setTotalnum(0);
        mWorking.setOperator("");
        Number = "";
        mOperetor = "";
        HistoryText = "";
        CurrentNumber.setText("We are Clear");
    }
}
