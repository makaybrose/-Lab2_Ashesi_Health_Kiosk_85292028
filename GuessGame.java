import java.util.Scanner;

public class Guessgame {
    public static void main(String[]args){
   
    Scanner input = new Scanner(System.in);   
    int randomNumber = (int)(Math.random()*10) + 1;

    int userGuess = 0;
    while(userGuess != randomNumber){
        System.out.println("Guess a number between 1-10: ");
        userGuess = input.nextInt();

        if(userGuess == randomNumber){
            System.out.println("Hurray!!! You got it right. The random number is: "+ randomNumber);

        }else{
            System.out.println("try again");
        }

    }

    input.close();

    }
    
}
