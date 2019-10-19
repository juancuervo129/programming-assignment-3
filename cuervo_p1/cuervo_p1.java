import java.util.Scanner;
import java.security.SecureRandom;

public class cuervo_p1 {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int reset = 1;

        while (reset !=0) {                               //Loop until user wants to stop

            int result = 0;
            int numCorrect = 0;
            int numIncorrect = 0;

            int difficulty = problemDifficulty();           //Prompt user to enter level of difficulty
            int type = problemType();                       //Ask user what type of arithmetic problem they want

            for (int i = 0; i < 10; i++) {                          //Loop of 10 questions

                SecureRandom rand = new SecureRandom();
                int response = rand.nextInt(4) + 1;          //Generate number for answer response
                int rand1 = rand.nextInt(9) + 1;            //Create two random numbers for question
                int rand2 = rand.nextInt(9) + 1;

                //If difficulty number is not between 2 to 4, then it defaults to difficulty = 1;

                if(difficulty == 2) {                           //If difficulty is 2, numbers are up to 2 digits
                    rand1 = rand.nextInt(99) + 1;
                    rand2 = rand.nextInt(99) + 1;
                }

                if(difficulty == 3) {                           //If difficulty is 3, numbers are up to 3 digits
                    rand1 = rand.nextInt(999) + 1;
                    rand2 = rand.nextInt(999) + 1;
                }

                if(difficulty == 4) {                           //If difficulty is 4, numbers are up to 4 digits
                    rand1 = rand.nextInt(9999) + 1;
                    rand2 = rand.nextInt(9999) + 1;
                }

                if(type == 1) {
                    result = addQuestion(rand1, rand2);    //Call addition question method to generate question
                }

                if(type == 2) {
                    result = subQuestion(rand1, rand2);    //Call subtraction question method to generate question
                }

                if(type == 3) {
                    result = multQuestion(rand1, rand2);   //Call multiplication question method to generate question
                }

                if(type == 4) {
                    result = divQuestion(rand1, rand2);    //Call division question method to generate question
                }

                if(type == 5) {
                    int rand3 = rand.nextInt(4)+1;      //Generate random number to generate mixed questions
                    if(rand3 == 1)
                        result = addQuestion(rand1, rand2);
                    if(rand3 == 2)
                        result = subQuestion(rand1, rand2);
                    if(rand3 == 3)
                        result = multQuestion(rand1, rand2);
                    if(rand3 == 4)
                        result = divQuestion(rand1, rand2);
                }

                if (result == 1) {

                    numCorrect++;                         //Increase value of number of questions answered correctly

                    switch (response) {                      //Switch statement for different responses
                        case 1:
                            System.out.println("Very good!");
                            break;
                        case 2:
                            System.out.println("Excellent!");
                            break;
                        case 3:
                            System.out.println("Nice work!");
                            break;
                        case 4:
                            System.out.println("Keep up the good work!");
                            break;
                    }
                }

                if (result == 0) {

                    numIncorrect++;

                    switch (response) {
                        case 1:
                            System.out.println("No. Please try again.");
                            break;
                        case 2:
                            System.out.println("Wrong. Try once more.");
                            break;
                        case 3:
                            System.out.println("Don’t give up!");
                            break;
                        case 4:
                            System.out.println("No. Keep trying.");
                            break;
                    }

                }
            }

            double total = (double) numCorrect / (numCorrect + numIncorrect);        //Calculate % correct
            System.out.println("Your score is " + total*100 + "%.");

            if (total < 0.75)
                System.out.println("Please ask your teacher for extra help.");      //If below 75% correct
            else
                System.out.println("Congratulations, you are ready to go to the next level.");  //If above 75% correct

            System.out.println("Do you wish to reset the program? Enter 1 for yes or 0 for no.");
            reset = in.nextInt();
        }
    }


    public static int addQuestion(int rand1, int rand2){

        int answer = rand1 + rand2;                      //Answer equals to the sum of both random numbers

        System.out.println("How much is " + rand1 + " plus " + rand2 + "?");
        double userAnswer = in.nextInt();

        if(userAnswer == answer)    //Compare answer to correct answer
            return 1;               //If answer is correct

        else
            return 0;               //If answer is wrong
    }


    public static int subQuestion(int rand1, int rand2){

        int answer = rand1 - rand2;                      //Answer equals to the difference of both random numbers

        System.out.println("How much is " + rand1 + " minus " + rand2 + "?");
        double userAnswer = in.nextInt();

        if(userAnswer == answer)    //Compare answer to correct answer
            return 1;               //If answer is correct

        else
            return 0;               //If answer is wrong
    }


    public static int multQuestion(int rand1, int rand2){

        int answer = rand1 * rand2;                      //Answer equals to the product of both random numbers

        System.out.println("How much is " + rand1 + " times " + rand2 + "?");
        double userAnswer = in.nextInt();

        if(userAnswer == answer)    //Compare answer to correct answer
            return 1;               //If answer is correct

        else
            return 0;               //If answer is wrong
    }


    public static int divQuestion(int rand1, int rand2){

        double answer = rand1 / rand2;                      //Answer equals to the quotient of both random numbers

        System.out.println("How much is " + rand1 + " divided by " + rand2 + "?");
        double userAnswer = in.nextInt();

        if(userAnswer == answer)    //Compare answer to correct answer
            return 1;               //If answer is correct

        else
            return 0;               //If answer is wrong
    }


    public static int problemDifficulty(){
        System.out.println("Enter level of difficulty from 1-4:");
        int difficulty = in.nextInt();

        while(difficulty > 4 || difficulty < 1){                    //Loop until user enters a number from 1-4
            System.out.println("Please enter a number from 1-4: ");
            difficulty = in.nextInt();
        }

        return difficulty;
    }


    public static int problemType(){
        System.out.println("Enter type of arithmetic problem you want to study: ");
        int type = in.nextInt();

        while(type > 5 || type < 1){                                //Loop until user enters number from 1-5
            System.out.println("Please enter a number from 1-5: ");
            type = in.nextInt();
        }

        return type;
    }
}