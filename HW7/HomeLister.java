import java.util.*;

/**
* @author Katie Knutson
* @version 10.5
* Has a static function called listHomes that prints the homes stored in the ArrayList it.
* Recieves in a report that looks exactly like the sample output.
* This is sorted from smallest to largest MLS 
* @param HomeReader
*/

public class HomeLister extends HomeReader {

    public static void listHomes(ArrayList<Home> homeObjects){
        //so here we have the arrays for the final homes in order, the mls numbers to get sorted for the order, and the comparison numbers for sorting 
        ArrayList<Home> homes = new ArrayList<Home>();
        ArrayList<Integer> mls = new ArrayList<Integer>();
        ArrayList<String> compares = new ArrayList<String>();

        for (Home home: homeObjects){
            //here we make an array of sorted mls numbers 
            String stringmls = home.getMLS();
            String MLS = stringmls.replace("MLS-", "");
            int compare = Integer.parseInt(MLS);
            //we need the numbers to be ints, so we can use .sort on them
            mls.add(compare);
            Collections.sort(mls);
        }
    
    
        for (Integer MLS: mls){
            //now we need those MLSs to be strings again so we do this here
            String check = "MLS-"+ Integer.toString(MLS);
            compares.add(check);
        }

        for (String checkers: compares){
            for (Home home: homeObjects){
                //now that we know the order the houses should be in, we add those houses to the final array in order 
                if (home.getMLS().equals(checkers)){
                    homes.add(home);
                }
            }
        }
        //this is where we do our final print statements
        System.out.println("******************************** HOMES CURRENTLY FOR SALE ********************************");
            for (Home finalhome: homes){
                //I truly dislike left and right justified printing,here I have proof that I tried to do it, but I did not like it
                //System.out.printf("%15s %17s %30s %-10s %-200s\n", "Propery #" + finalhome.getMLS(), "Price: $" + finalhome.getPrice() ,
                //"Sq. Feet: " + "square feet here", "Beds: " + finalhome.getBedrooms(), "Baths: " + finalhome.getBathrooms());
                System.out.println("");
                System.out.println("Property   #" + finalhome.getMLS() + "      Price: $" + finalhome.getPrice()+ "0" + "    Sq. Feet: "+ finalhome.findArea(finalhome.getRooms())+
                 "0" + "    Beds: " + finalhome.getBedrooms() + "   Baths: " + finalhome.getBathrooms());
                System.out.println("Address:     "+ finalhome.getAddress() + ", " + finalhome.getCity() + ", " + finalhome.getState() + " " + finalhome.getZip());
                System.out.println("Description:  " + finalhome.getDescription());
                System.out.println("Rooms:");


                    for (Room room: finalhome.getRooms()){
                        //although my distaste for this type of printing is obvious, I had to use it to make all of the rooms look nice 
                        System.out.printf("%-15s %10s %2s %3s\n", room.getName(), room.getLength(), "X", room.getWidth());

                    }



            }
        
    }
}