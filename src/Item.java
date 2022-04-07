import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Created by nathankaufman on 9/13/19.
 */
public class Item {
    private int id;
    private String name;
    private String Description;
    private LocalDate Due;
    private String Type;
    private String Status;

    public Item(String name, LocalDate Due){
        this.name = name;
        this.Due = Due;
        Type = "Other";
        Status =  "TODO";
    }

    public Item (int id,String name, String description, LocalDate due, String type, String status){
        this.id = id;
        this.name = name;
        Description = description;
        Due = due;
        Type = type;
        Status = status;
    }

    public Item(String name, String description, LocalDate due, String type, String status){
        this.name = name;
        Description = description;
        Due = due;
        Type = type;
        Status = status;
        insert();
    }

    public String getDescription() {
        return Description;
    }

    public LocalDate getDue() {
        return Due;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return Status;
    }

    public String getType() {
        return Type;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setDue(LocalDate due) {
        Due = due;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setType(String type) {
        Type = type;
    }

    //ToDO
    public boolean fetch(){
        String Query = "Select * FROM item WHERE ItemID="+this.id+";";
        Database database = new Database();
        ArrayList<ArrayList<String>> item = database.getData(Query, 5, false);
        database.close();
        System.out.println(item);
        return false;
    }


    public int insert(){
        Database database = new Database();
        int success =  database.insertItem(name, Due, Type, Description, Status);
        database.close();
        return success;
    }
}
