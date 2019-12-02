package Case_Study.JavaCore.SaveToFile.Commons;

public class Menu {
    public static void displayMenuMain() {
        System.out.println("\n1.Add New Services." +
                "\n2.Show Services." +
                "\n3.Add New Customer." +
                "\n4.Show Information Customer." +
                "\n5.Add New Booking Resort." +
                "\n6.Show Information Employee." +
                "\n7.Exit." +
                "\nPlease select one function below: ");
    }
    public static void displayMenuAddNewService() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Add New Villa." +
                "\n2.Add New House." +
                "\n3.Add New Room." +
                "\n4.Back to Menu." +
                "\n5.Exit.");
        System.out.println("\nPlease select one function below: ");
    }
    public static void displayMenuShowServices() {
        System.out.println("\n---------------------------------------------");
        System.out.println("\n1.Show All Villa." +
                "\n2.Show All House." +
                "\n3.Show All Room." +
                "\n4.Show All Name Villa Not Duplicate." +
                "\n5.Show All Name House Not Duplicate." +
                "\n6.Show All Name Room Not Duplicate." +
                "\n7.Back to Menu." +
                "\n8.Exit.");
        System.out.println("\nPlease select one function below: ");
    }
    public static void displayMenuBackToMain() {
        System.out.println("\nEnter to continue...");
        ScannerUtils.scanner.nextLine();
        System.out.println("\n---------------------------------------------");
    }
}
