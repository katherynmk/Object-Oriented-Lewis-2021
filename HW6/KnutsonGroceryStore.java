import java.util.*;
import java.io.*;
//Katie G helped me with this code 
//she spent a bit of time helping me implement my own ideas and she shared some of her own
//I hope you give her some discussion board extra credit, and hopefully me too for asking her for help :))
/**
 * This code reads in items and their sales 
 * it lets the user select what they want to buy 
 * then it checks  the discounts to that and finds the total discount and total prices 
 * @param items.txt
 * @param sales.txt
 * @author Katie Knutson
 * @version 10000000000000000000.0
 * @category Store 
 */
class BillProcessor{
    public static void prepareBill(LinkedHashMap<String, Integer> purchases, LinkedHashMap<String, Double> items, LinkedHashMap<String, String> sales, ArrayList<String> itemNames){
        double totalcost = 0;
        double discount = 0;
        double finaltotal = 0;
        double finaldiscount = 0;
        double isale = 0;
        int cquantity = 0;
       //necessary variables 

        Iterator<Map.Entry<String, Integer>> ir = purchases.entrySet().iterator(); //special way to iterate over the map purchases 
        while (ir.hasNext()){ //while purchases has a line 
            Map.Entry<String, Integer> entry = ir.next();
            String item =  entry.getKey(); //gets the item 
            int quantity =  entry.getValue(); //gets the amount of items the user wanted 

                if (sales.get(item) == null && quantity != 0){//if there is no sale 
                    totalcost = totalcost + (items.get(item)*quantity);
                    finaltotal = finaltotal + totalcost;
                }

                if (sales.get(item) != null && quantity != 0){//if there is a sale 

                    if (sales.get(item).equals("bogo")){//if the sale is bogo 
                        
                        if(quantity == 1){//if you only buy 1 
                        
                            totalcost = totalcost + items.get(item);
                            finaltotal = finaltotal + totalcost;
                            
                            
                        }

                        else{
                            int modulo = quantity%2;

                                if(modulo == 1){ //if you buy an odd amount
                                    cquantity = quantity; 
                                    cquantity = cquantity - 1;
                                    cquantity = cquantity/2; 
                                    discount = cquantity * items.get(item);
                                    totalcost = (items.get(item)*quantity) - discount;

                                    finaltotal = finaltotal + totalcost;
                                    finaldiscount = finaldiscount + discount;
                                    
                
                                 }
                                 else{ //if you buy an even amount 
                                    cquantity = quantity;
                                    cquantity = cquantity/2;
                                    discount = cquantity * items.get(item);
                                    totalcost = (items.get(item)*quantity) - discount;

                                
                                    finaltotal = finaltotal + totalcost;
                                    finaldiscount = finaldiscount + (totalcost * cquantity);

                                }
                        }
                    }
                    else {//if the sale isnt bogo
                        isale = Double.parseDouble(sales.get(item));
                        discount = (quantity*isale);
                        totalcost = (items.get(item)*quantity) - discount;
                        finaltotal = finaltotal + totalcost;
                        finaldiscount = finaldiscount + (discount * quantity);
                   }
                }
                if (quantity != 0){//if you actually bought something 
                System.out.println("Here is what you purchased: ");
                System.out.printf(quantity + " " + item + " regularly " + items.get(item) + " each, " + "total %.2f" +  "(%.2f discount)\n", totalcost, discount);
                }
                    
                }//this prints out the totals for the discounts and the total cost 
                System.out.printf("Your total bill is $%.2f\n", finaltotal);
                System.out.printf("You saved $%.2f by shopping with us today\n", finaldiscount);
                System.out.println("");
                System.out.println("Thank you for your business. Come back soon!");
                System.out.println("");
       
    }

 } 


public class KnutsonGroceryStore{
    public static void welcome(){
        // the welcomeeeeeeee bannerrrrrrrrrrrr
        System.out.println("*******************************************************************************");
        System.out.println("*                            Katie's Place                                    *"); //my store not charlies 
        System.out.println("*******************************************************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("Welcome to your friendly neighborhood E-Grocery store!");
        System.out.println("We make shoppingt easy and simple.");
        System.out.println("Our products are the freshest you can get and we'll deliver them to you the same day");
        System.out.println("The more you buy, the more you save.");
        System.out.println("");
        System.out.println("");
        System.out.println("What would you like to buy?");
        System.out.println("");
        System.out.println("");

}


public static LinkedHashMap<String,Double> readItemsFromFile() {// reads the items 
        LinkedHashMap<String, Double> items = new LinkedHashMap<String, Double>();
        String[] pos; //katie helped a bit with reading in files as well 
        String line; 
        try {
            Scanner sc =  new Scanner(new File("C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW6\\items.txt"));
                while(sc.hasNextLine()){
                    line = sc.nextLine().trim();
                    pos = line.split("\t"); //split by the tab 
                    items.put(pos[0], Double.parseDouble(pos[1])); //the item is the string (key) the value is the double 
                    
                }
                return items;
        }   catch(Exception ex){
            ex.printStackTrace(); // if the file isnt found 
            System.out.println("File not found");
            return items;
        }

    }

public static LinkedHashMap<String, String> readSalesFromFile() {

    LinkedHashMap<String, String> sales = new LinkedHashMap<String, String>(); //i read this in the same way as the items 
    String[] pos;
    String line; 
    try {
        Scanner sc =  new Scanner(new File("C:\\Users\\katie\\OneDrive\\Documents\\Object-Oriented\\HW6\\sales.txt"));
            while(sc.hasNextLine()){
                line = sc.nextLine().trim();
                pos = line.split("\t");
                sales.put(pos[0], pos[1]);
                
            }
            return sales;
    }   catch(Exception ex){
        ex.printStackTrace();
        System.out.println("File not found");
        return sales;
    }
    
}
public static ArrayList<String> sorted(LinkedHashMap<String, Double> items){
    //create an array 
    ArrayList<String> sorted = new ArrayList<String>();

    for (String sKey : items.keySet()) { //for all of the keys 
        sorted.add(sKey); //sort the keys 
        sorted.sort(null);
    }
    return sorted;
}

public static void menu() {
    LinkedHashMap<String, Double> items = readItemsFromFile(); //little recursion hereeeeeeeeee
    LinkedHashMap<String, String> sales = readSalesFromFile(); //we have to call our previous functions to actually creat the hash maps that were sorted or read in from the text files
    ArrayList<String> sorted = sorted(items);

    //this is where katie helped me with the left or right justification
    //she also showed me how to get the sale, get the item name, ect which is a concept I used in the prepareBill function as well

    int i = 1;// we use i to indicate the left most number on the list (1-15)
    System.out.printf("%-2s %-15s %15s %-20s\n", "##", "Item Name", "Reg.", "Sale");
    System.out.println("-------------------------------------------------------");
    for(String item: sorted) {//for every item in the sorted array of items
        if(sales.containsKey(item)) {
            if(sales.get(item).equals("Buy One Get One")) {
                System.out.printf("%-2d %-15s %15s %-20s\n", i, item,"$"+items.get(item), sales.get(item));//print the number, then the itemname, then the sale
            }
            else {
                System.out.printf("%-2d %-15s %15s %-20s\n", i, item, "$"+items.get(item),"$"+sales.get(item)+" discount");
            }
        }else {
            System.out.printf("%-2d %-15s %15s\n", i, item,"$"+items.get(item));
        }
        i++;
    }
    System.out.println("-------------------------------------------------------");
}


public static LinkedHashMap<String, Integer> purchases() { //key and quantity 
    LinkedHashMap<String, Integer> purchases = new LinkedHashMap<String, Integer>();
    LinkedHashMap<String, Double> items = readItemsFromFile();
    ArrayList<String> sorted = sorted(items);
    for(String item: sorted){
        purchases.put(item, 0);
    }
    
    return purchases;
}

public static void main(String []args){
    // I initialized these here because we need to use them later for prepareBill
    LinkedHashMap<String, Integer> purchases = new LinkedHashMap<String, Integer>();
    purchases = purchases();
    LinkedHashMap<String, Double> items = new LinkedHashMap<String, Double>();
    items = readItemsFromFile();
    LinkedHashMap<String, String> sales = new LinkedHashMap<String, String>();
    sales = readSalesFromFile();
    ArrayList<String> itemNames = new ArrayList<String>();
    itemNames = sorted(items);
    
    //these are just filler variables I use for each item in the store in the if statements below
    int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o;
    a = b = c = d = e = f = g = h = i = j = k = l = m = n = o = 0;
    
    //we start by printing the welcome and the menu of items 
    welcome();
    menu();
    
    //then we have a scanner that updates a choice value that goes throughout the whole code
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of your choice, or q to check out:  "  );
    String choice = sc.nextLine();

    do{//this loop will go until the user presses q or an incorrect value 
        if (choice.equals("1")){//I know all of these if statements probably could be a function, but I like the simplicity and readability of how I approached ths 
            a = a + 1;//basically we use the letters in each if statement to see how many of the thing the user ordered 
            purchases.put("Apples", a);//then we put that quanity at the item name for the purchases map 
            System.out.print("Enter the number of your choice, or q to check out:  "  );//then we ask the user again 
            choice = sc.nextLine();
        }
        else if (choice.equals("2")){//all of the following if statements are the same as the first one 
            b = b + 1;
            purchases.put("Blueberries", b);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("3")){
            c = c + 1;
            purchases.put("Bread", c);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("4")){
            d = d + 1;
            purchases.put("Cereal", d);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("5")){
            e = e + 1;
            purchases.put("Eggs", e);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("6")){
            f = f + 1;
            purchases.put("Frozen pizza", f);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("7")){
            g = g + 1;
            purchases.put("Ground Beef", g);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("8")){
            h = h + 1;
            purchases.put("Hamburgers", h);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("9")){
            i = i + 1;
            purchases.put("Milk", i);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("10")){
            j = j + 1;
            purchases.put("Mountain Dew", j);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("11")){
            k = k + 1;
            purchases.put("Peanut Butter", k);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("12")){
            l = l + 1;
            purchases.put("Roast Beef", l);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("13")){
            m = m + 1;
            purchases.put("Sausage", m);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("14")){
            n = n + 1;
            purchases.put("String Cheese", n);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else if (choice.equals("15")){
            o = o + 1;
            purchases.put("Tamales", o);
            System.out.print("Enter the number of your choice, or q to check out:  "  );
            choice = sc.nextLine();
        }
        else{ //I tried to put something here where if they didnt enter 1-15 or q it would ask the user to enter a correct value
            //but that did not work well, so we just assume that if the value isnt correct the user wants to quit
            //I would love some help fixing this problem I seem to have it a lot 
            choice = "q";
        }


    }while(choice != "q");

    System.out.println("");
    System.out.println("");
    //here we use our prepare bill and give it the values we have from the functions that we initialized at the begging of main 
    //we feed it what the user baught, the items, the sales, and the sorted items 

    BillProcessor.prepareBill(purchases, items, sales, itemNames);


    }
    
}
