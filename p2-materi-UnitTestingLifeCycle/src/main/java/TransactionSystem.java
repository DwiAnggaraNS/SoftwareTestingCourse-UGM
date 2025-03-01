public class TransactionSystem {

    private int balance;

    public TransactionSystem(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        else {
            throw new IllegalArgumentException("Deposit amount must be greater than 0");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            if (amount <= this.balance) {
                this.balance -= amount;
            }
            else {
                throw new IllegalArgumentException("Withdraw amount must be less than or equal to balance");
            }
        }
        else {
            throw new IllegalArgumentException("Withdraw amount must be greater than 0");
        }
    }

    public int getBalance() {
        return this.balance;
    }

    public void resetBalance(int amount) {
        this.balance = amount;
    }

    public static void openConnection() {
        System.out.println("Opening connection to server");
    }

    public static void closeConnection() {
        System.out.println("Closing connection to server");
    }

}
