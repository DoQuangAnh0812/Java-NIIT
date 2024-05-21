package PracticalWork;

import java.util.Scanner;


public class ATM {
    private UserInfo[] users;

    public ATM(UserInfo[] users) {
        this.users = users;
    }

    public boolean authenticate(String id, String password) {
        for (UserInfo user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void withdraw(UserInfo user, Scanner scanner) {
        System.out.println("Input the amount you want to withdraw : ");
        int amount = 0;
        boolean ValidInput = false;
        while (!ValidInput) {
            try {
                amount = Integer.parseInt(scanner.nextLine());
                if (amount > user.getBalance()) {
                    System.out.println("The amount you withdraw is more than the amount you have in the account, please try again");
                } else if (amount < 0) {
                	System.out.println("The amount you withdraw must be greater than zero, please try again");
                } else {
                	ValidInput = true;
                } 
            } catch (NumberFormatException e) {
                System.out.println("It has to be a number, please try again");
            }
        }
        user.setBalance(user.getBalance() - amount);
        System.out.println("Withdraw successfully, the remainer of your account is :" + user.getBalance() + "$");
    }

    public void checkBalance(UserInfo user) {
        System.out.println("The amount of money in your account is : " + user.getBalance() + "$");
    }
}


