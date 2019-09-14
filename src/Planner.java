import java.util.Scanner;

public class Planner{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter database login info:");

        loginGUI loginGUI1 = new loginGUI();

        loginGUI1.startgui();

        System.out.println("Done");


        Database database = new Database(loginGUI1.getUsername(), loginGUI1.getPassword());

    }
}