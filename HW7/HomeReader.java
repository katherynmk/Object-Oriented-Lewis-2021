import java.util.*;
import java.io.*;
/**
* @author Katie Knutson
* @version 10.5
* @return list of home objects
* @exception null if file is not read
* Has a static function called readHomesFromFile that returns an Array list of Home objects.
* It creates the Home objects appropriately based on what it reads from the file that was passed in.
* It returns null if it could not read the file correctly 
* @param Homes.txt 
*/

public class HomeReader {

    public static ArrayList<Home> readHomesFromFile(String fname){
        //here we set all of the variables we are going to need to get this task done 
        ArrayList<Home> homeObjects = new ArrayList<Home>();
        ArrayList<Room> rooms = new ArrayList<Room>();
        String MLS, city, state, description, address,  width;
        String name = "";
        int zip, price, bedrooms, length, wIdth;
        double bathrooms, area;
        Home home = new Home();
        Room room;
        
        try{
            Scanner xs  = new Scanner(new File(fname)).useDelimiter("\t"); //file is read in automatically by tabs 
            do {
                
                    if (name.contains("MLS")){ //this if for anything but the first traversal of the loop
                        //after the first traversal, name is going to be set to the mls number because that is one of our checking conditions,
                        //we take that into consideration here and fix that
                        //also we start a new array of rooms for the new home 
                        MLS = name;
                        rooms = new ArrayList<Room>();

                        
                    }
                    else {
                        //for the first traversal of the loop 
                        MLS = xs.next();
                    }
                
                address = xs.next();
                city = xs.next();
                state = xs.next();
                zip = xs.nextInt();
                bedrooms = xs.nextInt();
                bathrooms = xs.nextDouble();
                price = xs.nextInt();
                description = xs.nextLine();
                name = xs.next(); //we set the name of the room here, this is necessary so our next loop condition does not break 
                
                while(!name.contains("MLS")){  
                    //while we are not on the next home
                    length = xs.nextInt();
                    width = xs.nextLine().trim();
                    wIdth = Integer.parseInt(width); //width has an end of line marker
                    area = length * wIdth;
                    room = new Room(name, length, wIdth, area);
                    rooms.add(room); //make each room, add them to the array of rooms for home later 

                    if(xs.hasNextLine()){
                        //if there are more lines in the file
                        name = xs.next();
                        
                        continue;//this sets us to the beginnig of the loop
                    }
                    else{ //if the file is over we have to break the loop
                        break;
                    }
                    
                }
                //make a new home, add it to the array of homes
                home = new Home(MLS, address, city, state, zip, price, description, bedrooms, bathrooms, rooms);
                homeObjects.add(home);//returns an array list of home objects 
                
            }while (xs.hasNextLine());
                xs.close();
                return homeObjects;

        } catch(Exception ex){
            //if the name of the file does not exist the function should return null
                return null;   
                 
        }
       
    }
}
