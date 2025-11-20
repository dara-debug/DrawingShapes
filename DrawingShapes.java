
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * This file can be used to draw simple pictures. Just fill in
 * the definition of drawPicture with the code that draws your picture.
 */
public class DrawingShapes extends Application {

    /**
     * Draws a picture. The parameters width and height give the size
     * of the drawing area, in pixels.
     */
    public void drawPicture(GraphicsContext g, int width, int height) {

        g.setFill(Color.WHITE);
        g.fillRect(0, 0, width, height); // First, fill the entire image with a background color.

        Random random = new Random();
        if (random.nextInt(2) == 0) {
            drawShapes(g, width, height);
        } else {
            drawConcentrics(g, width, height);
        }

    } // end drawPicture()

    // Funciton that draws concentric circle or sqaures
    public void drawConcentrics(GraphicsContext g, int width, int height) {
        double centerX = width / 2; // center X of the canvas
        double centerY = height / 2; // center Y of the canvas

        double widthRect; // width of rectangle the circle will be drwan in
        double heightRect;

        double totalWidth; // width of the rectangle plus thickness (stroke width)
        double totalHeight;

        double cornerX; // top corner of the circle needed for strokeOval()
        double cornerY;

        double thickness; // thickness of the stroke. Used by setLineWidth()

        Random random = new Random();

        int choiceOfSize = random.nextInt(3);
        switch (choiceOfSize) {
            case 0:
                widthRect = 30;
                heightRect = 30;
                thickness = 10;
                break;

            case 1:
                widthRect = 150;
                heightRect = 150;
                thickness = 50;
                break;

            default:
                widthRect = 300;
                heightRect = 300;
                thickness = 100;
                break;
        }

        totalWidth = widthRect + thickness;
        totalHeight = heightRect + thickness;
        g.setLineWidth(thickness);

        int choiceOfConcentric = random.nextInt(3);
        for (double i = widthRect; i <= 1000; i += thickness) {
            g.setStroke(pickColor());
            cornerX = centerX - (widthRect / 2); // top corner of the circle needed for strokeOval()
            cornerY = centerY - (heightRect / 2);

            if (choiceOfConcentric == 0) {
                g.strokeOval(cornerX, cornerY, widthRect, heightRect);
            } else if (choiceOfConcentric == 1) {
                g.strokeRect(cornerX, cornerY, widthRect, heightRect);
            } else {
                if (random.nextInt(2) == 0) {
                    g.strokeOval(cornerX, cornerY, widthRect, heightRect);
                } else {
                    g.strokeRect(cornerX, cornerY, widthRect, heightRect);
                }
            }

            widthRect += totalWidth;
            heightRect += totalHeight;
        }
    } // end drawConcentrics()

    // Function that draws circles at random coordinates within the canvas
    public void drawShapes(GraphicsContext g, int width, int height) {


        double widthRect; // width of rectangle the circle will be drwan in
        double heightRect;

        double x;
        double y;

        Random random = new Random();

        int choiceOfSize = random.nextInt(3);
        switch (choiceOfSize) {
            case 0:
                widthRect = 10;
                heightRect = 10;
                break;

            case 1:
                widthRect = 50;
                heightRect = 50;
                break;

            default:
                widthRect = 100;
                heightRect = 100;
                break;
        }

        int choiceOfShape = random.nextInt(3);
        for (int i = 0; i < 5000; i++) {
            g.setFill(pickColor());
            g.setStroke(Color.BLACK);
            g.setLineWidth(10);

            x = random.nextInt(width);
            y = random.nextInt(height);

            if (choiceOfShape == 0) {
                g.strokeOval(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                g.fillOval(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
            } else if (choiceOfShape == 1) {
                g.strokeRect(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                g.fillRect(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
            } else {
                if (random.nextInt(2) == 0) {
                    g.strokeOval(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                    g.fillOval(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                } else {
                    g.strokeRect(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                    g.fillRect(x - widthRect / 2, y - heightRect / 2, widthRect, heightRect);
                }
            }
        }

    } // end drawCircles()

    // Method to generate a regular n-sided polygon
    public Polygon createRegularPolygon(int sides, double radius, double centerX, double centerY) {
        Polygon polygon = new Polygon();
        for (int i = 0; i < sides; i++) {
            double angle = 2 * Math.PI * i / sides;
            double x = centerX + radius * Math.cos(angle);
            double y = centerY + radius * Math.sin(angle);
            polygon.getPoints().addAll(x, y);
        }
        return polygon;
    }
    
    // Function that returns a random color from an array of colors
    public Color pickColor() {

        Random rand = new Random();
        int choice = rand.nextInt(4);
        switch (choice) {
            case 0:
                Color[] colors = {
                        Color.RED,
                        Color.BLUE,
                        Color.GREEN,
                        Color.ORANGE,
                        Color.PURPLE,
                        Color.CYAN,
                        Color.MAGENTA,
                        Color.YELLOW,
                        Color.DEEPPINK,
                        Color.LIME,
                        Color.TURQUOISE,
                        Color.GOLD,
                        Color.CORNFLOWERBLUE,
                        Color.CRIMSON,
                        Color.DARKORANGE,
                        Color.MEDIUMSEAGREEN,
                        Color.HOTPINK,
                        Color.ROYALBLUE,
                        Color.TEAL,
                        Color.VIOLET
                };
                return colors[rand.nextInt(20)];

            case 1:
                Color[] softColors = {
                        Color.web("#FF6B6B"), // soft red
                        Color.web("#4ECDC4"), // teal
                        Color.web("#FFD93D"), // warm yellow
                        Color.web("#6A4C93"), // purple
                        Color.web("#1A535C"), // dark teal
                        Color.web("#FF9F1C"), // orange
                        Color.web("#FFB6B9"), // light pink
                        Color.web("#8AC6D1"), // sky blue
                        Color.web("#A8E6CF"), // mint green
                        Color.web("#FFD3B6"), // peach
                        Color.web("#DCEDC1"), // pale green
                        Color.web("#FFAAA5"), // coral
                        Color.web("#D4A5A5"), // dusty rose
                        Color.web("#B5EAD7"), // light mint
                        Color.web("#C7CEEA"), // lavender
                        Color.web("#F3C5FF"), // lilac
                        Color.web("#A0E7E5"), // cyan
                        Color.web("#B4F8C8"), // pastel green
                        Color.web("#FBE7C6"), // cream
                        Color.web("#FFDAC1") // soft peach
                };
                return softColors[rand.nextInt(20)];

            case 2:
                Color[] vibrantColors = {
                        Color.RED,
                        Color.ORANGE,
                        Color.YELLOW,
                        Color.GREEN,
                        Color.CYAN,
                        Color.BLUE,
                        Color.MAGENTA,
                        Color.PINK,
                        Color.LIME,
                        Color.DEEPSKYBLUE,
                        Color.GOLD,
                        Color.DARKORANGE,
                        Color.MEDIUMVIOLETRED,
                        Color.SPRINGGREEN,
                        Color.AQUA,
                        Color.HOTPINK,
                        Color.TURQUOISE,
                        Color.CHARTREUSE,
                        Color.DODGERBLUE,
                        Color.ORCHID
                };
                return vibrantColors[rand.nextInt(20)];

            default:
                Color[] earthyColors = {
                        Color.web("#8D6E63"), // brown
                        Color.web("#A1887F"), // taupe
                        Color.web("#BCAAA4"), // light mocha
                        Color.web("#4E342E"), // dark brown
                        Color.web("#3E2723"), // espresso
                        Color.web("#607D8B"), // blue gray
                        Color.web("#455A64"), // slate
                        Color.web("#78909C"), // soft blue gray
                        Color.web("#2E7D32"), // forest green
                        Color.web("#388E3C"), // deep green
                        Color.web("#81C784"), // minty green
                        Color.web("#AED581"), // light green
                        Color.web("#FDD835"), // muted yellow
                        Color.web("#FBC02D"), // golden yellow
                        Color.web("#FFA726"), // amber
                        Color.web("#FB8C00"), // orange
                        Color.web("#E64A19"), // burnt orange
                        Color.web("#D84315"), // terracotta
                        Color.web("#5D4037"), // coffee
                        Color.web("#BF360C") // clay red
                };
                return earthyColors[rand.nextInt(20)];

        }
    } // end pickColor()

    // ------ Implementation details: DO NOT EXPECT TO UNDERSTAND THIS ------

    public void start(Stage stage) {
        int width = 800; // The width of the image. You can modify this value!
        int height = 600; // The height of the image. You can modify this value!

        Canvas canvas = new Canvas(width, height);
        GraphicsContext g = canvas.getGraphicsContext2D();

        BorderPane root = new BorderPane(canvas);
        root.setStyle("-fx-border-width: 4px; -fx-border-color: #444");

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Visualizer"); // STRING APPEARS IN WINDOW TITLEBAR!
        stage.show();
        stage.setResizable(false);

        // --- Animation Timeline ---
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.seconds(0), e -> drawPicture(g, width, height)), // initial draw
            new KeyFrame(Duration.seconds(0.5)) // redraw every 0.1 seconds
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        // --- End Animation ---
    }
    

    public static void main(String[] args) {
        launch();
    }

} // end SimpleGraphicsStarter
