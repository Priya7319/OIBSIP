import java.util.Scanner; 
import java.util.Random;  


public class NumberGuessingGame {


    ////method for checking game scores of players////
    ///------------------------------------------------------
    public static void score (int num){
        switch(num) {
            case 1: // if the trial is 1nd
            System.out.println("You have scored " + 90 + " in this round");
            break;
            case 2:  // if the trial is 2rd
            System.out.println("You have scored " + 80 + " in this round"); 
            break;
            case 3: // if the trial is 3rd
            System.out.println("You have scored " + 70 + " in this round"); 
            break;
            case 4: // if the trial is 4th
            System.out.println("You have scored " + 60 + " in this round");
            break;
            case 5: // if the trial is 5th
            System.out.println("You have scored " + 50 + " in this round");
            break;
            case 6: // if the trial is 6th
            System.out.println("You have scored " + 40 + " in this round");
            break;
            case 7: // if the trial is 7th
            System.out.println("You have scored " + 30 + " in this round");
            break;
            case 8: // if the trial is 8th
            System.out.println("You have scored " + 20 + " in this round");
            break;
            case 9: // if the trial is 9th
            System.out.println("You have scored " + 10 + " in this round");
            break;
            case 10: // if max limit reached 
            System.out.println("You have scored " + 0 + " in this round");
            break;
        }
    }

    //main function///
    public static void main(String[] args){
            System.out.println("Welcome to numberguessing game :");
            Scanner scanner = new Scanner(System.in); // to take input from console
            System.out.println("Enter your Name"); 
            String name= scanner.nextLine().toUpperCase();
            System.out.println("Do you Want to Start the game?");
            System.out.println("Type yes to start or no to exit"); 
            String choice = scanner.next().toLowerCase();

            while(choice.equals("yes")) // Start the game until user choice is yes.
            {
                Random random = new Random(); //random number generator
                int number = random.nextInt(100); // boundation is 1-100 u can set it accordingly 
                int guess = 0; // to store user guessing number.
                int tries = 10; //to count total no of trials in the game.
                System.out.println("Hello Welcome "+ name +" !"); //greeting
                System.out.println("Guess a number between 1 & 100 "+ "you have only "+ tries + " tries in this game"); 
                while(guess != number && tries != 0 )
                {
                   guess = scanner.nextInt();
                   tries--;

                    if(guess == number) // check if user guess equals to the generated number
                    {
                        System.out.println("Great " + name + " !!! You guessed it correctly " + "in " + (10 - tries) +" tries");
                        score(10-tries);
                        System.out.println("Do you want to continue the game? ");
                        choice = scanner.next().toLowerCase();
                    }

                    else if(guess < number && tries != 0) // check if the guess is lower than the random generated number
                    {
                        System.out.println(" Oops!! Your guess is too low " + "you have only " + tries + " tries left" + " Try again");
                    }

                    else if(guess >number && tries != 0) // check if the guess is higher than the number generated number
                    {
                        System.out.println(" Oops!! Your guess is too high " + "you have only " + tries + " tries left "+ " Try again...");
                    }
                }

                    if(tries == 0 && guess != number) // to check whether u have used maximum number of tries
                    {
                        System.out.println("Sorry " + name + " , you have reached maximum limit");
                        score(10-tries); 
                        System.out.println("Do u want to play again ? : Yes or No");
                        choice = scanner.nextLine().toLowerCase();
                        if(choice.equals("yes"))
                        {
                        continue;
                        }
                    }

           }
           System.out.println("Thank You " + name + " , Have a nice day ahead!");
           scanner.close();
        }
    
}


