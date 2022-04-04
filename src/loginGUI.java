import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;



/**
 * Created by nathankaufman on 9/13/19.
 */
public class loginGUI extends Application {
    private static String Username = "";
    private static String Password = "";
    private TextField UserIn;
    private Label user;
    private Label pass;
    private PasswordField PassIn;
    private Button button;
    private HBox hBox;
    private  HBox hBox1;
    private Stage primaryStage;
    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     * <p>
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        VBox vBox = new VBox(hBox, hBox1, button);
        primaryStage.setTitle("Login");
        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Scene getScene(){
        VBox vBox = new VBox(hBox, hBox1, button);
//        primaryStage.setTitle("Login");
        Scene scene = new Scene(vBox);
        return scene;
    }

    public void init() throws Exception{
        UserIn = new TextField();
        PassIn = new PasswordField();
        button = new Button();
        button.setText("Login");
        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setUsername(UserIn.getText());
                setPassword(PassIn.getText());
                Planner.handleLogin();
                //TODO give message if login unsuccessful
//                primaryStage = GUIManager.getPrimaryStage();
//                primaryStage.close();
            }
        });
        user = new Label("Username:");
        user.setText("Username:");
        hBox = new HBox(user, UserIn);

        pass = new Label("Password:");
        hBox1 = new HBox(pass, PassIn);
    }

    protected static String getUsername(){
        return Username;
    }

    protected static String getPassword(){
        return Password;
    }

    private void setUsername(String username){
        Username = username;
    }

    private void setPassword(String password){
        Password = password;
    }

    public void startgui() {
        Application.launch();
    }
}
