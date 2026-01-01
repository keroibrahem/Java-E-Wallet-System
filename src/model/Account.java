package model;

public class Account {
    private String username;
    private String password;
    private double balance;
    private String accountType;
    private String phone;
    private int age;
    private boolean isLogin;

    public Account(String username, String password, double balance, int age, String phone) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.accountType = "User";
        this.age = age;
        this.phone = phone;
        this.isLogin = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }
    
    
    public boolean getIsLogin() {
        return isLogin;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setName(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }
}
