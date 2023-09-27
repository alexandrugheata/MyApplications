import java.util.Scanner;

public class Banking {
    
    public static void main(String[] args) {
        Scanner name_scan = new Scanner(System.in);
        System.out.println("Please enter your name");
        String name = name_scan.nextLine();
        int id = (int)Math.random()*50+50;
        BankAccount obj1 = new BankAccount(name, id);
        obj1.showMenu();
        name_scan.close();
        }

}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    Integer customerId;

    BankAccount(String cname, int cid){

        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount){

        if(amount != 0) {
            balance = balance +amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount){
        if(amount != 0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction(){
        if(previousTransaction > 0){
            System.out.println("Deposited: " + previousTransaction);

        }
        else if(previousTransaction < 0){
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));

        }
        else
        {
            System.out.println("No transactin occured");
        }
    }

    void showMenu(){

        char option = '\0';//unicode initial value
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\n");
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("=====================================================================");
            System.out.println("Please ENTER an option");
            System.out.println("=====================================================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("----------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("----------------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("----------------------------");
                    System.out.println("Enter the amount you want to deposit:");
                    System.out.println("----------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("----------------------------");
                    System.out.println("Enter the amount you want to withdraw");
                    System.out.println("----------------------------");
                    int amount_2 = scanner.nextInt();
                    withdraw(amount_2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("----------------------------");
                    getPreviousTransaction();
                    System.out.println("----------------------------");
                    System.out.println("\n");
                    break;   
                case 'E':
                    System.out.println("***************************************");
                    break;
                default:
                    System.out.println("Invalid Option!! Please enter again");
                    break;
            }

        }while(option != 'E');  
        System.out.println("Thank You for using our services");
        scanner.close();
    }

}