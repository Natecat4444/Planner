import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class PlannerGUI extends Application {
    DatabaseModerator database;
    ArrayList<Item> todoItems;
    BorderPane pane;

    public PlannerGUI(){

    }

    public void startgui(){
        Application.launch();
    }

    private void initItems(){
        todoItems = database.getItems();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        database = new DatabaseModerator();
        todoItems = new ArrayList<>();
        initItems();
        pane = new BorderPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
