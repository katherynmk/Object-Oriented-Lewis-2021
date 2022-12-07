import java.util.*;
/**
* @author Katie Knutson
* @version 10.5
* Contains the main function that asks the user to enter the name of the file, asks Home Reader to read it, and uses HomeLister to print the report.
* @param HomeReader.java
* @param HomeLister.java
*/
public class RealityRealty extends HomeLister {
public static void main(String args[]) {
    //theoretically, how I coded this should work for any list of homes with any amount of homes that have any amount of rooms
    //simply asks user for file, reads it, and prints it 
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter name of homes database: ");
    String fname = sc.nextLine();
    sc.close();
    listHomes(readHomesFromFile(fname));

    
}
}