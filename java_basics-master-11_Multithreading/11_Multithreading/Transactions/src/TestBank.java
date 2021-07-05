import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBank {

    @Before
    public void setUp() {
        final Bank bank = new Bank();
        final Account account1 = new Account();
        account1.setAccNumber("213");
        account1.setMoney(300);
        final Account account2 = new Account();
        account2.setAccNumber("2423");
        account2.setMoney(800);
        bank.addAccount(account1);
        bank.addAccount(account2);
        
       int processor = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < processor; i++){
            Thread newThread = new Thread();
            bank.transfer(account2, account1, 300);
            bank.transfer(account1, account2, 100);
            newThread.start();
        }
    }


    @Test
    @org.junit.jupiter.api.Test
    public void testAddAccount() {
        HashMap<String, Account> accounts = new HashMap<>();
        final Account account1 = new Account();
        accounts.put(account1.getAccNumber(), account1);
        if (accounts.isEmpty()){
            System.out.println("Does not works");
        }

    }


    @Test
    @org.junit.jupiter.api.Test
    public void testTransfer() {
        Account fromAccountNum = new Account();
        long fee = 49000;
        boolean actual = fromAccountNum.settingMoney(fee);
        boolean expected = !fromAccountNum.isBlocked();
        Assert.assertEquals(expected, actual);

    }


}
