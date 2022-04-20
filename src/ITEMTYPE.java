import java.util.ArrayList;

/**
 * Created by nathankaufman on 10/25/19.
 */
public class ITEMTYPE {
    private static ArrayList<String> Types;

    public ITEMTYPE(){
        fetch();
    }

    private boolean fetch(){
        Types = new ArrayList<>();
        String query = "SELECT * FROM ITEMTYPE;";
        Database database = new Database();
        ArrayList<ArrayList<String>> results = database.getData(query, 1, false);
        for(int y = 0; y<results.size(); y++){
            for(int u = 0; u<results.get(y).size(); u++){
                if(!results.get(y).get(u).equals("")){
                    String result = results.get(y).get(u);
                    Types.add(result);
                }
            }
        }
        return true;
    }

    public static ArrayList<String> getTypes() {
        return Types;
    }
}
