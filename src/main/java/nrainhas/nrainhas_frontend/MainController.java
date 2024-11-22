package nrainhas.nrainhas_frontend;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class MainController {
    @FXML
    private LinhaModel linhaModel;

    @FXML
    private Pane drawingPane;

    @FXML
    public void initialize() {
        // Configurar modelo com coordenadas da linha
        linhaModel = new LinhaModel(20, 100, 300, 100);

        // Desenhar a linha no painel apos 1 segundo
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(event -> drawLine());
        pause.play();
    }

    private void drawLine() {
        Line line = new Line(
                linhaModel.getComecoX(),
                linhaModel.getComecoY(),
                linhaModel.getFimX(),
                linhaModel.getFimY()
        );

        // Adicionar a linha ao painel
        drawingPane.getChildren().add(line);
    }
}