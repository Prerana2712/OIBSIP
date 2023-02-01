import java.util.Scanner;

class Numbergame
{
	int systeminput;
	int userinput;
	int noofguess=0;
	
	Numbergame()
	{
		
		int min=1;
		int max=100;
		this.systeminput=(int)(Math.random()*(max-min+1)+min);
	}
	
	public boolean getinput()
	{
		Scanner sc=new Scanner(System.in);
		while(noofguess<7)
		{
			System.out.println("\nEnter the Guessed Number (in range 1-100) :");
			this.userinput=sc.nextInt();
			noofguess++;
			return false;
		}
		
			System.out.println("\n You have exceeded the number of attempts!!Better Luck Next Time\n");
			return true;
		
	}
	
	public boolean check()
	{
		if(systeminput==userinput)
		{
			System.out.println("Congratulations you got it right number "+systeminput+" in "+noofguess+" guesses");
			
			switch(noofguess)
			{
			
			case 1:
				System.out.println("Score is : 70");
				break;
			case 2:
				System.out.println("Score is : 60");
				break;
			case 3:
				System.out.println("Score is : 50");
				break;
			case 4:
				System.out.println("Score is : 40");
				break;
			case 5:
				System.out.println("Score is : 30");
				break;
			case 6:
				System.out.println("Score is : 20");
				break;
			case 7:
				System.out.println("Score is : 10");
				break;
				
			}
		
			System.out.println();
			return true;
		
		}
		else if(userinput > systeminput)
		{
			if(userinput - systeminput > 10)
			{
				System.out.println("Extreamly high");
			}
			else
			{
				System.out.println("Little high");
			}
		}
		else if(userinput < systeminput)
		{
			if(systeminput - userinput > 10)
			{
				System.out.println("Extreamly low");
			}
			else
			{
				System.out.println("Little low");
			}
		}
		return false;
	}
}
public class GuessNumber {
	public static void main(String[] args)
	{
		
		Scanner sc=new Scanner(System.in);
		int choice,newround,noofround;
		System.out.print("\n********************************************************\n");
		System.out.print("\nENTER YOUR CHOICE : \n");
		System.out.println("1)START GAME");
		System.out.println("2)EXIT");
		System.out.println("(1,2):");
		choice = sc.nextInt();
		newround=1;
		noofround=1;
		System.out.print("\n********************************************************\n");
		
		switch(choice)
		{
		case 1:
			do
			{
				Numbergame game=new Numbergame();
				boolean isequal=false;
				boolean ischancesfinish=false;
				
				System.out.print("\nRound "+noofround+" starts");
				do
				{
					ischancesfinish=game.getinput();
					isequal=game.check();
				}while(!isequal && !ischancesfinish);
				
				System.out.print("\n********************************************************\n");
				System.out.print("\nENTER YOUR CHOICE : \n");
				System.out.println("1)NEW ROUND");
				System.out.println("2)EXIT");
				System.out.println("(1,2):");
				newround = sc.nextInt();
				System.out.print("\n********************************************************\n");
				
				switch(newround)
				{
				case 1:
					break;
				case 2:
					System.exit(0);
					break;
				default :
					System.out.println("WrongChoice");
				}
				
				noofround++;
				
			}while(newround == 1);
			break;
		case 2:
			System.exit(0);
			break;
		default :
			System.out.println("WrongChoice");
		}
	}
}

