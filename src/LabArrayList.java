import java.util.ArrayList;
import java.util.Scanner;
static ArrayList<String> list = new ArrayList<>();
static Scanner pipe = new Scanner(System.in);
public static void main(String[] args) {


    boolean done = false;

        do {
            displayMenu();
            String choice = SafeInput.getRegExString(pipe, "Choose an option [A/D/I/P/Q]:", "[AaDdIiPpQq]");
            switch (choice.toUpperCase()) {
                case "A":
                    String newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to add:");
                    list.add(newItem);
                    System.out.println("Item added.");
                    break;
                case "D":
                    if (list.isEmpty()) {
                        System.out.println("The list is empty. Nothing to delete.");
                        return;
                    }
                    printListWithNumbers();
                    int itemIndex = SafeInput.getRangedInt(pipe, "Enter the number of the item to delete:", 1, list.size()) - 1;
                    list.remove(itemIndex);
                    System.out.println("Item Successfully Deleted.");
                    break;
                case "I":
                    int position = 0;
                    if (list.isEmpty()) {
                        System.out.println("The list is currently empty.");
                    } else {
                        position = SafeInput.getRangedInt(pipe, "Enter the position to insert the item:", 1, list.size() + 1) - 1;
                        newItem = SafeInput.getNonZeroLenString(pipe, "Enter the item to insert:");
                        list.add(position, newItem);
                        System.out.println("Item inserted.");
                    }
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    boolean confirm = SafeInput.getYNConfirm(pipe, "Are you sure you want to quit? (Y/N):");
                    if (confirm) {
                        System.out.println("You have Successfully Exited the Program");
                        done = true;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!done);
    }

    private static void displayMenu () {
        printList();
        System.out.println("\nMenu:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
    }

    private static void printList () {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Current List:");
            for (String item : list) {
                System.out.println("- " + item);
            }
        }
    }

    private static void printListWithNumbers () {
        System.out.println("List:");
        for (int m = 0; m < list.size(); m++) {
            System.out.printf("%d. %s%n", m + 1, list.get(m));
        }
    }





