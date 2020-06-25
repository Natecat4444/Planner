public class DatabaseModerator {
    private Database database;
    private ITEMSTATUS status;
    private ITEMTYPE types;

    public DatabaseModerator (){
        Database database = new Database();
        status = new ITEMSTATUS();
        types = new ITEMTYPE();

    }
}
