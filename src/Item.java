import java.time.LocalDate;

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
        return false;
    }

    //TODO
    public int insert(){
        String Query = "INSERT INTO Item(ItemName, ItemDue, ItemDescription, ItemType, ItemStatus ), VALUES(?,?,?,?)";
        return 0;
    }
}
