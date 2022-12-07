import java.util.*;
import java.io.*;
/**
 * This code reads in two story files and many word files
 * it takes the story files and correctly changes the specified words to a random word from the specified word file 
 * The user can print each story as many times as they want and the words will be different every time
 * @param story.txt
 * @param word.txt
 * @author Katie Knutson
 * @version 3.0 
 * @category Madlib
 */
public class KnutsonMadlibs {
    public static void welcome(){
        // the welcomeeeeeeee bannerrrrrrrrrrrr
        System.out.println("****************************************");
        System.out.println("*          Welcome To The              *");
        System.out.println("*       Madlibs Funtime Game           *");
        System.out.println("*               V-1.0                  *");
        System.out.println("****************************************");

}
    public static void instructions(){

        System.out.println(); //this is just a function to print out the instructions for the user
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
    public static String adj(){//this reads in te adj word file
        //we return a string to use in the later story function
        List<String> adj = new ArrayList<String>();//we use array lists for everything 
        try{
        String filename = "adj.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())//while the file has another line we get the word (words r split by line)
        adj.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Adj file not found");
    }
    int num = (int)(Math.random() * (adj.size() ));//tested this method and got every item in the list at least once
    String boink = adj.get(num);//this will retrieve the random word
    return boink;//this returns it
    }
    //before we move on...
    //every word function is the exact same as the one above
    //this assures that we will have no errors because if one works perfectly they all should

    //but if there is a problem with reading in a file it will be quarentined to its own function, 

    //therefore the rest of
    //the word functions will still work properly and the story would be readable
    public static String adv(){

        List<String> adv = new ArrayList<String>();
        try{
        String filename = "adv.txt";
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
        String filename = "noun.txt";
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
        String filename = "nouns.txt";
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
        String filename = "verb.txt";
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
        String filename = "verbs.txt";
        Scanner sc  = new Scanner(new File(filename));
        while (sc.hasNextLine())
        verbs.add(sc.next());//we use next to get each word individually 
        }

        catch(Exception ex){
        System.out.println("Verbs file not found");
    }
    int num = (int)(Math.random() * (verbs.size() ));//tested this method and got every item in the list at least once
    String boink = verbs.get(num);
    return boink;
    }
    public static String verbed(){
        List<String> verbed = new ArrayList<String>();
        try{
        String filename = "verbed.txt";
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
        //this function prints the story, doesnt need to return anything 
        List<String> story = new ArrayList<String>();
        try{//we attempt to read the file
            String filename = "story" + file + ".txt";//would not work without full path 
            Scanner sc  = new Scanner(new File(filename));
            
            while (sc.hasNextLine())//we will have a string full of every word in the story file
            story.add(sc.next());//we use next to get each word individually 
            }
            catch(Exception ex){
                System.out.println("Story file not found"); }

        List<String> finalstory = new ArrayList<String>(); //add comma and period if statements
        int i = 0;//the following loop will run until the story is done 
        while(i < story.size()){ //now we check if the words are special and if we need to change them
            if (story.get(i).equals("<pastverb>")){//i checked for every type of word as well as if they have punctuation or not
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
                i++;//for all of these ifs, if there is a word or  word with punctuation we will add it to the final story list 
            }
            else if (story.get(i).equals("<adv>.")){
                finalstory.add(adv() + ".");
                i++;
            }
            else{
            finalstory.add(story.get(i));//if the word is regular, we still add it in order 
            i++;
            }
            
        }
        int x = 0;
        int a = finalstory.size();//here we print the final story list with the words changed correctly word by word so it looks nice
        while (x < a){
            System.out.print(finalstory.get(x) + " "); //we also print a space between the words
            x++;
        }
        
    }
    public static void main(String []args){
 
        //we print the welcome and instructions to start off 
        welcome();
        instructions();
        //then we introduce a scanner to ask the user what they want to do 
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter i,q or a story number!   ");
        String choice = sc.nextLine();//we take in strings

        while (choice.equalsIgnoreCase("i") || choice.equalsIgnoreCase("q") ||choice.equals("1") ||  choice.equals ("2")){
            //we do this loop while the user enters in a correct element from the instructions 
            //this while loop works so well you can type i over and over and print instructions till the end of time
            //if the user enters an incorrect value the loop will break and the code needs to be restarted
        if (choice.equalsIgnoreCase("i")){
            instructions();//this is our print instructions option
            System.out.println();
            System.out.println();
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }
        
        if (choice.equals("1")){//here is where we print the first story
            System.out.println("Here is your Madlib for story1!");
            System.out.println();
            System.out.println();
            story("1");
            System.out.println();
            System.out.println();
            
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }

        if (choice.equals("2")){//here is where we print the second story
            System.out.println("Here is your Madlib for story2!");
            System.out.println();
            System.out.println();
            story("2");
            System.out.println();
            System.out.println();
            
            System.out.print("Please enter i,q or a story number!   ");
            choice = sc.nextLine();//we take in strings
        }

        if (choice.equalsIgnoreCase("q")){//this quits the program 
            System.out.println("Thank you for playing the Mad Libs Game!");
            choice = "bye bye now!";
        }
        
    }
        System.out.println("end of code");//i put this in so its obvious that we successfully got through the code
    
    }
}
