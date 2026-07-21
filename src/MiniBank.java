import java.util.Scanner;

public class MiniBank {

    private static void displayMenu() {
        System.out.println("===== MiniBank Menu =====");
        System.out.println("1. Open Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {

        BankInfo header = new BankInfo("MiniBank", "Changa Main Branch");
        System.out.println(header);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();

            System.out.print("Enter choice: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.\n");
                continue;
            }

            MenuOption[] options = MenuOption.values();
            if (choice < 1 || choice > options.length) {
                System.out.println("Invalid menu number. Try again.\n");
                continue;
            }

            MenuOption selected = options[choice - 1];

            switch (selected) {
                case OPEN_ACCOUNT -> System.out.println("Open Account — to be implemented in a later lab.");

                case DEPOSIT -> System.out.println("Deposit — to be implemented in a later lab.");

                case WITHDRAW -> System.out.println("Withdraw — to be implemented in a later lab.");

                case TRANSFER -> System.out.println("Transfer — to be implemented in a later lab.");

                case EXIT -> {
                    System.out.println("Thank you for banking with us. Goodbye!");
                    running = false;
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
