/** 
* @author Katie Knutson
* @version 10.5
* Defines the Property class with all the characteristics that describe all properties 
*/
class Property{
    //characteristics that define all properties 
    private String MLS;
    private String address;
    private String city;
    private String state;
    private int zip;
    private double price;
    private String description; 

//just regular getters and setters 
    public String getMLS() {
        return MLS;
    }

    public void setMLS(String MLS) {
        this.MLS = MLS;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Property() {
        //default constructor 
        MLS = "";
        address = "";
        city = "";
        state = "";
        zip = 00000;
        price = 0.0;
        description = "";

    }

    public Property(String MLS, String address, String city, String state, int zip, double price, String description) {
        //non-default constructor 
        this.MLS = MLS;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.price = price;
        this.description = description;
    }
    //these are all of the automated to string functions, I dont like left or right justified statements, and I also dont really use the toString
    //so it does not have to be special or specific for my code
    @Override
    public String toString() {
        return "Property [MLS=" + MLS + ", address=" + address + ", city=" + city + ", description=" + description
        + ", price=" + price + " state=" + state + ", zip=" + zip + "]";
    }


}