
/**
* @author Katie Knutson
* @version 1
* Contains the main function that asks the user to enter the name of the file, asks Home Reader to read it, and uses HomeLister to print the report.
* @param Question
*/
public class Question {
    //here we assume that our quizlet program ALWAYS gives 4 answer options. This is usually the norm 
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String answer;
    //regular getters and setters
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getChoice1() {
        return choice1;
    }
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }
    public String getChoice2() {
        return choice2;
    }
    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }
    public String getChoice3() {
        return choice3;
    }
    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }
    public String getChoice4() {
        return choice4;
    }
    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    //this getter is special because getAnswer returns the entire string of the answer,
    //but this getter will tell you if that answer is a,b,c or d
    public String getAnswerLetter(String choice1, String choice2, String choice3, String choice4, String answer){
        if (choice1.equals(answer)){
            return "a";
        }
        if (choice2.equals(answer)){
            return "b";
        }
        if (choice3.equals(answer)){
            return "c";
        }
        if (choice4.equals(answer)){
            return "d";
        }
        else{
            return null; 
        }
    }
    public Question(String question, String choice1, String choice2, String choice3, String choice4, String answer) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }
    
    public Question() {
       question = "";
       choice1 = "";
       choice2 = "";
       choice3 = "";
       choice4 = "";
    }
    //this to string has to be special, because we use it in question printer
    //this saves a lot of time and space when printing
    //because instead of loops ect to print we just call this method
    
    @Override
    public String toString() {
        return question + "\r\n" +  "a- " +  choice1 + "\r\n" +  "b- " + choice2 + "\r\n" +  "c- " + choice3 +  "\r\n" +  "d- " + choice4;

    } 
    
    
}
