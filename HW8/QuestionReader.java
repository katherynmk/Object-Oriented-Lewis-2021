
/**
* @author Katie Knutson
* @version 1
*  model class that reads the questions from a text file
* @param Question
*/
import java.util.*;
import java.io.*;
public class QuestionReader  {
    public static ArrayList<Question> readQuestionsFromFile(String fname){

        //we have an array list of questions and empty choices
        ArrayList<Question> questions = new ArrayList<Question>();
        String question= "", choice1= "", choice2= "", choice3= "", choice4 = "", answer = "" ;
        Question Question = new Question();

        try{
            Scanner sc = new Scanner(new File(fname)).useDelimiter("\t"); //file is read in automatically by tabs 
            do{
                //here we read in the file by tabs, then trim ALL whitespace 
                //then we set the questions and answers
                if ( sc.next().equals("q") ){
                    question = sc.nextLine().replaceAll("^\\s+", "");
                }
                if (sc.next().equals("a")){
                    choice1 = sc.nextLine().replaceAll("^\\s+", "");
                }
                if (sc.next().equals("b")){
                    choice2 = sc.nextLine().replaceAll("^\\s+", "");
                }
                if (sc.next().equals("c")){
                    choice3 = sc.nextLine().replaceAll("^\\s+", "");
                }
                if (sc.next().equals("d")){
                    choice4 = sc.nextLine().replaceAll("^\\s+", "");
                }

                if (sc.next().equals("?")){
                    //answer is set to the entire word answer not the letter
                    answer = sc.nextLine().replaceAll("^\\s+", "");
                }
                Question = new Question(question, choice1, choice2, choice3, choice4, answer);
                questions.add(Question);

            }while (sc.hasNextLine());
                
     
   

        } catch(Exception ex){
            //if the name of the file does not exist the function should return null
                return null;   
                 
        }
       
        return questions;
    }

}

