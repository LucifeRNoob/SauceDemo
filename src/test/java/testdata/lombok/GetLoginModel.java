package testdata.lombok;

import models.lombok.LoginModel;

public class GetLoginModel {

    public static LoginModel getLoginFirstCase () {
        LoginModel loginModel = LoginModel.builder()
                .userName("standard_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }

    public static LoginModel getLoginSecondCase () {
        LoginModel loginModel = LoginModel.builder()
                .userName("locked_out_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }

    public static LoginModel getLoginThirdCase () {
        LoginModel loginModel = LoginModel.builder()
                .userName("problem_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }

    public static LoginModel getLoginFourthCase () {
        LoginModel loginModel = LoginModel.builder()
                .userName("performance_glitch_user")
                .password("secret_sauce")
                .build();
        return loginModel;
    }
}
