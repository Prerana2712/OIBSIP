import java.util.Scanner;

class Bankaccount
{
	String Name;
	String username;
	int pin;
	String accountno;
	float balance=50000;//initially Balance is kept as 50000
	int trans=0;
	String TransactionHistory="";
	
	//METHOD 1: TO REGISTER NEW USER 
	public void register() {
		
		System.out.print("\n********************************************************\n");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your Name : ");
		this.Name=sc.nextLine();
		System.out.println("\nEnter Your Username : ");
		this.username=sc.nextLine();
		System.out.println("\nEnter Your Pin : ");
		this.pin=sc.nextInt();
		System.out.println("\nEnter Your Account Number : ");
		this.accountno=sc.nextLine();
		
		System.out.println("\nRegistration is Succesfully Completed Kindly Proceed to Login\n\n");
		
		System.out.print("\n********************************************************\n");
	}
	
	//METHOD 2: TO LOGIN USING VALID USERNAME AND PASSWORD
	public boolean login() {
		boolean islogin = false;
		int k=0;
		Scanner sc = new Scanner(System.in);

		while(!islogin)//Continue execution till islogin is equal to false i.e. Login not succesfull
		{
			System.out.print("\n********************************************************\n");
			System.out.println("\nEnter Your Username : ");
			String Username=sc.nextLine();
			
			if(Username.equals(username))//To check if Username is valid or not
			{
				while(!islogin )//Continue execution till islogin is equal to false i.e. Login not succesfull
				{
					if(k<=2)
					{
						k++;
						System.out.println("\nEnter Your Pin : ");
						int Pin=sc.nextInt();
						
						if(Pin == pin ) //To check if Pin is valid or not
						{
							System.out.println("\nLogin Succesfully !!!\n\n");
							islogin=true;
							System.out.print("\n********************************************************\n");
							
							
						}
						else
						{
							System.out.println("\nIncorrect pin\n\n");
					
							System.out.print("\n********************************************************\n");
						}
					}
					else //If pin is incorrect for more than three times then relogin takesplace
					{
						k=0;
						login();
					}	
				}
				
			}
			else 
			{
				System.out.println("\nInvalid Username.\n\n");
		
				System.out.print("\n********************************************************\n");
			}
		}
		return islogin;//Returns islogin value
	}
	
	//METHOD 3: TO WITHDRAW MONEY FROM THE BANK ACCOUNT USING ATM.
	public void Withdraw()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\n********************************************************\n");
		
		System.out.print("\nEnter the amount to Withdraw : ");
		float amount =sc.nextFloat();
		
		//To check if withrawal is valid or not
		if(balance >= amount )
		{
			trans++;
			balance -= amount;
			System.out.print("\nWithdraw Sccessfully !!! \n\n");
			String str=amount + "Rs withdrawn\n";
			TransactionHistory = TransactionHistory.concat(str);
			System.out.print("\nBalance is : "+balance+"\n\n");
				
			System.out.print("\n********************************************************\n");
		}
		else
		{
			System.out.print("\nInsufficient balance to make transactions\n\n");
				
			System.out.print("\n********************************************************\n");
		}
		
	}
	
	//METHOD 4: TO DEPOSIT MONEY FROM THE BANK ACCOUNT USING ATM.
	public void Deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n********************************************************\n");
		System.out.print("\nEnter the amount to Deposit : ");
		float amount =sc.nextFloat();
	
		//To check if deposit is valid or not i.e. must be less than limit
		if(amount<= 100000f)
		{
			trans++;
			balance += amount;
			System.out.print("\nDeposited Sccessfully !!! \n\n");
			String str=amount + "Rs deposited\n";
			TransactionHistory = TransactionHistory.concat(str);
			System.out.print("\nBalance is : "+balance+"\n\n");
			System.out.print("\n********************************************************\n");
		}
		else
		{
			System.out.print("\nSorry.Can deposit only upto limit of 100000.0\n\n");
				
			System.out.print("\n********************************************************\n");
		}
		
	}
	
	//METHOD 5: TO TRANSFER MONEY FROM ONE BANK ACCOUNT TO ANOTHER USING ATM
	public void Transfer()
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\n********************************************************\n");
		System.out.print("\nEnter the Recipents name : ");
		String recipent =sc.nextLine();
		System.out.print("\nEnter the Recipents Account Number : ");
		String raccountno =sc.nextLine();
		System.out.print("\nEnter the amount to Transfer : ");
		float amount =sc.nextFloat();
		
		if(balance>=amount)
		{
			if(amount<=50000f)
			{
				trans++;
				balance -= amount;
				System.out.print("\nTransfered Sccessfully !!! \n\n");
				String str=amount + "Rs Transfered to "+ recipent+"  "+raccountno+"\n";
				TransactionHistory = TransactionHistory.concat(str);
				System.out.print("\nBalance is : "+balance+"\n\n");
					
				System.out.print("\n********************************************************\n");
			}
			else
			{
				System.out.print("\nSorry.Can Tranfer only upto limit of 50000.00 only\n\n");
				
				System.out.print("\n********************************************************\n");
			}
		}
		else
		{
			System.out.print("\nNot Sufficient Balance\n\n");
				
			System.out.print("\n********************************************************\n");
		}
	
	}
	
	//METHOD 6: TO CHECK BALANCE OF THE BANK ACCOUNT USING ATM
	public void CheckBalance()
	{
		System.out.print("\n********************************************************\n");
		System.out.print("\nBalance : "+balance+"Rs\n\n");
		System.out.print("\n********************************************************\n");
	}
	
	//METHOD 7: TO VIEW TRANSACTION HISTORY OF THE BANK ACCOUNT USING ATM
	public void TransactionHistory() {

		//If no transactions have taken place 
		if(trans == 0)
		{
			System.out.print("\n********************************************************\n");
			System.out.print("\nNo Transactions Performed\n\n");
			System.out.print("\n********************************************************\n");
		}
		else
		{
			System.out.print("\n********************************************************\n");
			System.out.print("\n"+TransactionHistory+"\n\n");
			System.out.print("\n********************************************************\n");
		}
	}
	
}

public class AtmInterface {


	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int choice,ch,c;
		System.out.print("\n********************************************************\n");
		System.out.print("\n*****************WELCOME TO ICICI ATM****************\n");
		System.out.print("\nENTER YOUR CHOICE : \n");
		System.out.println("1)REGISTER");
		System.out.println("2)EXIT");
		System.out.println("(1,2):");
		choice = sc.nextInt();
		System.out.print("\n********************************************************\n");
		
		switch(choice)
		{
		case 1:
			Bankaccount b = new Bankaccount();//Creating object of the clasds
			b.register();
			
			
			do {
				System.out.print("\nENTER YOUR CHOICE : \n");
				System.out.println("1)LOGIN");
				System.out.println("2)EXIT");
				System.out.println("(1,2):");
				ch =sc.nextInt();
				
				switch(ch)
				{
				case 1:
					if(b.login())
					{
						System.out.print("\n*****************WELCOME "+b.Name+"TO ICICI ATM****************\n");
						
						do
						{
							System.out.print("\nENTER YOUR CHOICE : \n");
							System.out.println("1)WITHDRAW");
							System.out.println("2)DEPOSIT");
							System.out.println("3)TRANFER");
							System.out.println("4)CHECK BALANCE");
							System.out.println("5)TRANSACTION HISTORY");
							System.out.println("6)EXIT");
							System.out.println("(1,2,3,4,5,6):");
							c = sc.nextInt();
							
							switch(c)
							{
							case 1:
								b.Withdraw();
								break;
							case 2:
								b.Deposit();
								break;
							case 3:
								b.Transfer();
								break;
							case 4:
								b.CheckBalance();
								break;
							case 5:
								b.TransactionHistory();
								break;
							case 6:
								System.out.println("Exit");
								break;
							default:
								System.out.println("Wrong choice");
							}
						}while(c!=6);
					}
					break;
				
				default:
					if(ch!=2)
					{
						System.out.println("Wrong choice.");
					}
					
				}
				
			}while(ch!=2);
			
		case 2:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice");
		}

	
		
	}
}
