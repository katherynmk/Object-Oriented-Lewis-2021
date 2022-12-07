
/**
* @author Katie Knutson
* @version 1
*  a view class that has functions for printing a question as part of a quiz and for printing all the questions
*  and their answers both to the screen and to an xml file , which is used at the end of the program
* @param Question
* @param QuestionReader
*/
import java.util.*;
import java.beans.*;
import java.io.*;
public class QuestionPrinter extends QuestionReader {
    public static void listQuestions(ArrayList<Question> Questions){
        //this method prints all the questions and their answers
        //it is used at the very end of the main code
        for (Question question: Questions){
            System.out.println("question:   " + question.getQuestion());
            System.out.println("answer:     " + question.getAnswer());
            System.out.println("");
        }
            System.out.println("");
            System.out.println("We have also written all the questions to an xml file named questions.xml");
            System.out.println("");
            System.out.println("We hope you feel as smart as we are. Good Bye.");

        
    }

    public static void printQuestion(ArrayList<Question> Questions, int qnum){
        //this prints a singular question and its answer choices
        Question Question = new Question();
        Question = Questions.get(qnum);
        System.out.println(Question.toString());
        
    }
    public static boolean printQuestionToXML(ArrayList<Question> questions, String fname) {
        //Sarah Breslin gave me this <3
        try{
            XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(new File(fname))));
            enc.writeObject(questions);
            enc.close();
            return true;
        } catch (Exception ex){
            return false;
        }
    }
  
}