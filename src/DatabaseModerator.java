import java.time.LocalDate;
import java.time.LocalDateTime;
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
        ArrayList<ArrayList<String>> ItemIDs= database.getData("SELECT * FROM item;", 7, false);

        ArrayList<Item> Items = new ArrayList<>();
        System.out.println("getting items");

        System.out.println("got array size of: "+ItemIDs.size());
        for(int k = 0; k<ItemIDs.size(); k++){
//            System.out.println("k: "+k);
//            System.out.println("Retrieved array size: "+ItemIDs.get(k).size());
            System.out.println(ItemIDs.get(k));
            int id = Integer.parseInt(ItemIDs.get(k).get(0));
            String name = ItemIDs.get(k).get(1);
            String desc = ItemIDs.get(k).get(2);
            LocalDate due = LocalDate.parse(ItemIDs.get(k).get(3));
            String type = ItemIDs.get(k).get(4);
//            LocalDateTime created = LocalDateTime.parse(ItemIDs.get(k).get(5));
            String status = ItemIDs.get(k).get(6);
            Item item = new Item(id, name, desc, due, type, status);
            Items.add(item);
        }
        return Items;
    }

    public int addItem(String name, LocalDate due, String type, String description, String status){
        return database.insertItem(name, due, type, description, status);
    }
}
