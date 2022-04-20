import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;


import java.time.LocalDate;
import java.util.ArrayList;

public class PlannerGUI extends Application {
    DatabaseModerator database;
    ArrayList<Item> todoItems;
    BorderPane pane;
    TextField nameIn;
    TextArea descIn;
    DatePicker datePicker;
    LocalDate date;
    ChoiceBox status;
    ChoiceBox type;
    String istatus;
    String itype;

    public void init() throws Exception{
        database = new DatabaseModerator();
        todoItems = new ArrayList<>();
        initItems();
        pane = new BorderPane();
        pane.setTop(menu());

    }

    public VBox showItems(){
        return new VBox();
    }

    public VBox addItem(){
        nameIn = new TextField();
        descIn = new TextArea();

        datePicker = new DatePicker();
        datePicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                date = datePicker.getValue();
            }
        });
        status = new ChoiceBox();
        status.getItems().addAll(ITEMSTATUS.getiStatuses());
        status.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                istatus = status.getValue().toString();
            }
        });

        type = new ChoiceBox();
        type.getItems().addAll(ITEMTYPE.getTypes());
        type.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                itype = status.getValue().toString();
            }
        });

        Button submit = new Button();
        submit.setText("Add Item");

        submit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO

            }
        });

        Label nameL = new Label("Item Name:");
        Label descL = new Label("Description:");
        Label dateL = new Label("Due Date:");
        Label statusL = new Label("Status:");
        Label typeL = new Label("Type:");

        HBox hBox = new HBox(nameL, nameIn);
        HBox hBox1 = new HBox(typeL, type);
        HBox hBox2 = new HBox(dateL, datePicker);
        HBox hBox3 = new HBox(statusL, status);
        HBox hBox4 = new HBox(descL, descIn);

        return new VBox(hBox, hBox1, hBox2, hBox3, hBox4, submit);
    }

    public HBox menu(){
        Button viewItems = new Button();
        viewItems.setText("View Items");
        viewItems.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.setCenter(showItems());
            }
        });

        Button addItem = new Button();
        addItem.setText("Add Item");
        addItem.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                pane.setCenter(addItem());
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
