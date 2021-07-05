import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;

    public Bank(){
        accounts = new HashMap<>();

    }

    public static void main(String[] args){
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

    public void addAccount(Account account){
        accounts.put(account.getAccNumber(), account);
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
        for (Map.Entry entry : accounts.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }

    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public synchronized void transfer(Account fromAccountNum, Account toAccountNum, long fee) throws InterruptedException {
        if (fromAccountNum.isBlocked() || toAccountNum.isBlocked() ){
            System.out.println("Account is blocked");
            return;
        }
        long balance = getBalance(fromAccountNum.getAccNumber());
        if (balance < fee){
            System.out.println("Does not works. Balance: " + balance);
            System.out.println("Withdraw sum: " + fee);
            return;
        }
        if (fee <= 0){
            System.out.println("Un correct sum");
            return;
        }

        if (fee > 50000){
            if(isFraud(fromAccountNum.getAccNumber(),toAccountNum.getAccNumber(),fee)){
                fromAccountNum.setBlocked(true);
                toAccountNum.setBlocked(true);
                return;
            }
        }
        fromAccountNum.withdraw(toAccountNum, fee);

        System.out.println(fromAccountNum.toString());
        System.out.println("↓↓↓↓↓↓↓ SEND "+ fee + " ↓↓↓↓↓↓↓");
        System.out.println(toAccountNum.toString());
    }


    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public synchronized long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }


}
