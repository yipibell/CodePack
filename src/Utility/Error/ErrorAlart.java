package Utility.Error;


import javafx.scene.control.Alert;

public class ErrorAlart {
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public ErrorAlart(int ErrorNumber) {
        alert.setTitle("Error");
        alert.setHeaderText("Ops... Looks like somting is wrong");
        alert.setContentText(Error(ErrorNumber));
        alert.showAndWait();
    }

    private String Error(int ErrorNumber) {
        String error;
        switch (ErrorNumber) {
            case 0:
                error = "Error Number #00, You must check at lest one login to export";
                break;
            case 1:
                error = "Error Number #01, You must select a location.";
                break;
            case 2:
                error = "Error Number #02, You must enterd a Username.";
                break;
            case 3:
                error = "Error Number #03, You must enterd a Password.";
                break;
            case 4:
                error = "Error Number #04, You must select an item to use that option.";
                break;
            case 5:
                error = "Error Number #05, You chose Hour, Minute, and a Date.";
                break;
            case 6:
                error = "Error Number #06, You can't set an alarm for a past time.";
                break;
            case 7:
                error = "Error Number #07, You can't set 2 alarms at the same time.";
                break;
            case 8:
                error = "Error Number #08, Not all the text was generated to code.";
                break;
            default:
                error = "Error not specified.";
                break;
        }
        return error;
    }
}
