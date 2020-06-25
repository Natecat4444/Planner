import java.util.ArrayList;

/**
 * Created by nathankaufman on 10/25/19.
 */
public class ITEMSTATUS {
    private static ArrayList<String> iStatuses = new ArrayList<>();

    public ITEMSTATUS(){
        fetch();
    }

    private boolean fetch(){
        String query = "SELECT * FROM ITEMSTATUS;";
        Database database = new Database();
        ArrayList<ArrayList<String>> results = database.getData(query, 1, false);
        for(int y = 0; y<results.size(); y++){
            for(int u = 0; u<results.get(y).size(); u++){
                if(!results.get(y).get(u).equals("")){
                    String result = results.get(y).get(u);
                    iStatuses.add(result);
                }
            }
        }
        return true;
    }

    public static ArrayList<String> getiStatuses() {
        return iStatuses;
    }
}
