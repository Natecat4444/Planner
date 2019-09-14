/**
 * Created by nathankaufman on 9/13/19.
 */
public class Item <E> {
    private E id;
    private E name;
    private E Description;
    private E Due;
    private E Type;
    private E Status;

    public Item(E name, E Due){
        this.name = name;
        this.Due = Due;
        Type = (E)"Other";
        Status = (E) "TODO";
    }

    public E getDescription() {
        return Description;
    }

    public E getDue() {
        return Due;
    }

    public E getId() {
        return id;
    }

    public E getName() {
        return name;
    }

    public E getStatus() {
        return Status;
    }

    public E getType() {
        return Type;
    }

    public void setDescription(E description) {
        Description = description;
    }

    public void setDue(E due) {
        Due = due;
    }

    public void setId(E id) {
        this.id = id;
    }

    public void setName(E name) {
        this.name = name;
    }

    public void setStatus(E status) {
        Status = status;
    }

    public void setType(E type) {
        Type = type;
    }
}
