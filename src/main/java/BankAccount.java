import java.util.Calendar;
import java.util.Date;
import java.io.Serializable;
// import java.util.Arrays;

public class BankAccount implements Serializable {
    private String name;
    private Date dateOfCreation;
    private String accountNumber;
    private double moneyAmount;

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

    public String getName() {
        return name;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getMoneyAmount() {
        return moneyAmount;
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
