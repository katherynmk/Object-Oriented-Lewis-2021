package HW3;

import java.util.*;
public class KnutsonPayday {

    public static void printPaycheck(double grosspay, double afterunion, double aftermedical, double aftertax, double netpay, String name) {
        
        System.out.println();
        System.out.println("*************************************");
        System.out.println(String.format("%19s", "$$MONEY$$")); //I found string format online, honestly it doesnt really matter which way you justify things
        System.out.println("*************************************"); 
        System.out.printf("%15s %20.2f", "Gross Pay:", grosspay); 
        System.out.println();
        System.out.printf("%15s %20.2f", "Union Dues:", afterunion);
        System.out.println();
        System.out.printf("%15s %20.2f", "Medical Dues:", aftermedical);
        System.out.println();
        System.out.printf("%15s %20.2f", "Taxes:", aftertax);//fuck u
        System.out.println();
        System.out.printf("%15s %20.2f", "Net Pay:", netpay);
        System.out.println();

        System.out.println("*************************************");
        System.out.print("Pay Recievable to:  " + name);
 
        
    } 
    
    public static void main(String[] args){


        /**
         * This program asks for work details and prints a paycheck
         * @param grosspay original pay based on ONLY hours worked and pay rate
         * @param afterunion if user is in union, dues are taken as a percentage out of original grosspay (shows amount given to union)
         * @param aftermedical is user wants to contribute medical, dues are taken as a percentage out of original grosspay (shows amount given to medical)
         * @param aftertax shows amount given to tax in accurate tax bracet based on the adjusted grosspay after union and medical
         * @param netpay shows the final pay
         * @param name shows the name on the paycheck
         * @author Katie Knutson
         */
        
        //initialize all variables here
        double hoursworked = 0;
        double payrate = 0;
        String union = " ";
        double medical = 0;
        double grosspay = 0;
        double tax = 0;
        //I usually initialize strings like I did above, but you showed me this way in class
        String name; 
        double afterunion = 0;
        double adjustgross = 0; //I also realize you initialize in usually the same line

        //banner
        System.out.println("****************************************");
        System.out.println(String.format("%25s", "Paycheck V12.4"));
        System.out.println("****************************************");

        //scanner for user input
        //no need for nextLine() because we can just read in the doubles and ints
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = sc.next();
        System.out.print("Enter hours worked: ");
        hoursworked = sc.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        payrate = sc.nextDouble();
        System.out.print("Are you a union member? (Y)es or (N)o  ");
        union = sc.next();
        System.out.println("What percentage would you like to contribute to medical?  ");
        medical = sc.nextDouble();
        sc.close();
        //close the scanner because the scanner doesnt want to hang around doing nothing

        //original gross p
        grosspay = hoursworked*payrate;

        //calculate if the user is in the union or not
        if (union.equalsIgnoreCase("Y")) {
            afterunion = (double)(grosspay*5.0/100.0);
            adjustgross = grosspay - afterunion;
        }
        else {
            adjustgross = grosspay;
        }

        //this takes out the medical
        double aftermedical = (double)(grosspay*medical/100);
        adjustgross = adjustgross - aftermedical;

        // here we need to have a newa adujsted gross variable, because Klumps code shows us that we take union and medical from original gross, and taxes AFTER that
        //percentages are tricky we gotta be careful!

        if (adjustgross >= 2500) {
            tax = 25;
    
        }//this if statement looks so pretty to me
        else if (adjustgross >= 1500 && adjustgross < 2500) {
            tax = 15;
        }
        else if (adjustgross >= 500 && adjustgross < 1500 ) {
            tax = 10;
        }
        else {
            tax = 5;
        }

        //here we get the final net pay
        double aftertax = (double)(adjustgross*tax/100);
        double netpay = adjustgross - aftertax;


        printPaycheck(grosspay,afterunion,aftermedical,aftertax, netpay, name);

        }
    }
    

