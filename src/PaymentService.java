import java.util.ArrayList;
import java.util.Scanner;

public class PaymentService {
    public static ArrayList<String> initializePayments() {
        ArrayList<String> payments = new ArrayList<>();

        payments.add("Dana");
        payments.add("Gopay");
        payments.add("OVO");
        payments.add("ShopeePay");
        payments.add("Cash");

        return payments;
    }

    public static void showPayments(ArrayList<String> payments) {
        int number = 1;
        System.out.println();
        System.out.println("💳 Payment methods:");

        for (String payment : payments) {
            System.out.println("   " + number + ". " + payment);
            number++;
        }
    }

    public static String selectPayment(ArrayList<String> payments, Scanner scanner) {
        boolean isValid = false;
        String selectedPayment = null;
        System.out.println();

        while (!isValid) {
            System.out.print("▶ Select payment: ");
            int selectedNumber = scanner.nextInt();
            if (selectedNumber <= payments.size()) {
                isValid = true;
                selectedPayment = payments.get(selectedNumber -1);
            } else {
                System.out.println("Input not valid!");
            }
        }

        return selectedPayment;
    }
}
