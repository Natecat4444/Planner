import java.util.ArrayList;

/**
 * Created by nathankaufman on 4/6/22.
 */
public class ItemManager {
    private static DatabaseModerator databaseModerator;
    private static ArrayList<Item> items;

    public void init(){
        databaseModerator = new DatabaseModerator();
        items = databaseModerator.getItems();
    }

    public boolean addItem(Item item){
        items.add(item);
        return true;
    }


}
