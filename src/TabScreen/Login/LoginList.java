package TabScreen.Login;

import Utility.CommonCommands;
import Utility.FileEditing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LoginList {
    private CommonCommands CC = new CommonCommands();
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation = "src/TabScreen/Login/SavedLoginList.txt";
    private List<Login> LoginList = new ArrayList();

    public LoginList() {
    }

    public List<Login> getLoginList() {
        return LoginList;
    }

    public void SaveLogins() {
        String saveLogin = "";
        for (Login Login : LoginList) {
            saveLogin += LoginToString(Login);
        }
        fe.export(SaveFilelocation, saveLogin);
    }

    ;

    public void LoadLogins() {
        LoginList.clear();
        try (FileInputStream fis = new FileInputStream(SaveFilelocation);
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis));) {
            String Load;
            while ((Load = reader.readLine()) != null) {
                if (Load.equals("")) break;
                String[] arg = Load.split("\\|");
                AddLogin(new Login(arg[0], arg[1], arg[2]));
            }
        } catch (IOException ioe) {
            System.out.println("Problem saving file " + SaveFilelocation);
            ioe.printStackTrace();
        }
    }

    public void AddLogin(Login Login) {
        this.LoginList.add(Login);
    }

    ;

    private String LoginToString(Login Login) {
        String AsString =
                Login.getUserName() + "|" +
                        Login.getPassWord() + "|" +
                        Login.getSiteURL() + "\n";
        return AsString;
    }
}
