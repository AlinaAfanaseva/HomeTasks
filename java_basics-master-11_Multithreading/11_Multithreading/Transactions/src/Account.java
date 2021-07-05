import java.text.NumberFormat;

public class Account {
    private NumberFormat fmt = NumberFormat.getCurrencyInstance();
    private long money;
    private String accNumber;

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    private boolean isBlocked;

    public Account() {

    }

    public synchronized void gettingMoney(long fee) {
        money = fee + money;
    }

    public synchronized boolean settingMoney(long fee) {
        money = money - fee;
        return true;
    }

    public synchronized long withdraw(Account toAccountNum, long fee) {
        settingMoney(fee);
        toAccountNum.gettingMoney(fee);
        System.out.println("Good status of transaction!");
        return fee;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", money=" + money +
                ", accNumber='" + accNumber + '\'' +
                ", isBlocked=" + isBlocked +
                '}';
    }
}
