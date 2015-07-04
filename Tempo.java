package sample;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


aaaaaaaaaassss
/**
 * Created by davidperrey on 20/12/2014.
 */
public class Tempo extends Parent {

    ImageView vignette;

    private String textX;
    private String textY;

    public Tempo(){

        final Color shadowColor = Color.BLACK.deriveColor(0, 0, 0, 0.75);
        final DropShadow dropShadow = new DropShadow(BlurType.THREE_PASS_BOX, shadowColor, 50, 0, 0, 0);

        vignette = new javafx.scene.image.ImageView(new Image(Tempo.class.getResourceAsStream("img/tempoOnClick3.png")));
        vignette.setFitHeight(110);
        vignette.setPreserveRatio(true);
        vignette.setEffect(dropShadow);

        this.setTranslateX(415);
        this.setTranslateY(180);

        final Text tPosX = new Text(-405,45,"");
        tPosX.setFont(Font.font("Verdana", 14));
        tPosX.setFill(Color.rgb(160,160,160));
        tPosX.setVisible(false);

        final Text tPosY = new Text(65,-120,"");
        tPosY.setFont(Font.font("Verdana",14));
        tPosY.setFill(Color.rgb(160,160,160));
        tPosY.setVisible(false);


        final Line lineX =  new Line(-415,55,720,55);
        lineX.setStroke(Color.rgb(225, 35, 104));
        lineX.setStrokeLineCap(StrokeLineCap.ROUND);
        lineX.getStrokeDashArray().addAll(5d, 5d, 5d, 5d, 5d);
        lineX.setStrokeWidth(1);
        lineX.setVisible(false);

        final Line lineY =  new Line(55,-180,55,580);
        lineY.setStroke(Color.rgb(225, 35, 104));
        lineY.setStrokeLineCap(StrokeLineCap.ROUND);
        lineY.getStrokeDashArray().addAll(5d, 5d, 5d, 5d, 5d);
        lineY.setStrokeWidth(1);
        lineY.setVisible(false);

        this.getChildren().add(tPosX);
        this.getChildren().add(tPosY);
        this.getChildren().add(lineX);
        this.getChildren().add(lineY);
        this.getChildren().add(vignette);


        EventHandler<MouseEvent> mouseHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                vignette.setTranslateX(mouseEvent.getX()-50);
                vignette.setTranslateY(mouseEvent.getY() - 50);
                vignette.setRotate(vignette.getRotate() + 5);
                lineX.setTranslateY(mouseEvent.getY()-50);
                lineY.setTranslateX(mouseEvent.getX()-50);
                tPosX.setTranslateY(mouseEvent.getY()-50);
                tPosY.setTranslateX(mouseEvent.getX()-50);


                textX = "X : "+(int)(vignette.getTranslateX()+415);
                tPosX.setText(textX);
                textY = "Y : "+(int)(vignette.getTranslateY()+180);
                tPosY.setText(textY);
            }
        };

        EventHandler<MouseEvent> mouseHandler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                lineX.setVisible(false);
                lineY.setVisible(false);
                tPosX.setVisible(false);
                tPosY.setVisible(false);
            }
        };

        EventHandler<MouseEvent> mouseHandler3 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                lineX.setVisible(true);
                lineY.setVisible(true);
                tPosX.setVisible(true);
                tPosY.setVisible(true);
            }
        };

        this.setOnMouseDragged(mouseHandler);
        this.setOnMouseExited(mouseHandler2);
        this.setOnMouseEntered(mouseHandler3);

    }

    public int getBPM(){
        return (int)(vignette.getTranslateX()+415);

    }
}
