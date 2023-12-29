import java.text.DecimalFormat;
import java.util.ArrayList;

public class OrderService {
    public static void showMenuOnCart(ArrayList<MenuItem> cart) {
        System.out.println("🛒 Your cart:");
        System.out.println("   --------------------------");
        for (MenuItem menu : cart) {
            MenuItem.Option option = menu.options().getFirst();
            System.out.println("   | " + menu.name() + " $" + menu.price());
            System.out.println("   |    " + option.name() + " $" + option.price());
            System.out.println("   | 💵 Total price : $" + (menu.price() + option.price()));
            System.out.println("   --------------------------");
        }
    }

    public static void showOrder(ArrayList<MenuItem> cart, String payment) {
        Double totalPrice = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (MenuItem menu : cart) {
            totalPrice += menu.price();
            totalPrice += menu.options().getFirst().price();
        }

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("-------------   Your Order   -----------");
        System.out.println("----------------------------------------");
        System.out.println("         Payment     : " + payment);
        System.out.println("         Total price : $" + decimalFormat.format(totalPrice));
        System.out.println("----------------------------------------");
        System.out.println();

    }
}
