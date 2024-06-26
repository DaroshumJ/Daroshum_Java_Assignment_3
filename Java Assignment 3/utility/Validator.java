package utility;

import java.util.Scanner;

public class Validator {
  
  public Validator() {
    // do nothing
  }

  public int selValidation(Ink ink, Scanner input, int min, int max) {
    boolean valid = false;
    int choice = 0;
    while(!valid) {
      ink.printMenu();
      try {
        choice = input.nextInt(); // throw an exception
        if(choice >= min && choice <= max){
          valid = true;
        }
        else {
          System.out.println("Selection out of range!");
        }
      }
      catch (Exception e) {
        System.out.println("Please read the menu and make a valid selection!");
        valid = false; // just in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    } // while()
    return choice;
  } // isValid()

  public double fundValidation(Ink ink, Scanner input, double balance) {
    double amount = 0;
    boolean valid = false;
    while(!valid) {
      ink.printAddFunds(balance);
      try {
        amount = input.nextDouble(); // throw an exception
        if(amount > 0){
          valid = true;
        }
        else {
          System.out.println("Enter a postive number!");
        }
      } 
      catch (Exception e) {
        System.out.println("Please read the directions!");
        valid = false; // just in case
      } 
      finally { // runs if there's an error or NOT!! always runs
        input.nextLine(); // clear the input
      }
    } // while()
    return amount;
  } // fund validation

  public double depositValidation(Ink ink, Scanner input) {
    double amount = 0;
    boolean valid = false;
    while (!valid) {
        try {
            amount = input.nextDouble();
            if (amount > 0) {
                valid = true;
            } else {
                System.out.println("Enter a positive number.");
            }
        } 
        catch (Exception e) {
            System.out.println("Please enter a valid amount.");
            valid = false;
        } 
        finally {
            input.nextLine(); // clear the input
        }
    }
    return amount;
}

public double withdrawalValidation(Ink ink, Scanner input, double balance) {
    double amount = 0;
    boolean valid = false;
    while (!valid) {
        ink.printWithdrawalFunds(balance);
        try {
            amount = input.nextDouble();
            if (amount > 0 && amount <= balance) { // Validate that the amount is positive and within the available balance
                valid = true;
            } 
            else {
                if (amount <= 0) {
                    System.out.println("Withdrawal amount must be positive");
                }
                else {
                    System.out.println("Insufficient funds. Enter a smaller withdrawal amount");
                }
            }
        } catch (Exception e) {
            System.out.println("Please enter a valid amount.");
            valid = false;
        } finally {
            input.nextLine(); // clear the input
        }
    }
    return amount;
}
} // class

  