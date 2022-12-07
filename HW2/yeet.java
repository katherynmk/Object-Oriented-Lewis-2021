import java.util.*;
import java.io.*;
/**
 * This code...
 * @param 
 */
public class yeet {
    public static void welcome(){
        // the welcomeeeeeeee bannerrrrrrrrrrrr
        System.out.println("****************************************");
        System.out.println("*          Welcome To The              *");
        System.out.println("*       Madlibs Funtime Game           *");
        System.out.println("*               V-1.0                  *");
        System.out.println("****************************************");

}
    public static void instructions(){

        System.out.println();
        System.out.println("This fun madlibs game generates random stories using supplied lists of words!");
        System.out.println("The base story comes from files named story1.txt and story2.txt");
        System.out.println("Some words in these stories are contained in <>");
        System.out.println("These missing words could be nouns, adverbs, or adjectives!");
        System.out.println("These words will be replaced at random everytime you pick a story!");
        System.out.println("All you have to do is tell the program which number story you want and we will create one with the randomized words!");
        System.out.println();
        System.out.println("To continue with the madlibs enter a story number either 1 or 2");
        System.out.println();
        System.out.println("You can also press i to see instructions again or q to quit!     ");
        System.out.println();
    
    }
    public static String adj(){
        List<String> adj = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\adj.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        adj.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Adj file not found");
    }
    int num = (int)(Math.random() * (adj.size() ));//tested this method and got every item in the list at least once
    String boink = adj.get(num);
    return boink;
    }
    public static String adv(){

        List<String> adv = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\adv.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        adv.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println(""); }

        int num = (int)(Math.random() * (adv.size() ));//tested this method and got every item in the list at least once
        String boink = adv.get(num);
        return boink;
    }
    public static String noun(){
        List<String> noun = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\noun.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        noun.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Noun file not found");
    }
    int num = (int)(Math.random() * (noun.size() ));//tested this method and got every item in the list at least once
    String boink = noun.get(num);
    return boink;
    }
    public static String nouns(){
        List<String> nouns = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\nouns.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        nouns.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Nouns file not found");
    }
    int num = (int)(Math.random() * (nouns.size() ));//tested this method and got every item in the list at least once
    String boink = nouns.get(num);
    return boink;
    }
    public static String verb(){
        List<String> verb = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\verb.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        verb.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Verb file not found");
    }
    int num = (int)(Math.random() * (verb.size() ));//tested this method and got every item in the list at least once
    String boink = verb.get(num);
    return boink;
    }
    public static String verbs(){
        List<String> verbs = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\verbs.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        verbs.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Adj file not found");
    }
    int num = (int)(Math.random() * (verbs.size() ));//tested this method and got every item in the list at least once
    String boink = verbs.get(num);
    return boink;
    }
    public static String verbed(){
        List<String> verbed = new ArrayList<String>();
        try{
        String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\verbed.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        verbed.add(sc.next());//we use next to get each word individually 
         }

        catch(Exception ex){
        System.out.println("Verbed file not found");
        }

        int num = (int)(Math.random() * (verbed.size() ));//tested this method and got every item in the list at least once
        String boink = verbed.get(num);
        return boink;
        
    }
    public static void story(String file){
        //remember to split by spances and punctuation 
        List<String> story = new ArrayList<String>();
        try{
            String filename = "C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW5\\story" + file + ".txt";//would not work without full path 
            Scanner sc  = new Scanner(new File(filename));
            
            while (sc.hasNextLine())
            story.add(sc.next());//we use next to get each word individually 
            }
            catch(Exception ex){
                System.out.println("Story file not found"); }

        List<String> finalstory = new ArrayList<String>(); //add comma and period if statements
        int i = 0;
        while(i < story.size()){ //need to return a string here
            if (story.get(i).equals("<pastverb>")){
                finalstory.add(verbed());
                i++;
            }
            else if (story.get(i).equals("<pastverb>,")){
                finalstory.add(verbed() + ",");
                i++;
            }
            else if (story.get(i).equals("<pastverb>.")){
                finalstory.add(verbed() + ".");
                i++;
            }
            else if (story.get(i).equals("<singnoun>")){
                finalstory.add(noun());
                i++;
            }
            else if (story.get(i).equals("<singnoun>,")){
                finalstory.add(noun() + ",");
                i++;
            }
            else if (story.get(i).equals("<singnoun>.")){
                finalstory.add(noun() + ".");
                i++;
            }
            else if (story.get(i).equals("<pluverb>")){
                finalstory.add(verbs());
                i++;
            }
            else if (story.get(i).equals("<pluverb>,")){
                finalstory.add(verbs() + ",");
                i++;
            }
            else if (story.get(i).equals("<pluverb>.")){
                finalstory.add(verbs() + ".");
                i++;
            }
            else if (story.get(i).equals("<plunoun>")){
                finalstory.add(nouns());
                i++;
            }
            else if (story.get(i).equals("<plunoun>,")){
                finalstory.add(nouns() + ",");
                i++;
            }
            else if (story.get(i).equals("<plunoun>.")){
                finalstory.add(nouns() + ".");
                i++;
            }
            else if (story.get(i).equals("<verb>")){
                finalstory.add(verb());
                i++;
            }
            else if (story.get(i).equals("<verb>,")){
                finalstory.add(verb() + ",");
                i++;
            }
            else if (story.get(i).equals("<verb>.")){
                finalstory.add(verb() + ".");
                i++;
            }
            else if (story.get(i).equals("<adj>")){
                finalstory.add(adj());
                i++;
            }
            else if (story.get(i).equals("<adj>,")){
                finalstory.add(adj() + ",");
                i++;
            }
            else if (story.get(i).equals("<adj>.")){
                finalstory.add(adj() + ".");
                i++;
            }
            else if (story.get(i).equals("<adv>")){
                finalstory.add(adv());
                i++;
            }
            else if (story.get(i).equals("<adv>,")){
                finalstory.add(adv() + ",");
                i++;
            }
            else if (story.get(i).equals("<adv>.")){
                finalstory.add(adv() + ".");
                i++;
            }
            else{
            finalstory.add(story.get(i));
            i++;
            }
            
        }
        int x = 0;
        int a = finalstory.size();
        while (x < a){
            System.out.print(finalstory.get(x) + " "); 
            x++;
        }
        
    }
    public static void main(String []args){
 
        //we need to return strings for the word methods
        //we need to seperate the story file into a list by spaced and punctuation
        //ending of story method should be a for loop that prints the final story word by word without a line in between
        
        welcome();
        instructions();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter i,q or a story number!   ");
        String choice = sc.nextLine();//we take in strings

        while (choice.equalsIgnoreCase("i") || choice.equalsIgnoreCase("q") ||choice.equals("1") ||  choice.equals ("2")){

        if (choice.equalsIgnoreCase("i")){
            instructions();
            System.out.println();
            System.out.println();
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }
        
        if (choice.equals("1")){
            System.out.println("Here is your Madlib for story1!");
            System.out.println();
            System.out.println();
            story("1");
            System.out.println();
            System.out.println();
            
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }

        if (choice.equals("2")){
            System.out.println("Here is your Madlib for story2!");
            System.out.println();
            System.out.println();
            story("2");
            System.out.println();
            System.out.println();
            
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }

        if (choice.equalsIgnoreCase("q")){
            System.out.println("Thank you for playing the Mad Libs Game!");
            choice = "bye bye now!";
        }
        
    }
        System.out.println("end of code");
    
    }
}
