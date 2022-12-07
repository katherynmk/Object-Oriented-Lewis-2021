/**
* Defines the Room class, including the required data members, constructors, get and set functions, toString function, and getArea() function
* @author Katie Knutson
* @version 10.5
* @param Home
*/

public class Room extends Home{
    //contains name, length and width of a room 
    private String name;
    private int length;
    private int width;
    private double area;
    
    //get and set functions,
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public double getArea() {// getArea() function 
        return area;
    }
    public void setArea(int width, int length) {
        area = width * length;
    }

    public Room(){
        //default constructor
        name = "";
        length = 0;
        width = 0;
        area = 0.0;
    }
    public Room(String name, int length, int width, double area) {
        //non-default constructor
        this.name = name;
        this.length = length;
        this.width = width;
        this.area = area;
    }
    //these are all of the automated to string functions, I dont like left or right justified statements, and I also dont really use the toString
    //so it does not have to be special or specific for my code
    @Override //toString function  
    public String toString() {
        return "Room [area=" + area + ", length=" + length + ", name=" + name + ", width=" + width + "]";
    } 
    

}
