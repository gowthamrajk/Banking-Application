import java.util.Scanner;

class BankAccount
{
	int balance;
	int previousTransaction;
	String customerName;
	String AccountNumber;
	
	BankAccount(String customerName,String AccountNumber)
	{
		this.AccountNumber=AccountNumber;
		this.customerName=customerName;
	}
	void deposit(int amount)
	{
		if(amount!=0)
		{
		    balance+=amount;
		    previousTransaction=amount;
		}
	}
	void withDraw(int amount)
	{
		if(amount!=0)
		{
			balance-=amount;
			previousTransaction = -amount;
		}
	}
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
			System.out.println("Deposited Amount is: "+previousTransaction);
		if(previousTransaction < 0)
		    System.out.println("Withdrawn amount is: "+Math.abs(previousTransaction));
		else
			System.out.println("Thankyou for you valuable time :)");
	}
	void ServiceRating()
	{
		char feedback='\0';
		Scanner sc=new Scanner(System.in);
		System.out.println("Give your Ratings Below ");
		System.out.println("1) Awsome");
		System.out.println("2) VeryGood");
		System.out.println("3) Good");
		System.out.println("4) Satisfied");
		System.out.println("5) Poor");
		System.out.println();
		System.out.println("Enter your Rating:");
		feedback=sc.next().charAt(0);
		System.out.println();
		if(feedback=='1'||feedback=='2'||feedback=='3')
			System.out.println("Thankyou "+customerName+" for your valuable feedback :) ");
		else if(feedback=='4'||feedback=='5')
			System.out.println("We will improve our service much better. Thankyou :) ");
		else
			System.out.println(" *** Thankyou for Your Valuable Time *** ");
		
	}
	void showMenu()
	{
		char option='\0';
		Scanner sc=new Scanner(System.in);
		System.out.println("Hello "+customerName+". Welcome to ABCD Bank");
		System.out.println("Your AccountNumber is "+AccountNumber);
		System.out.println();
		System.out.println("A) Check Account Balance");
		System.out.println("B) Deposit Amount");
		System.out.println("C) Withdraw Amount");
		System.out.println("D) Check Previous Transaction");
		System.out.println("E) Exit");
		System.out.println();
		
		do 
		{
			System.out.println("#################################################################################################");
			System.out.println("Enter Your Option");
			System.out.println("#################################################################################################");
			option=sc.next().charAt(0);
			System.out.println();
			switch(option)
			{
			
			case 'A':
				System.out.println();
				System.out.println("Your Acoount Balance is "+balance);
				System.out.println();
				break;
				
			case 'B':
				System.out.println();
				System.out.println("Enter the Amount to be deposited: ");
				System.out.println();
				int amount=sc.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 'C':
				System.out.println();
				System.out.println("Enter the Amount to be Withdrawn: ");
				System.out.println();
				int withdrawnAmount=sc.nextInt();
				withDraw(withdrawnAmount);
				System.out.println();
				break;
				
			case 'D':
				System.out.println();
				System.out.println("Your Previous Transaction is "+previousTransaction);
				getPreviousTransaction();
				System.out.println();
				break;
				
			case 'E':
				System.out.println("Thankyou for your transaction. Rate our Service");
				ServiceRating();
				System.exit(0);
				
			default:
				System.out.println("Invalid Option !!! Please try again ");
				break;
			}
		}
		while(option!='E');
	}
}
public class Banking 
{
    public static void main(String[] args) 
    {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter Your Name: ");
    	String Name=sc.next();
    	System.out.println("Enter your Account Number: ");
    	String AccountNumber=sc.next();
    	System.out.println();
    	BankAccount bank=new BankAccount(Name,AccountNumber);
    	bank.showMenu();
    }
}