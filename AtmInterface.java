import java.util.Scanner;



//account class to create varibles & method which will be used throughout the whole program///

class Account {
	
	String name;
	String userId;
	String pin;
	String accountNo;
	float balance = 40000.8f;
	int transactions = 0;
	String transactionHistory = "";


//////*****---------****

///registration process method to create an account////


	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" \nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.println(" \nEnter Your UserId - ");
		this.userId = sc.nextLine();
		System.out.println(" \nEnter Your Pin - ");
		this.pin = sc.nextLine();
		System.out.println(" \nPlease Enter your Account no ");
		this.accountNo = sc.nextLine();
		System.out.println(" \nHey " + this.name + " you have successfully registered " + " please Proceed further ...");
	}
	

	///****--------------****
	///method for userlogin //


	public boolean login() 
    {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) 
        {
			System.out.println(" \nPlease Enter Your UserId - ");
			String Username = sc.nextLine();
			if ( Username.equals(userId) ) 
            {
				while ( !isLogin ) {
					System.out.println(" \nPlease Enter Your Pin - ");
					String Password = sc.nextLine();
					if ( Password.equals(pin) ) {
						System.out.println(" \nHey U've Successfully logged in ");
						isLogin = true;
					}
					else {
						System.out.println(" \nIncorrect Pin  please try again ");
					}
				}
			}
			else 
            {
				System.out.println(" \nWrong UserId ");
			}
		}
		return isLogin;
	}
	


//**********----------------------------*******
//method to check if withdrawl amount is within the limit or not

	public void withdraw() 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" \nPlease renter your account no ");
		String matchaccnt = sc.nextLine();

		try {
			
			if(matchaccnt.equals(this.accountNo))
			{
				System.out.println(" \nPlease Enter amount to withdraw - ");
				float amount = sc.nextFloat();
					if ( balance >= amount) 
					{
						
						if(amount <= 10000)
						{
							transactions++;
							balance -= amount;
							System.out.println("\n" + amount + " Has Successfully withdrawed from " + accountNo +" this account");
							String str = amount + " \nRs Withdrawed\n";
							transactionHistory = transactionHistory.concat(str);
						}
							
						else
						{
							System.out.println(" \nSORRY .... CASH LIMIT EXCEEDED ");
							System.out.println(" \nYou can only withdraw Rs 10000/- at a time ");
						}

					}

					else
					{
							System.out.println(" \nSORRY .. Insufficient Balance to withdraw ");
					}

			}

			else
			{
					System.out.println(" \nIncorrect details.. Account number does not matched ");
			}
			
		}

		catch ( Exception e) {
		}
	}


	
	//*******-------------------------------------------*****
	//method to check deposited details are correct or not...//


	public void deposit() {
		
		System.out.print(" \nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 10000.8f ) {
				transactions++;
				balance += amount;
				System.out.println(" \nSuccessfully Deposited into " + accountNo + " this account");
				String str = amount + " \nRs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println(" \nSORRY .... CREDIT LIMIT EXCEEDED ");
				System.out.println(" \nAt a time You can deposit upto 10000/- ");
			}
			
		}
		catch ( Exception e) {
		}
	}


//*******----------------------------------------*******
// method to check transfer details are correct or not...

	public void transfer() {
		
		System.out.println("\nEnter Receipent's Name - ");
		Scanner sc = new Scanner(System.in);
		String receipent = sc.nextLine();
		System.out.println(" \nEnter receipients account no- ");
		String account = sc.nextLine();
		System.out.println(" \nPlease ReEnter your account no- ");
		String matchaccnt = sc.nextLine();
		try {
			
			if(matchaccnt.equals(this.accountNo))
			{
					System.out.println(" \nEnter amount to transfer - ");
					float amount = sc.nextFloat();
					if ( balance >= amount) 
					{
						
						if(amount <= 20000f)
						{
							transactions++;
							balance -= amount;
							System.out.println("\n"+ amount + " Successfully transferred to " + account +" this account");
							String str = amount + " \nRs transfered to " + receipent +"'s"+ account +"\n";
							transactionHistory = transactionHistory.concat(str);
						}
							
						else
						{
							System.out.println(" \nAt a time You can transfer upto 20000/- ");
						}

					}

					else
					{
							System.out.println(" \nSORRY .. Insufficient account Balance to transfer ");
					}

			}

			else
			{
					System.out.println(" \nIncorrect details.. Account number does not matched ");
			}
			
		}

		catch ( Exception e) {
		}
	}


	
	

////****--------------******
///method to check your account balance...


	public void checkBalance() {
		System.out.println(" \naccount balance is " + balance + " Rs");
	}
	



////****--------------******
////method to check user account transactions hsitory...


	public void transactionHistory() {
		if ( transactions == 0 ) {
			System.out.println(" \nNo Transcations history..");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}


public class AtmInterface {
	
	
	public static int takeIntegerInput(int limit) 
    {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) 
        {
			try 
            {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 )
                {
					System.out.println(" \nChoose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) 
            {
				System.out.println(" \nEnter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	


	////------********------
	//main method....

	public static void main(String[] args) 
    {
		
		System.out.println("\n\n**********WELCOME TO ATM SYSTEM**********\n");
		System.out.println(" \n1.Register \n2.Exit");
		System.out.println(" \nEnter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
        {
			Account newaccnt = new Account();
			newaccnt.register();
			while(true) 
            {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println(" \nEnter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 )
                {
					if (newaccnt.login()) 
                    {
						System.out.println(" ------\nWELCOME " + newaccnt.name + "------- \n");
						boolean isFinished = false;
						while (!isFinished) 
                        {
							System.out.println(" \n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println(" \nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) 
                            {
								case 1:
								newaccnt.withdraw();
								break;
								case 2:
								newaccnt.deposit();
								break;
								case 3:
								newaccnt.transfer();
								break;
								case 4:
								newaccnt.checkBalance();
								break;
								case 5:
								newaccnt.transactionHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else 
                {
					System.out.println(" \nThank You Please Visit again...");
					System.exit(0);
				}
			}
		}
		else
        {
			System.out.println(" \nThank You Please Visit again...");
			System.exit(0);
		}
		
		
		
	}
}	

/////the end-------///