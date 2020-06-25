import java.util.ArrayList;

public class DatabaseModerator {
    private Database database;
    private ITEMSTATUS status;
    private ITEMTYPE types;

    public DatabaseModerator (){
        Database database = new Database();
        status = new ITEMSTATUS();
        types = new ITEMTYPE();

    }

    //TODO
    public ArrayList<Item> getItems(){
        ArrayList<ArrayList<String>> ItemIDs= database.getData("SELECT ItemID FROM item;", 1, false);

        ArrayList<Integer> ids = new ArrayList<>();

        for(int k = 0; k<ItemIDs.size(); k++){
            for(int j = 0; j<ItemIDs.get(k).size(); j++){

            }
        }
        return null;
    }
}
