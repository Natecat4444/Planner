import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by nathankaufman on 4/4/22.
 */
public class GUIManager extends Application {
    private static Stage primaryStage;
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
        this.primaryStage.setTitle("Login");
        loginGUI loginGUI = new loginGUI();
        loginGUI.init();
        this.primaryStage.setScene(loginGUI.getScene());
        this.primaryStage.show();
    }

    public void switchToPlanner() throws Exception{
        PlannerGUI plannerGUI = new PlannerGUI();
        plannerGUI.init();
        primaryStage.setScene(plannerGUI.getScene());
        primaryStage.show();
    }

    public void startgui(){
        Application.launch();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
