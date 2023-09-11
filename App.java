import javafx.animation.Animation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        
        Text text = new Text(20, 50, "Programing is Fun.");
        text.setFill(Color.RED);

        pane.getChildren().add(text);

        EventHandler<ActionEvent> eventHandler = e -> {
            if(text.getText().length() > 0)
                text.setText("");
            else
                text.setText("Programing is Fun.");
        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        text.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED)
                animation.play();
            else
                animation.pause();
        });

        primaryStage.setTitle("Timeline Animation");
        primaryStage.setScene(new Scene(pane, 250, 250));
        primaryStage.show();
    }
}
