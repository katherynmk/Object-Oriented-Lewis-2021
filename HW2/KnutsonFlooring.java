// Suppose you want to cover an area of your house with laminate flooring.
//  Each board is 30 inches long and 6 inches wide. The boards come packaged in boxes of six. Each package costs $21.99. 
//  The dimensions of your room are shown in feet in this diagram.
// Because you will have to cut the boards to accommodate the angle, there will be some waste, so you will have to purchase 20% extra flooring to account for that. 
// Also, you can't buy individual boards, as you can purchase them only in boxes of six.
// Write a program called LastnameFlooring.java that will determine and print how many packages of laminate boards you will need to buy and what that will cost. (8 points)
import java.util.*;

public class KnutsonFlooring {
    public static void main(String[] args) {

        double boardlong = 30;
        double boardwide = 6;
        double boardarea = boardlong*boardwide;

        double packagecost = 21.99;

        double floorlong1 = 360;
        double floorwide1 = 240;
        double floorarea = floorlong1*floorwide1;


        double tilesneeded = floorarea/boardarea;
        double boxesneeded = tilesneeded/6;


//bad angle area of death calculations

       double floorlong2 = 168;
       double floorwide2 = 96;
    
       double a = (96*168)/2;
        
        double floorarea1 = a;
        double tilesneeded1 = floorarea1/boardarea;
        double boxesneeded1 = tilesneeded1/6;

        double totalboxesneeded = boxesneeded/boxesneeded1;
        double totalcost = totalboxesneeded*packagecost;
        double easy = 1.00;
        System.out.println("Your total boxes needed is: " + (int)(totalboxesneeded));
        System.out.println("Your total cost is: $" + totalcost/easy);

    }
}