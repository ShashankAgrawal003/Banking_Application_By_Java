import java.util.*;
class BankingApplication{
    public static void main(String[] args){
        BankAccount obj=new BankAccount("Shashank","SH003");
        obj.showMenu();
    }
}

class BankAccount{
    int currentBalance=0;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname,String cId){
        customerName=cname;
        customerId=cId;
    }

    void deposit(int amount){
        if(amount!=0){
            currentBalance=currentBalance+amount;
            previousTransaction=amount;
        }
    }
    void withdraw(int amount){
        if(amount!=0){
            currentBalance=currentBalance-amount;
            previousTransaction=-amount;
        }
    }
    void getPreviousTransactions(){
        if(previousTransaction>0){
            System.out.println("Deposited: "+ previousTransaction);
        }
        else if(previousTransaction<0){
            System.out.println("Withdrawn: "+ Math.abs(previousTransaction));
        }
        else{
            System.out.println("No Transaction occurred");
        }
    }
    void showMenu(){
        char option;
        int amount;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome "+ customerName);
        System.out.println("Your Id is "+ customerId);
        System.out.println();
        System.out.println("A. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");
        do{
            System.out.println("-----------------------------------------");
            System.out.println("Enter Your Option");
            System.out.println("------------------------------------------");
            option=scanner.next().charAt(0);
            switch (option) {
                case 'A': {
                    System.out.println("-----------------------------------------");
                    System.out.println("Current Balance = " + currentBalance);
                    System.out.println("-----------------------------------------");
                    System.out.println();
                    break;
                }
                case 'B' : {
                    System.out.println("-----------------------------------------");
                    System.out.println("Enter the amount to be deposited");
                    System.out.println("-----------------------------------------");
                    amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                }
                case 'C' :{
                    System.out.println("-----------------------------------------");
                    System.out.println("Enter the amount to be withdrawn");
                    System.out.println("-----------------------------------------");
                    amount = scanner.nextInt();
                    withdraw(amount);
                    System.out.println();
                    break;
                }
                case 'D' : {
                    System.out.println("-----------------------------------------");
                    getPreviousTransactions();
                    System.out.println("-----------------------------------------");
                    System.out.println();
                    break;
                }
                case 'E' :
                    break;

                default :
                    System.out.println("Invalid Option!. Please Try Again");
                    break;
            }
            System.out.println("*****************************************");
            System.out.println("ThankYou for using our services");
            System.out.println("*****************************************");
        } while(option!='E');
    }
}