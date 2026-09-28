import java.util.Scanner;

//error messages
class NegativePriceException extends Exception {
    public NegativePriceException() {
        super("Price cannot be negative. Please enter a valid amount.");
    }
}

class PriceOutOfRangeException extends Exception {
    public PriceOutOfRangeException() {
        super("Price out of range. Please enter a value between $1 and $10,000.");
    }
}

class PriceNotNumericException extends Exception {
    public PriceNotNumericException() {
        super("Invalid input. Please enter a numeric value for the price.");
    }
}

//inventoryprocessor class
public class InventoryProcessor {

    static double validatePrice(String input)
            throws NegativePriceException, PriceOutOfRangeException, PriceNotNumericException {
        double price;
        try {
            price = Double.parseDouble(input.trim());
        } 
            catch (NumberFormatException e) {
            throw new PriceNotNumericException();
        }

        if (price < 0) {
            throw new NegativePriceException();
        }
        if (price < 1 || price > 10000) {
            throw new PriceOutOfRangeException();
        }
        return price;
    }

    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            System.out.print("Enter the price of the item: ");
            String input = sc.nextLine();

            try {
                double price = validatePrice(input);
                System.out.println("Price accepted: $" + price);
                done = true;
            }
                catch (NegativePriceException e) {
                       System.out.println("Error: " + e.getMessage());
            } 
                catch (PriceOutOfRangeException e) {
                       System.out.println("Error: " + e.getMessage());
            }
                catch (PriceNotNumericException e) {
                      System.out.println("Error: " + e.getMessage());
            }
        }
       
    }
}
