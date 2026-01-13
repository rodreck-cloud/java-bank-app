import java.util.Scanner;

public class BankApp{
	
	static double balance = 1000.00;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String [] args){

	int option;

	System.out.println("Welcome to United Banked");

	do{
	
	System.out.println("\n1.Check Balance");
	System.out.println("2.Deposit");
	System.out.println("3.Withdraw");
	System.out.println("4.Exit");
	System.out.println("Choose option");

	option = scanner.nextInt();

	switch(option){
		case 1: checkBalance();
		break;
		case 2: deposit();
		break;
		case 3: withdraw();
		break;
		case 4:
	System.out.println("Thank you for using United Bank");
		break;
		default:
	System.out.println("Invalid option!");
	}
	} while(option !=4);
	}
    static void checkBalance(){ System.out.println("Current Balance R" 
    + balance);
	}
	static void deposit(){
	System.out.println("Enter amount:");

	double amount = scanner.nextDouble();
	balance += amount;
	System.out.println("Deposited: R" +amount);
	}	
	static void withdraw(){
	System.out.println("Enter amount: ");
	double amount = scanner.nextDouble();

	if(amount > balance){ System.out.println("Insufficient funds!");
	}else{ balance -= amount;
	System.out.println("Withdraw: R" + amount);
	
	}
   }

}
