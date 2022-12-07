
/**
* @author Katie Knutson
* @version 1
* the main class which repeatedly presents quizzes to the user until they no longer want to continue
* @param Question
* @param QuestionReader
* @param QuestionPrinter
* @param Quizzer
*/
import java.util.*;
public class OOQuizTool extends Quizzer{
    public static void main(String[] args) {
        //welcome banner
        System.out.println("********************************************************");
        System.out.println("*                  Katie's Quizlet                     *");
        System.out.println("********************************************************");
        //variables
        int counter = 0;
        int howMany = 0;
        String check = "";
        String fname = "";
        int totalq=0;
        int right=0;
        double percent = 0;
        
        
        //have the user enter the file of questions
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of questions file: ");
        fname = sc.next();
        System.out.println("");
        System.out.println("");


        while (counter < 20){
            //while there are more questions
            //because there are only 20 questions, or if the file is different
            //katies quizlet will force you to take a break after 20 questions 
        System.out.println("How many questions do you want?");
        howMany = sc.nextInt();
        System.out.println("");
        //ArrayList<Question> shuffle = quizzy((readQuestionsFromFile(fname)), howMany);
            //ok im going to be honest here...
            //how i did this, theoretically does not save the array of shuffled questions
            //with already asked questions taken out
            //so.. every time we go back to the top  of the while loop and ask the user more questions
            //we are not using 'shuffle' in this class, we give the function the regular array list
            //of questions. BUT everytime i tested this, i got different questions the entire time
            //i think this is because there are so many questions, there is a small chance of a repeat
            //if the user asked all 20 questions in one go with one call of this function below,
            //they would all be different. But if the user asks 2 then 4 then 6, or whatever,
            //theoretically there is a chance of a repeate 

       //we get the return from this function of how many right the user got
       //while calling the function at the same time 
        right = right + quizzy(readQuestionsFromFile(fname), howMany);
            //total calc
        totalq = totalq + howMany;
   
        System.out.println("Enter c to continue or q to quit");
        check = sc.next();
            //as long as the user does not enter q, the code will continue 
        if (check.equalsIgnoreCase("q")){
            break;
            }

        else{
                counter = counter + howMany;
            }
        }
        if (counter >= 20){//if they do all 20 questions
            System.out.println("Sorry, you have answered all of the questions! ");
        }
        System.out.println("");//this prints the totals and all the questions and answers
        percent =  100 * ((double)right/(double)totalq);
        System.out.println("You got " + right + " right out of " + totalq + " for a percent score of  " + percent);
        System.out.println("");
        System.out.println("");
        System.out.println("Before you go, here are all of the questions and answers");
        System.out.println("");
        listQuestions(readQuestionsFromFile(fname));
        sc.close();
        //this prints the questions to an xml file 
        printQuestionToXML((readQuestionsFromFile(fname)), "questionsxml");
        //C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW8\\questions.txt
    }
}