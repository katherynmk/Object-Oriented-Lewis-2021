import java.util.*;
//import everything of course

public class KnutsonPCConfig {
//this gets called everytime we want the user to see this menu (makes code much shorter)
    public static void menu(int i){
        
        System.out.println("");
        System.out.println("Currently Editing:  PC " + (i+1));//because i starts at 0 and we arent on PC 0 now are we
        System.out.println("----------------------------");

        System.out.println("");
        System.out.println("Please choose from this menu");
        System.out.println("");
        System.out.println("1. Processor ");
        System.out.println("2. Graphics Card ");
        System.out.println("3. Memory ");
        System.out.println("4. Monitor ");
        System.out.println("5. Exit ");
        System.out.println("");


    }
    public static void main (String[] args){
// the welcomeeeeeeee bannerrrrrrrrrrrr
        System.out.println("****************************************");
        System.out.println("*          Welcome To The              *");
        System.out.println("*       Computer Configurator          *");
        System.out.println("*               V-1.0                  *");
        System.out.println("****************************************");

// we just have most of the variables we need right here, in case of problems
        int ccounter;
        int i = 0;
        int price = 0;
        int totalprice = 0;
        int choice = 0;

        int pchoice;


        // here is the scanner, hes looking dapper
        //here we see how many computers the user wants so we can do this whole big while loop for all the good stuff
        Scanner sc = new Scanner(System.in);
        System.out.print("How many computers would you like to purchase?   ");
        ccounter = sc.nextInt();
        
//here we call the menu for the first time for PC1 to set our choice variable because we need that to have a value for the while loop
        menu(i);
        System.out.println("Which item would you like to upgrade?  ");
        choice = sc.nextInt();

        //big loop that does everything we need as long as the place we are in the loop is less than the amount of PCs the user wants 
        // we can do this because i starts at 0
        while (i < ccounter){

            //we start these strings everytime in the loop because if the user doesnt edit them, it needs to show that
            String Processor = "Stock";
            String GraphicsCard = "Stock";
            String Memory = "Stock";
            String Monitor="Stock";

            //since we already have the menu for the first pc we cant ask for it again
            // it took me an hour to figure out why I was printing the menu like 10 times 
            //but everytime we go onto another pc we need to ask the user the menu question
            if (i != 0){
                menu(i);
                System.out.println("Which item would you like to upgrade?  ");
                choice = sc.nextInt();
            }
            //we reset the price per pc here because everytime we start this loop again its a new pc 
            price = 0;
            

            //these if statements are simply for the menu choices
            if (choice == 1){
                System.out.println("");
                System.out.println("Here are your Processor options: ");
                System.out.println(" 1.) Intel i7 $200");
                System.out.println(" 2.) Intel i9 $300");
                System.out.println(" 3.) AMD Ryzen 9 5950  $500");
                System.out.println("");
                System.out.println("Please choose a processor   ");
                // we name the choice in the if statements to be different because the main choice variable affects the while loop not inside the if statements
                pchoice = sc.nextInt();

                    
                    if (pchoice == 1){
                        price += 200;
                        Processor = "Intel i7 ";
                    }

                    if (pchoice == 2){
                        price += 300;
                        Processor = "Intel i9 ";
                    }

                    if (pchoice == 3){
                        price += 500;
                        Processor = "AMD Ryzen 9 5950 ";
                    }

                    //we print this at the end of every choice because we are on the same PC
                    menu(i);
                    System.out.println("Which item would you like to upgrade?  ");
                    choice = sc.nextInt();

            
            }

            if (choice == 2){
                System.out.println("Here are your Graphics Card options: ");
                System.out.println(" 1.) Nvidia 2060 $200");
                System.out.println(" 2.) Nvidia 3060 $250");
                System.out.println(" 3.) Nvidia 3080 $350");
                System.out.println("");
                System.out.println("Please choose a Graphics Card   ");
                pchoice = sc.nextInt();

                    
                    if (pchoice == 1){
                        price += 200;
                        GraphicsCard = "Nvidia 2060 ";
                    }

                    if (pchoice == 2){
                        price += 250;
                        GraphicsCard =  "Nvidia 3060 ";
                    }

                    if (pchoice == 3){
                        price += 350;
                        GraphicsCard =  "Nvidia 3080 ";
                    }

                    menu(i);
                    System.out.println("Which item would you like to upgrade?  ");
                    choice = sc.nextInt();
            }

            if (choice == 3){
                System.out.println("Here are your Memory options: ");
                System.out.println(" 1.) 16 GB $150");
                System.out.println(" 2.) 32 GB $250");
                System.out.println("");
                System.out.println("Please choose a Memory option   ");
                pchoice = sc.nextInt();

                    
                    if (pchoice == 1){
                        price += 150;
                        Memory = "16 GB ";

                    }

                    if (pchoice == 2){
                        price += 250;
                        Memory = "32 GB ";
                    }

                    menu(i);
                    System.out.println("Which item would you like to upgrade?  ");
                    choice = sc.nextInt();


            }

            if (choice == 4){
                System.out.println("Here are your Monitor options: ");
                System.out.println(" 1.) 24 inch $200");
                System.out.println(" 2.) 27 inch $250");
                System.out.println(" 3.) 32 inch $350");
                System.out.println("");
                System.out.println("Please choose a Monitor  ");
                pchoice = sc.nextInt();

                    
                    if (pchoice == 1){
                        price += 200;
                        Monitor = "24 inch ";
                    }

                    if (pchoice == 2){
                        price += 250;
                        Monitor = "27 inch ";
                    }

                    if (pchoice == 3){
                        price += 350;
                        Monitor = "32 inch ";
                    }

                    menu(i);
                    System.out.println("Which item would you like to upgrade?  ");
                    choice = sc.nextInt();
            
            }

            if (choice == 5){
                //the exit choice, how classy
                //here we just make the total price to print at the end and we add every price from every pc for this
                // we print the stores values of the 
                
                totalprice = totalprice + price;
                
                System.out.println("");
                System.out.println("Your current PC has: ");
                System.out.println("Processor: "+ Processor);
                System.out.println("Graphics: " + GraphicsCard);
                System.out.println("Memory: " + Memory);
                System.out.println("Monitor: " + Monitor);
                System.out.println("");
                //look heres that price variable we talked about earlier 
                System.out.println("The price for the current PC is $" + (price+1750) + ".00");//before edits a PC costs 1750
                System.out.println("");
                
                //this guy is SUPER important
                //everytime we exit a pc menu we make sure the while loop moves onto the next PC
                //very crucial
                i = i+1;
            }


        }

        //yay ending print statements!
        System.out.println("");
        System.out.println("The price for all of your PCs comes to a total of $" + (totalprice+(1750*ccounter)) + ".00");//each pc starts at 1750 
        System.out.println("");
        System.out.println("Thank you for shopping in Java");
        System.out.println("");
        sc.close();// dont forget to say goodnight to the scanners or else they have nightmares!

    }
}
