package nrainhas.nrainhas_frontend.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaPrincipalController {

    private Stage stage; // Janela principal

    @FXML
    private TextField rodadasField;

    @FXML
    private Button iniciarButton;

    @FXML
    private void initialize() {
        iniciarButton.setOnAction(event -> iniciarRodadas());
    }

    private void iniciarRodadas() {
        try {
            int rodadas = Integer.parseInt(rodadasField.getText());

            if(rodadas <= 0){
                throw new NumberFormatException();
            }

            carregarTabuleiro(rodadas);

        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido.");
        }
    }

    private void carregarTabuleiro(int rodadas){
        try{
            // Carregar o arquivo FXML do tabuleiro
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Tabuleiro.fxml"));

            loader.setControllerFactory(param -> new TabuleiroController(rodadas));

            Parent tabuleiroRoot = loader.load();

            // Obter o controlador do tabuleiro
            TabuleiroController controller = loader.getController();
            controller.inicializar();

            // Configurar a nova cena no stage
            Scene scene = new Scene(tabuleiroRoot);
            stage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("/Tabuleiro.css").toExternalForm());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage; // Injetar a referência do Stage principal
    }
}
