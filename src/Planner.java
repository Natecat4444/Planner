import java.util.ArrayList;
import java.util.Scanner;

public class Planner{
    private static GUIManager guiManager;
    private static boolean checkForDatabase(Database database){
        System.out.println("Checking for database...");
        String query = "SHOW DATABASES;";
        ArrayList<ArrayList<String>> databases= database.getData(query, 1, true);

        for(int k = 0; k<databases.size(); k++){
            for(int j = 0; j<databases.get(k).size(); j++){
                if(databases.get(k).get(j).toLowerCase().equals("schedule")){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean LoadDatabase(Database database){
        String query= "USE Schedule;";
        database.setDatabase(query);
        query = "show tables;";
        ArrayList<ArrayList<String>> tables = database.getData(query, 1, true);
        int columnsfound = 0;
        for(int k = 0; k<tables.size(); k++){
            for(int j = 0; j<tables.get(k).size(); j++){
                if(tables.get(k).get(j).toLowerCase().equals("item")){
                    columnsfound++;
                }
                else if(tables.get(k).get(j).toLowerCase().equals("itemstatus")){
                    columnsfound++;
                }
                else if(tables.get(k).get(j).toLowerCase().equals("itemtype")){
                    columnsfound++;
                }
                else{
                    System.out.println("Found "+tables.get(k).get(j));
                }
            }
        }
        return columnsfound==3;
    }

    private static void createDatabase(Database database){
        SQLprocessor sqLprocessor = new SQLprocessor();
        ArrayList<String> commands = sqLprocessor.parseSQL("Planner");
        for(int y = 0; y<commands.size(); y++){
            database.setDatabase(commands.get(y));
        }
    }


    private static void startApp(){
        PlannerGUI gui = new PlannerGUI();
        gui.startgui();
    }

    public static void handleLogin(){
        System.out.println("Done");


        Database database = new Database(loginGUI.getUsername(), loginGUI.getPassword());
        if (database.connect()){
            System.out.println("Login successful");
        }
        else {
            System.out.println("Invalid credentials");
        }

        if(checkForDatabase(database)){
            System.out.println("Database found");
            if(LoadDatabase(database)){
                System.out.println("Database loaded");
                try {
                    ITEMSTATUS itemstatus = new ITEMSTATUS();
                    ITEMTYPE itemtype = new ITEMTYPE();
                    guiManager.switchToPlanner();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            System.out.println("Database not found");
            System.out.println("Attempting to create database");
            createDatabase(database);
            if (LoadDatabase(database)){
                System.out.println("Database successfully created and loaded");
                try {
                    guiManager.switchToPlanner();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println("Database not created");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter database login info:");

        guiManager = new GUIManager();
        guiManager.startgui();

    }
}