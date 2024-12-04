package nrainhas.nrainhas_frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nrainhas.nrainhas_frontend.controller.RainhaController;
import nrainhas.nrainhas_frontend.controller.TabuleiroController;
import nrainhas.nrainhas_frontend.model.Tabuleiro;
import nrainhas.nrainhas_frontend.view.TabuleiroView;

import java.io.IOException;
import java.time.Duration;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        int tamanhoTabuleiro = 2;
        int quantidadeRainhas = 1;

        Tabuleiro tabuleiro = new Tabuleiro(tamanhoTabuleiro);
        TabuleiroView tabuleiroView = new TabuleiroView(tamanhoTabuleiro);
        RainhaController rainhaController = new RainhaController(tabuleiro, tabuleiroView);
        TabuleiroController tabuleiroController = new TabuleiroController(tabuleiro, tabuleiroView, quantidadeRainhas);

        tabuleiroController.adicionarRainhas();

        rainhaController.iniciarMovimentoAleatorio();

        Scene scene = new Scene(tabuleiroView);
        stage.setTitle("Tabuleiro N Rainhas");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
