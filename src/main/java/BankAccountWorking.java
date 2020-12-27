// При запуске, программа должна проверять наличие файла "account.dat" в текущей директории,
// и если он существует - десериализовать из этого файла экземпляр класса BankAccount (предполагается,
// что в этом файле сериализован только один класс, представляющий аккаунт единственного пользователя программы).
//Если такого файла нет, то нам надо создать новый экземпляр класса BankAccount, спросив данные у пользователя
// (имя, номер счета, итд).
//Теперь у нас есть экземпляр класса (десериализованный, либо созданный с нуля) - и мы выводим приветственное
// сообщение пользователю "Здравствуйте, <ФИО>!\nНомер вашего счета: <номер счета>\nОстаток средств: <деньги>".
//После этого, делаем цикл (можно использовать цикл while), который спрашивает у пользователя сумму денег,
// которую надо прибавить к текущему балансу счета. Она может быть положительной или отрицательной
// (положить/снять деньги). Если пользователь вводит 0, то выходим из цикла и заканчиваем работу программы.
//После выхода из цикла, у нас есть экземпляр BankAccount, который мы, возможно, изменили. Сериализуем его
// в файл "account.dat", чтобы при следующем запуске программы, пользователю сразу вышло приветственное
// сообщение со всей актуальной информацией!

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class BankAccountWorking  {
    public static void main(String[] args) throws IOException {

        //BankAccount bankAccount2 = new BankAccount(
        //        "Michael",
        //        Calendar.getInstance().getTime(),
        //        "0123456789",
        //        100.0
        //);

       BankAccount bankAccount = new BankAccount();
       File accountFile = new File("account.dat");
       if (accountFile.exists()) { // check if account.dat exists
            // bankAccount deserialization
            FileInputStream fileInputStream = new FileInputStream("account.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            bankAccount = (BankAccount)objectInputStream.readObject();
        }
            else {
                Scanner scanner = new Scanner(System.in);
                try {
                    System.out.println("Enter the name:");
                    bankAccount.setName = scanner.nextLine();
                    bankAccount.setDateOfCreation = Calendar.getInstance().getTime();
                    System.out.println("Enter the account number:");
                    bankAccount.setAccountNumber = scanner.nextLine();
                    System.out.println("Enter the money amount:");
                    bankAccount.setMoneyAmount = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println(e);
                }
        }
        // bankAccount serialization
        FileOutputStream fileOutputStream = new FileOutputStream("account.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(bankAccount);
        objectOutputStream.flush();
        objectOutputStream.close();

        // cashing in
        Scanner scanner = new Scanner(System.in);
        try {
            double value = scanner.nextDouble();
            bankAccount.cashIn(value);
        } catch (Exception e) {
            System.out.println(e);
        }

        // System.out.println("BankAccount: " + bankAccount.getMoneyAmount());

        // cashing out
        try {
            double value = scanner.nextDouble();
            bankAccount.cashOut(value);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
