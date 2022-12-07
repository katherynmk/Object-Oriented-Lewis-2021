import java.util.*;
/**
* @author Katie Knutson
* @version 10.5
* Extends Property and adds all the characteristics that are unique to homes  findArea() function to determine the square footage
* @param Property
*/
public class Home extends Property {

    //all the characteristics particular to homes 
    private int bedrooms;
    private double bathrooms;
    private ArrayList<Room> rooms;
    private double totalarea; //for our total area of the house

    //getters and setters
    public void setBedrooms(int bedrooms){
        this.bedrooms = bedrooms; 
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public double getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(double bathrooms) {
        this.bathrooms = bathrooms;
    }
        
    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRooms(Room rm) {
        rooms.add(rm);
    }

    public double findArea(ArrayList<Room> rooms){//findArea() function to determine the square footage

        for (Room room: rooms){
            totalarea = totalarea + room.getArea();
        }
        return totalarea;

    }
    public Home(){
        //default constructor
        bedrooms = 0;
        bathrooms = 0;
        rooms = new ArrayList<Room>();
    }

    public Home(String MLS, String address, String city, String state, int zip, double price, String description, int bedrooms, double bathrooms, ArrayList<Room> rooms) {
        //non-default constructor
        super(MLS, address, city, state, zip, price, description);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.rooms = rooms;
    }


    //these are all of the automated to string functions, I dont like left or right justified statements, and I also dont really use the toString
    //so it does not have to be special or specific for my code
    @Override
    public String toString() {
        return "Home [bathrooms=" + bathrooms + ", bedrooms=" + bedrooms + ", rooms=" + rooms + "]";
    }


}

