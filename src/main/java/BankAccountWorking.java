import java.util.Calendar;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BankAccountWorking  {
    public static void main(String[] args) throws IOException {

        BankAccount bankAccount1 = new BankAccount();

        BankAccount bankAccount2 = new BankAccount(
                "Michael",
                Calendar.getInstance().getTime(),
                "0123456789",
                100.0
        );

        FileOutputStream fos = new FileOutputStream("account.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(bankAccount2);
        oos.flush();
        oos.close();

        //System.out.println("BankAccount1: " + bankAccount1.getMoneyAmount());
        //System.out.println("BankAccount2: " + bankAccount2.getMoneyAmount());

        Scanner scanner = new Scanner(System.in);
        try {
            double value = scanner.nextDouble();
            bankAccount2.cashIn(value);
        } catch (Exception e) {
            System.out.println(e);
        }

        // System.out.println("BankAccount1: " + bankAccount1.getMoneyAmount());
        // System.out.println("BankAccount2: " + bankAccount2.getMoneyAmount());

        BankAccount bankAccount3 = new BankAccount(bankAccount2);

        try {
            double value = scanner.nextDouble();
            bankAccount3.cashOut(value);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("BankAccount1: " + bankAccount1.getMoneyAmount());
        System.out.println("BankAccount2: " + bankAccount2.getMoneyAmount());
        System.out.println("BankAccount3: " + bankAccount3.getMoneyAmount());

    }
}
