import java.util.Scanner;
import java.util.Random;
public class SubtractionTutor{
    public static void main(String [] args){

        System.out.print("Welcome to the Subtraction Tutor \nYou will supply a low value and high value, defining the range\nof values to be included in your quiz. You will get 5 problems.\nThe values must be positive and no larger than 9999\n");

        //Retrieves first user input
        Scanner userInLow = new Scanner(System.in);
        System.out.print("Low value : ");
        int lowVal = userInLow.nextInt();

        //Validates first input
        if (lowVal < 1 || lowVal > 9999){
            do{
                userInLow = new Scanner(System.in);
                System.out.print("Invalid Input \nLow Value : ");
                lowVal = userInLow.nextInt();
        
            } while (lowVal < 1 && lowVal > 9999); 
        }

        //Retrieves second user input
        Scanner userInHigh = new Scanner(System.in);
        System.out.print("High value : ");
        int highVal = userInHigh.nextInt();
        
        //Validates second input
        if (highVal < 0 || highVal > 9999 || highVal == lowVal){
            do{
                userInHigh = new Scanner(System.in);
                System.out.print("Invalid Input \nHigh Value : ");
                highVal = userInHigh.nextInt();
            } while (highVal < 1 && highVal > 9999);
        }

        //creating counter 
        int ct = 1;
        int correct = 0;
        //count will run this loop 5 times
        //loop calls problemNumbers to generate numbers for each subtraction problem
        //it then take user input and checks it
        while(ct<6){
            int[] problemNumbers = Subtraction(lowVal, highVal);
            System.out.printf("%d\n%d\n----\n",problemNumbers[0],problemNumbers[1]);
            Scanner answerIn = new Scanner(System.in);
            System.out.print("Answer? ");
            int userAnswer = answerIn.nextInt();
            int cpuAnswer = problemNumbers[0] - problemNumbers[1];
    
            if (cpuAnswer == userAnswer){
                correct += 1;
                System.out.print("Correct!\n");
            }
            else{
                System.out.print("False\n");
            } 
            ct += 1;
        }  
        System.out.print("The quiz is over.\n");  
        
        String closeString = Closing(ct);
        System.out.print(closeString);

        }
        
    public static String Closing(int n){
        String stringClose;
        if (n == 5){
            stringClose = "Excellent! You got all 5 problems correct.";
        }
        else if (n>2){
            stringClose = "You got over half correct, practice makes perfect!";
        }
        else{
            stringClose = "You got less than half correct, you need to spend more time practicing.";
        }
        return stringClose;
    }    
    
    public static int[] Subtraction(int low, int high){

        Random randomNumbers = new Random();
        int first = randomNumbers.nextInt(high) + low;
        int second = randomNumbers.nextInt(high) + low;
        int higher;
        int lower;


        if (first > second){
            higher = first;
            lower = second;
        }
        
        else{
            higher = second;
            lower = first;
        }    
       
        return new int[] {higher, lower};
        
        }

    }






    

