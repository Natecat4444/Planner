import java.time.LocalDate;
import java.util.ArrayList;

public class DatabaseModerator {
    private Database database;
    private ITEMSTATUS status;
    private ITEMTYPE types;

    public DatabaseModerator (){
        database = new Database();
        status = new ITEMSTATUS();
        types = new ITEMTYPE();

    }

    //TODO
    public ArrayList<Item> getItems(){
        ArrayList<ArrayList<String>> ItemIDs= database.getData("SELECT * FROM item;", 1, false);

        ArrayList<Item> Items = new ArrayList<>();

        for(int k = 0; k<ItemIDs.size(); k++){
            for(int j = 0; j<ItemIDs.get(k).size(); j++){

            }
        }
        return Items;
    }

    public int addItem(String name, LocalDate due, String type, String description, String status){
        return database.insertItem(name, due, type, description, status);
    }
}
