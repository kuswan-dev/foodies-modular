import java.util.ArrayList;
import java.util.Scanner;

public class FoodOrder {
    public void startOrder() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<MenuItem> menus = MenuService.initializeMenus();
        ArrayList<String> payments = PaymentService.initializePayments();
        ArrayList<MenuItem> cart = new ArrayList<>();
        boolean addAnotherMenu = true;

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println("--------   Welcome to Foodies   ---------");
        System.out.println("---  Let's order your favorite food!  ---");
        System.out.println("-----------------------------------------");
        System.out.println();

        while (addAnotherMenu) {
            MenuService.displayMenuByCategory(menus);
            MenuItem selectedMenu = MenuService.selectMenu(menus, scanner);

            MenuItem.Option selectedOption = MenuService.selectOptionsMenu(selectedMenu, scanner);
            ;

            MenuItem menu = new MenuItem(
                    selectedMenu.id(),
                    selectedMenu.name(),
                    selectedMenu.category(),
                    selectedMenu.price(),
                    new ArrayList<>(new ArrayList<>() {
                        {
                            add(new MenuItem.Option(
                                    selectedOption.name(),
                                    selectedOption.price()));
                        }
                    }));
            cart.add(menu);

            System.out.println();
            System.out.println("✅ Menu Added to cart!");
            System.out.println();
            System.out.print("Add another menu? (yes/no) ");
            String answer = scanner.next();
            if (answer.equals("no")) {
                addAnotherMenu = false;
            }
        }

        OrderService.showMenuOnCart(cart);
        PaymentService.showPayments(payments);
        String payment = PaymentService.selectPayment(payments, scanner);
        OrderService.showOrder(cart, payment);
    }
}
