package main.java;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileName =
                "C:\\Users\\tsakw\\OneDrive\\Documents\\Computer_programming\\Python_ex_projects\\requirements.txt.txt";
        File file = new File(fileName);
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNext()) {
                System.out.println(reader.next());
            }
        } catch (Exception e) {
            System.out.println("I cannot read the file: fileName");
        }

        User user1 = new User("Thakgalo", "Mtimkhulu");
        User user2 = new User("Tebalelo Adinah", "Jones");
        User user3 = new User("Palesa Ophelia", "Zulu");
        User user4 = new User("Ntsako Wessels", "Smith");
        User user5 = new User("Pios", "Jackson");

        Account account11 = new Account(user1);
        Account account21 = new Account(user2);
        Account account31 = new Account(user3);
        Account account12 = new Account(user1);
        Account account51 = new Account(user5);

        account11.deposit(100);
        account21.deposit(2000);
        account31.deposit(1000);
        account12.deposit(700);
        account51.deposit(3000);

        account11.deposit(30);
        account21.send(200, account31);
        account31.send(187, account11);

        account11.withdraw(200);

        for(Transaction x: Transaction.getTransactionsList()){
            System.out.println(x.toPrintable());
        }
        System.out.println(user1.getNetBalance());
        for(Transaction x: account31.getTransactionsList()){
            System.out.println(x.toPrintable());
        }

    }
}