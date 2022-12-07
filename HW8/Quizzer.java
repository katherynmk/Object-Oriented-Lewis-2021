
/**
* @author Katie Knutson
* @version 1
* the class that asks the user a specified number of questions at random from the list,
* making sure not to repeat any question in a round, and letting the user know what they got correct and incorrect
* @param Question
* @param QuestionReader
* @param QuestionPrinter
*/
import java.util.*;
public class Quizzer extends QuestionPrinter{

    public static int quizzy(ArrayList<Question> Questions, int qnum){
        //this is an array list we make to shuffle all of the questions
        ArrayList<Question> shuffle = new ArrayList<Question>();
        int  i = 0;
        int right = 0;
        int total = 0; 
        double percent = 0;
        String choice;
        //shuffle array is the same as the regular question array
        shuffle.addAll(Questions);
        Scanner sc = new Scanner(System.in);
        while (i < qnum){ 
            //we do this loop for as many times as the user wants questions
            //shuffle the questions
            Collections.shuffle(shuffle);
            Question Question = new Question();
            //get a random question (doesnt matter the number it is because its shuffled every time)
            Question = shuffle.get(0);
            //call our method to print just one question
            printQuestion(shuffle, 0);
                System.out.println("Enter the letter of your choice:    ");
                choice = sc.next();
            
            if (choice.equalsIgnoreCase(Question.getAnswerLetter(Question.getChoice1(), Question.getChoice2(), Question.getChoice3(), Question.getChoice4(), Question.getAnswer()))){
                //if the user enters the correct letter, its correct and the number right and total up 1
                System.out.println("Congratulations! That is correct!");
                System.out.println("");
                right = right + 1;
                total = total + 1;
                shuffle.remove(0);
                i++;
                
            }
            else{
                System.out.println("Sorry the correct answer was (" + (Question.getAnswerLetter(Question.getChoice1(), Question.getChoice2(), Question.getChoice3(), Question.getChoice4(), Question.getAnswer()) + ")- " + Question.getAnswer()));
                System.out.println("");
                //if the answer is incorrect, give the right answer, add 1 to total 
                shuffle.remove(0);
                total = total + 1;
                i++;
               //then go back to the top of the loop and check if we asked as many questions as the user wanted
            }
            
        }
        //sc.close();
        System.out.println("");
        percent = 100 * ((double)right/(double)total);
        System.out.println("You got " + right + " right out of " + total + " for a percent score of  " + percent);
        System.out.println("");
        //after the questions are asked, print the total right and total overall
        //return the total right to use in the OOQuizTool class
        return right;
        
    }
    
}
