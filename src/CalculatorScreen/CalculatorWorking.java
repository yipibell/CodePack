package CalculatorScreen;

public class CalculatorWorking {
    private double mNum1=0;
    private double mNum2=0;
    private double mTotalnum;
    private String mOperator ="",snum;

    public Double SetNum(String StringofNum){
        if (StringofNum==""){return 0.0;};
        Double num= Double.valueOf(StringofNum);
        return num;
    }

    public double totalnum(double num1,double num2,String Operetor){
        double total=0;
        switch (Operetor){
            case "Combining":
                total=num1+num2;
                break;
            case "Subtraction":
                total=num1-num2;
                break;
            case "Multiplication":
                total=num1*num2;
                break;
            case "Division":
                total=num1/num2;
                break;
            case "Percentage":
                total=num1*(num2/100);
                break;
        };
        return total;
    }

    public double getNum1() {
        return mNum1;
    }
    public void setNum1(double num1) {
        mNum1 = num1;
    }
    public double getNum2() {
        return mNum2;
    }
    public void setNum2(double num2) {
        mNum2 = num2;
    }
    public double getTotalnum() {
        return mTotalnum;
    }
    public void setTotalnum(double totalnum) {
        mTotalnum = totalnum;
    }
    public String getOperator() {
        return mOperator;
    }
    public void setOperator(String operator) {
        mOperator = operator;
    }
}
