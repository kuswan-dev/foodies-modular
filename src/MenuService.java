import java.util.ArrayList;
import java.util.Scanner;

public class MenuService {
    public static ArrayList<MenuItem> initializeMenus() {
        ArrayList<MenuItem> menus = new ArrayList<>();

        menus.add(new MenuItem(
                1,
                "🍔 Burger",
                "food",
                9.99,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🧀 Cheese", 1.0));
                        add(new MenuItem.Option("🥓 Bacon", 1.5));
                    }
                })));
        menus.add(new MenuItem(
                2,
                "🍕 Pizza",
                "food",
                11.99,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🔴 Pepperoni", 2.0));
                        add(new MenuItem.Option("🍄 Mushroom", 1.0));
                    }
                })));
        menus.add(new MenuItem(
                3,
                "🥗 Salad",
                "food",
                6.99,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🍗 Chicken", 2.0));
                        add(new MenuItem.Option("🍤 Shrimp", 2.5));
                    }
                })));
        menus.add(new MenuItem(
                4,
                "🧃 Coke",
                "drink",
                1.99,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🧃 Regular", 0.5));
                        add(new MenuItem.Option("🧃 Large", 0.7));
                    }
                })));
        menus.add(new MenuItem(
                5,
                "🍹 Juice",
                "drink",
                2.49,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🍊 Orange", 0.7));
                        add(new MenuItem.Option("🍎 Apple", 0.8));
                    }
                })));
        menus.add(new MenuItem(
                6,
                "🥤 Water",
                "drink",
                0.99,
                new ArrayList<>(new ArrayList<>() {
                    {
                        add(new MenuItem.Option("🥤 Regular", 0.3));
                        add(new MenuItem.Option("🫧  Sparkling", 0.5));
                    }
                })));

        return menus;
    }

    public static void displayMenuByCategory(ArrayList<MenuItem> menus) {
        int number = 1;
        MenuItem[] foodMenu = menus.stream().filter(menu -> menu.category().equals("food"))
                .toArray(MenuItem[]::new);
        System.out.println("📝 Food Menus:");
        for (MenuItem menu : foodMenu) {
            System.out.println("   " + number + ". " + menu.name() + " $" + menu.price());
            number++;
        }

        System.out.println("📝 Drink Menus:");
        MenuItem[] drinkMenu = menus.stream().filter(menu -> menu.category().equals("drink"))
                .toArray(MenuItem[]::new);
        for (MenuItem menu : drinkMenu) {
            System.out.println("   " + number + ". " + menu.name() + " $" + menu.price());
            number++;
        }
    }

    public static MenuItem selectMenu(ArrayList<MenuItem> menus, Scanner scanner) {
        boolean isValid = false;
        MenuItem selectedMenu = null;
        System.out.println();

        while (!isValid) {
            System.out.print("▶ Choose menu: ");
            int selectedNumber = scanner.nextInt();

            if (selectedNumber <= menus.size()) {
                isValid = true;
                selectedMenu = menus.get(selectedNumber -1);
            } else {
                System.out.println("Input not valid!");
            }
        }
        return selectedMenu;
    }

    public static MenuItem.Option selectOptionsMenu(MenuItem menu, Scanner scanner) {
        ArrayList<MenuItem.Option> options = menu.options();
        int number = 1;
        System.out.println();
        System.out.println("📝 Options for " + menu.name() + ":");
        for (MenuItem.Option option : options) {
            System.out.println("   " + number + ". " + option.name());
            number++;
        }

        boolean isValid = false;
        MenuItem.Option selectedOption = null;
        System.out.println();

        while (!isValid) {
            System.out.print("▶ Choose option: ");
            int selectedNumber = scanner.nextInt();

            if (selectedNumber <= options.size()) {
                isValid = true;
                selectedOption = options.get(selectedNumber -1);
            } else {
                System.out.println("Tidak ada");
            }

        }
        return selectedOption;
    }
}
