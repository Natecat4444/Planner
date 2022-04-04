import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;



import java.util.ArrayList;

public class PlannerGUI extends Application {
    DatabaseModerator database;
    ArrayList<Item> todoItems;
    BorderPane pane;

    public void init() throws Exception{
        database = new DatabaseModerator();
        todoItems = new ArrayList<>();
        initItems();
        pane = new BorderPane();
        pane.setTop(menu());

    }

    public HBox menu(){
        Button viewItems = new Button();
        viewItems.setText("View Items");
        viewItems.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO
            }
        });

        Button addItem = new Button();
        addItem.setText("Add Item");
        addItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });
        return new HBox(viewItems, addItem);
    }

    public Scene getScene(){
        Scene scene = new Scene(pane);
        return scene;
    }

    public void startgui(){
        Application.launch();
    }

    private void initItems(){
        todoItems = database.getItems();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(getScene());
        primaryStage.show();
    }
}
