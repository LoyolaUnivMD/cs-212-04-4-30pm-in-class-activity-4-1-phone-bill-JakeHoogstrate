//Phone Bill Assignment

//imports
import java.util.Scanner;
import java.text.DecimalFormat;
class Main{
    public static void main(String[] args) {
            //create scanner object and format object
            Scanner scan = new Scanner(System.in);
            DecimalFormat f = new DecimalFormat("$,###.00");

        //ask for what package
        System.out.println("Enter your subscription package (Green/Blue/Purple)");
            String packageName = scan.nextLine();

            //declare variables
            double monthlyPrice = 0.0;
            double extraDataPrice = 0.0;
            double dataProvided = Double.POSITIVE_INFINITY; //default is infinite (represents infinite data)
            double coupon = 0.0;
            double extraData = 0.0;

            //make packageName lowercase
            switch (packageName.toLowerCase()) {
                //green plan
                case "green":
                    //update variables for green
                    monthlyPrice = 49.99;
                    extraDataPrice = 15.0;
                    dataProvided = 2.0;
                    //check for coupon
                    System.out.println("Do you have a coupon? (yes/no):");
                    String x = scan.nextLine();
                    if (x.toLowerCase().equals("yes")) {
                        coupon = 20.0;
                    }
                    break;

                case "blue":
                    //blue plan
                    //update variables for blue
                    monthlyPrice = 70.0;
                    extraDataPrice = 10.0;
                    dataProvided = 2.0;
                    break;

                case "purple":
                    //purple plan
                    //update variables for purple
                    monthlyPrice = 99.95;
                    break;

                default:
                    //this happens if input is not some form of green, blue, or purple
                    System.out.println("Invalid package name. Please enter Green, Blue, or Purple.");
                    return;
            }

            //ask for data used
            System.out.println("Enter the amount of data used (in GB)");

            //check for how much extra data will be charged
            double data = scan.nextDouble();
            if (data-dataProvided>0){
                 extraData = data-dataProvided;
            }

            double bill = monthlyPrice + (extraData * extraDataPrice);

            //apply coupon value
            if (bill>=75){
                bill=bill-coupon;
            }

            //print formatted total bill
            System.out.println("Your monthly bill amount is: " + f.format(bill));

        
    }
}
