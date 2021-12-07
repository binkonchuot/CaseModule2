package CaseModule2.model;

import java.io.Serializable;

public class Account implements Serializable {

    private String userName;
    private String passWord;
//    private int role;  //phan quyen

    public Account() {
    }
    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

}
