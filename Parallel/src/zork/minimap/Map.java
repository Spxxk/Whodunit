package zork.minimap;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Map {

    private static final double MAP_WIDTH = 2000;
    private static final double MAP_HEIGHT = 2000;
    private static final double MINIMAP_SCALE = 0.1;

    public void start(Stage primaryStage) {
        Canvas map = new Canvas(MAP_WIDTH, MAP_HEIGHT);
        Canvas miniMap = new Canvas(MAP_WIDTH * MINIMAP_SCALE, MAP_HEIGHT * MINIMAP_SCALE);

        drawMap(map.getGraphicsContext2D());

        miniMap.getGraphicsContext2D().drawImage(map.snapshot(null, null), 0, 0,
                MAP_WIDTH * MINIMAP_SCALE, MAP_HEIGHT * MINIMAP_SCALE);

        Pane root = new Pane();
        root.getChildren().addAll(map, miniMap);

        miniMap.setLayoutX(700);
        miniMap.setLayoutY(10);

        Scene scene = new Scene(root, 800, 800);

        scene.setOnMouseClicked(event -> {
            if (event.getTarget() == miniMap) {
                map.setLayoutX(-event.getX() / MINIMAP_SCALE + scene.getWidth() / 2);
                map.setLayoutY(-event.getY() / MINIMAP_SCALE + scene.getHeight() / 2);
            }
        });

        scene.setOnMouseDragged(event -> {
            if (event.getTarget() == map) {
                map.setLayoutX(map.getLayoutX() + event.getX());
                map.setLayoutY(map.getLayoutY() + event.getY());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawMap(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        for (int i = 0; i < MAP_WIDTH; i += 100) {
            for (int j = 0; j < MAP_HEIGHT; j += 100) {
                gc.fillRect(i, j, 50, 50);
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}