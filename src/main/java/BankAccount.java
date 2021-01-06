import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
// import java.util.Arrays;

public class BankAccount implements Serializable {
    private static String name; // "static" added
    private static Date dateOfCreation; // "static" added
    private static String accountNumber; // "static" added
    private static double moneyAmount; // "static" added

    BankAccount() {
        this.name = "UNKNOWN";
        this.dateOfCreation = Calendar.getInstance().getTime();
        this.accountNumber = "0000000000";
        this.moneyAmount = 0.0;
    }

    BankAccount(String name, Date dateOfCreation, String accountNumber, double moneyAmount)
    {
        this.name = name;
        this.dateOfCreation = dateOfCreation;
        this.accountNumber = accountNumber;
        this.moneyAmount = moneyAmount;
    }

    BankAccount(BankAccount bankAccount) {
        this.name = bankAccount.name;
        this.dateOfCreation = bankAccount.dateOfCreation;
        this.accountNumber = bankAccount.accountNumber;
        this.moneyAmount = bankAccount.moneyAmount;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public static String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static double getMoneyAmount() {
        return moneyAmount;
    }

    public void setMoneyAmount(double moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    public double cashIn(double value) throws Exception {
        if (value > 0.0) {
            moneyAmount += value;
        } else {
            throw new Exception("Value must be positive!");
        }

        return moneyAmount;
    }

    public double cashOut(double value) throws Exception {
        if (value > 0.0) {
            if (moneyAmount > value) {
                moneyAmount -= value;
            }
            else {
                throw new Exception("Not enough money!");
            }
        } else {
            throw new Exception("Value must be positive!");
        }

        return moneyAmount;
    }

    @Override
    public String toString() {
        return "CurrentAccount: " +
                "Name = " + name +
                "Date of Creation = " + dateOfCreation +
                "Account Number = " + accountNumber +
                "Money Amount = " + moneyAmount;
    }
}
