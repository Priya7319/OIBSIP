import java.util.Scanner;



//account class to create varibles & method which will be used throughout the whole program///

class Account {
	
	String name;
	String userId;
	String pin;
	String accountNo;
	float balance = 20000.8f;
	int transactions = 0;
	String transactionHistory = "";


//////*****---------****

///registration process method to create an account////


	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\n Enter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\n Enter Your UserId - ");
		this.userId = sc.nextLine();
		System.out.print("\n Enter Your Pin - ");
		this.pin = sc.nextLine();
		System.out.print("\n Please Enter your Account no ");
		this.accountNo = sc.nextLine();
		System.out.println(" Hey " + this.name + " you have successfully registered " + " Proceed further ...");
	}
	


	///****--------------****
	///method for userlogin //


	public boolean login() 
    {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) 
        {
			System.out.println(" Please Enter Your UserId - ");
			String Username = sc.nextLine();
			if ( Username.equals(userId) ) 
            {
				while ( !isLogin ) {
					System.out.println(" Please Enter Your Pin - ");
					String Password = sc.nextLine();
					if ( Password.equals(pin) ) {
						System.out.print(" Successfully logged in ");
						isLogin = true;
					}
					else {
						System.out.println(" Incorrect Password  please try again ");
					}
				}
			}
			else 
            {
				System.out.println("\n Wrong Username ");
			}
		}
		return isLogin;
	}
	


//**********----------------------------*******
//method to check if withdrawl amount is within the limit or not

	public void withdraw() 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" Please renter your account no ");
		String matchaccnt = sc.next();

		try {
			
			if(matchaccnt.equals(this.accountNo))
			{
				System.out.println("\n Please Enter amount to withdraw - ");
				float amount = sc.nextFloat();
					if ( balance >= amount) 
					{
						
						if(amount <= 10000)
						{
							transactions++;
							balance -= amount;
							System.out.println(amount + " Has Successfully withdrawed from " + accountNo +" this account");
							String str = amount + " Rs Withdrawed\n";
							transactionHistory = transactionHistory.concat(str);
						}
							
						else
						{
							System.out.println(" SORRY .... CASH LIMIT EXCEEDED ");
							System.out.println(" You can only withdraw Rs 10000/- at a time ");
						}

					}

					else
					{
							System.out.println(" SORRY .. Insufficient Balance to withdraw ");
					}

			}

			else
			{
					System.out.println(" Incorrect details.. Account number does not matched ");
			}
			
		}

		catch ( Exception e) {
		}
	}


	
	//*******-------------------------------------------*****
	//method to check deposited details are correct or not...//


	public void deposit() {
		
		System.out.print(" Enter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 10000.8f ) {
				transactions++;
				balance += amount;
				System.out.println(" Successfully Deposited into " + accountNo + " this account");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println(" SORRY .... CREDIT LIMIT EXCEEDED ");
				System.out.println(" At a time You can deposit upto 10000/- ");
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
		String matchaccnt = sc.next();
		try {
			
			if(matchaccnt.equals(this.accountNo))
			{
					System.out.println("\nEnter amount to transfer - ");
					float amount = sc.nextFloat();
					if ( balance >= amount) 
					{
						
						if(amount <= 20000f)
						{
							transactions++;
							balance -= amount;
							System.out.println(amount + " Successfully transferred to " + account +" this account");
							String str = amount + " Rs transfered to " + receipent + "\n";
							transactionHistory = transactionHistory.concat(str);
						}
							
						else
						{
							System.out.println(" At a time You can transfer upto 20000/- ");
						}

					}

					else
					{
							System.out.println(" SORRY .. Insufficient account Balance to transfer ");
					}

			}

			else
			{
					System.out.println(" Incorrect details.. Account number does not matched ");
			}
			
		}

		catch ( Exception e) {
		}
	}


	
	

////****--------------******
///method to check your account balance...


	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	



////****--------------******
////method to check user account transactions hsitory...


	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
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
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) 
            {
				System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	
	


	////------********------
	//main method....

	public static void main(String[] args) 
    {
		
		System.out.println("\n**********WELCOME TO ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.println("Enter Your Choice - ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) 
        {
			Account newaccnt = new Account();
			newaccnt.register();
			while(true) 
            {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 )
                {
					if (newaccnt.login()) 
                    {
						System.out.println("\n\n WELCOME " + newaccnt.name + " \n");
						boolean isFinished = false;
						while (!isFinished) 
                        {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.println(" Enter Your Choice - ");
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
								newaccnt.transHistory();
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
					System.exit(0);
				}
			}
		}
		else
        {
			System.exit(0);
		}
		
		
		
	}
}	

/////the end-------///