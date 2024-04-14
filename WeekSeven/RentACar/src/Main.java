import Business.UserManager;
import Core.Database;
import Core.Helper;
import Entity.User;
import View.AdminView;
import View.LoginView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args){
        Helper.setTheme();
        LoginView loginView = new LoginView();
    }
}