package testdata.builder;

import models.builder.LoginModel;

public class GetLoginModel {

    public static LoginModel getLoginFirstCase() {
        LoginModel login = new LoginModel.Builder()
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .build();
        return login;
    }

    public static LoginModel getLoginSecondCase() {
        LoginModel login = new LoginModel.Builder()
                .setUserName("locked_out_user")
                .setPassword("secret_sauce")
                .build();
        return login;
    }

    public static LoginModel getLoginThirdCase() {
        LoginModel login = new LoginModel.Builder()
                .setUserName("problem_user")
                .setPassword("secret_sauce")
                .build();
        return login;
    }

    public static LoginModel getLoginFourthCase() {
        LoginModel login = new LoginModel.Builder()
                .setUserName("performance_glitch_user")
                .setPassword("secret_sauce")
                .build();
        return login;
    }
}
