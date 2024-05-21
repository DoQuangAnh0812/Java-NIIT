package PracticalWork;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		UserInfo[] users = {
                new UserInfo("001", "Cookie", "123456", 10000000),
                new UserInfo("002", "John", "123467", 5000000)
        };

        ATM atm = new ATM(users);
        Scanner scanner = new Scanner(System.in);
        String id, password;
        boolean LoggedIn = false;
        UserInfo currentUser = null;
        
        while (!LoggedIn) {
            System.out.println("Input ID : ");
            id = scanner.nextLine();
            System.out.println("Input password : ");
            password = scanner.nextLine();
            LoggedIn = atm.authenticate(id, password);

            if (!LoggedIn) {
                System.out.println("Please re-enter the correct information.");
            } else {
                for (UserInfo user : users) {
                    if (user.getId().equals(id)) {
                        currentUser = user;
                        break;
                    }
                }
                System.out.println("Welcome, Mr." + currentUser.getName());
                atm.checkBalance(currentUser); 
                System.out.println("------------------------");
            }
        }
		Scanner sc = new Scanner(System.in); 
		int choice;
		System.out.println("Enter your choice (1-3) :");
        System.out.println("------------------------");
		while(true)  {
			System.out.println("1. Withdraw money");
            System.out.println("------------------------");
			System.out.println("2. Check balance");                 
			System.out.println("------------------------");
			System.out.println("3. Leaveeee");			
            System.out.println("------------------------");
			choice = sc.nextInt();
			sc.nextLine();
			if (choice >= 1 || choice <= 3) {
			switch (choice) {
				case 1: 
					System.out.println("Of course, ");
					atm.withdraw(currentUser, scanner);
					break;
				case 2: 
					System.out.println("Of course, ");
					atm.checkBalance(currentUser);
					break;
				case 3: 
					System.out.println("Goodbye, see you again! <3");
					return;
				}
			} else {
					System.out.println("Invalid choice, please try again");
				}
			} 
		} 
	}

/*try (Scanner sc = new Scanner(System.in)) {
int choice;
System.out.println("Enter your choice :");
while(true)  {
	System.out.println("1. Withdraw money");
	System.out.println("2. Check balance");
	System.out.println("3. Leaveeee");			
	choice = sc.nextInt();
	sc.nextLine();
	if (choice >= 1 || choice <= 3) {
	switch (choice) {
		case 1: 
			System.out.println("Of course, ");
			atm.withdraw(currentUser, scanner); 
			break;
		case 2: 
			System.out.println("Of course, ");
			atm.checkBalance(currentUser);
			break;
		case 3: 
			System.out.println("Goodbye, see you again!");
			return;
		}
	} else {
			System.out.println("Invalid choice, please try again");
		}
	}
*/

