import java.util.Scanner;

public class CanteenOrderingSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] items = {
            "Takoyaki",
            "Fried Noodles",
            "Hotdog Sandwich",
            "Gulaman",
            "Waffle"
        };

        double[] prices = {
            50.00,
            45.00,
            35.00,
            20.00,
            30.00
        };

        int totalItems = 0;
        double totalBeforeDiscount = 0.00;
        double totalDiscount = 0.00;

        char orderAgain = 'Y';

        System.out.println("===== M E N U =====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %-16s - $%.2f%n",
                    i + 1, items[i], prices[i]);
        }

        while (orderAgain == 'Y' || orderAgain == 'y') {

            System.out.print("\nEnter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();

            if (itemNumber < 1 || itemNumber > 5 ||
                quantity < 1) {

                System.out.println();

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

            } else {

                System.out.print("Are you a student? (Y/N): ");
                char student = input.next().charAt(0);

                if (student != 'Y' && student != 'y' &&
                    student != 'N' && student != 'n') {

                    System.out.println(
                        "Invalid student status. Please enter Y or N."
                    );

                } else {

                    double subtotal =
                        prices[itemNumber - 1] * quantity;

                    double discountRate;

                    if (student == 'Y' || student == 'y') {

                        if (subtotal >= 500) {
                            discountRate = 0.15;
                        } else {
                            discountRate = 0.10;
                        }

                    } else {

                        discountRate = 0.00;
                    }

                    double discount = subtotal * discountRate;
                    double orderTotal = subtotal - discount;

                    totalItems += quantity;
                    totalBeforeDiscount += subtotal;
                    totalDiscount += discount;
                    
                    System.out.println ();
                    System.out.printf("Subtotal: $%.2f%n", subtotal);
                    System.out.printf("Discount: $%.2f%n", discount);
                    System.out.printf("Order total: $%.2f%n", orderTotal);
                }
            }

            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next().charAt(0);
        }

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: $%.2f%n",
                totalBeforeDiscount);
        System.out.printf("Total discount: $%.2f%n",
                totalDiscount);

        input.close();
    }
}