package atm;

import java.util.Scanner;
/*
 * A simple Java console application to mimic how an ATM machine would function using array, methods, switch case, and arithmetic operations.
 * @author 88min
 */
public class ATM {

    static Scanner input = new Scanner(System.in);
    //{{card number, pin, balance}}
    static int [][] userData = {{1001, 1234, 999999},
                                {1002, 2468, 300000},
                                {1003, 1111, 1000}};  
    
  public int Login(){
        int accNum = 0;
        System.out.println("WELCOME TO ATM!");
        System.out.print("CARD NUMBER: ");
        int card = input.nextInt();
        System.out.print("PIN: ");
        int pin = input.nextInt();
        if (card == (userData[0][0]) && pin == (userData[0][1])) {
                accNum = 0;
                
            } else if (card == (userData[1][0]) && pin == (userData[1][1])) {
                accNum = 1;
            } else if (card == (userData[2][0]) && pin == (userData[2][1])) {
                accNum = 2;
                
            //mismatch info
            } else {
                System.err.println("CARD NUMBER AND PIN MISMATCHED, TRY AGAIN.");
                Login(); //return to welcome
            }
        return accNum;
  }
 
    public int ShowMenu(){
        int ans;
        System.out.println("\nWELCOME CUSTOMER!");
        System.out.println("[1] Check Balance\n[2] Withdraw\n[3] Pay Bills\n[4] Exit\n");
        ans = input.nextInt();
        return ans;
    }
    
    public void Choice(int userAcc, int answer){
        switch(answer){
            case 1:
                //balance
                System.out.println("CARD NUMBER : " + userData[userAcc][0]);
                System.out.println("Your Balance : " + userData[userAcc][2]);
            break;
            case 2:
                //withdraw
                System.out.println("CARD NUMBER : " + userData[userAcc][0]);
                System.out.print("Enter Amount to Withdraw : ");
                int amount = input.nextInt();
                if(amount <= userData[userAcc][2]){
                    userData[0][2] = userData[userAcc][2] -amount;
                    System.out.println("\nSuccessfully Withdrawn!");
                    System.out.println("Your Remaining Balance : " + userData[userAcc][2]);
                } else {
                    System.err.println("ERROR : Insufficient Balance.");
                }
            break;
            case 3:
                //pay bills
                System.out.println("CARD NUMBER : " + userData[userAcc][0]);
                System.out.print("Enter Amount to Deposit : ");
                int deposit = input.nextInt();
                if(deposit <=userData[userAcc][2]){
                    userData[0][2] = userData[userAcc][2] + deposit;
                            System.out.println("\nSuccessfully Deposited!");
                            System.out.println("Your Remaining Balance : " + userData[userAcc][2]);
                        } else {
                            System.err.println("ERROR : Insufficient Balance.");
                        }
            break;
            case 4:
                 System.err.println("Transaction has been cancelled.");
                  System.exit(0);
            break;
            default:
                  System.err.println("Invalid Input, Try again.");
                  break;
        }
    }
    
    public static void main(String[] args) {
        ATM methodScanner = new ATM();
        
        int account = methodScanner.Login();
        while(true){
            int answer = methodScanner.ShowMenu();
            methodScanner.Choice(account, answer);
        }
    }
}
