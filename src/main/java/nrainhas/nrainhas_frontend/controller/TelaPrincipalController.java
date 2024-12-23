package nrainhas.nrainhas_frontend.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nrainhas.nrainhas_frontend.model.Tabuleiro;
import nrainhas.nrainhas_frontend.view.TabuleiroView;

public class TelaPrincipalController {

    private int tamanhoTabuleiro = 8;
    private Stage stage;

    @FXML
    private TextField rodadasField;

    @FXML
    private Button iniciarButton;

    @FXML
    private void initialize() {
        // Ação quando o botão "Iniciar" for clicado
        iniciarButton.setOnAction(event -> iniciarRodadas());
    }

    private void iniciarRodadas() {
        if(stage == null){
            System.out.println("Stage null");
            return;
        }

        try {
            int rodadas = Integer.parseInt(rodadasField.getText());

            if(rodadas <= 0){
                throw new NumberFormatException();
            }

            exibirTabuleiro(rodadas);

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido.");
        }
    }

    private void exibirTabuleiro(int rodadas){
        Tabuleiro tabuleiro = new Tabuleiro(tamanhoTabuleiro);
        TabuleiroView tabuleiroView = new TabuleiroView(tamanhoTabuleiro);
        TabuleiroController tabuleiroController = new TabuleiroController(tabuleiro, tabuleiroView, tamanhoTabuleiro);
        RainhaController rainhaController = new RainhaController(tabuleiro, tabuleiroView);

        // Adicionar o TabuleiroView à cena
        Scene tabuleiroScene = new Scene(tabuleiroView);
        stage.setTitle("Tabuleiro N Rainhas");
        stage.setScene(tabuleiroScene);

        tabuleiroController.adicionarRainhas();

        rainhaController.iniciarMovimentoAleatorio(rodadas);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
