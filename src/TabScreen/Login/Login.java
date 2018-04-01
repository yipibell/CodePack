package TabScreen.Login;

import javafx.scene.control.CheckBox;

public class Login {
    private String UserName;
    private String PassWord;
    private String SiteURL;
    private CheckBox Check;

    public Login(String userName, String passWord, String siteURL) {
        this.UserName = userName;
        this.PassWord = passWord;
        this.SiteURL = siteURL;
        this.Check = new CheckBox();
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    public String getSiteURL() {
        return SiteURL;
    }

    public void setSiteURL(String siteURL) {
        SiteURL = siteURL;
    }

    public CheckBox getCheck() {
        return Check;
    }

    public void setCheck(CheckBox check) {
        Check = check;
    }

    @Override
    public String toString() {
        return "Login:" +
                "UserName=" + UserName +
                ", PassWord='" + PassWord +
                ", SiteURL='" + SiteURL + "\n";
    }
}