package nrainhas.nrainhas_frontend.controller;

import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import nrainhas.nrainhas_frontend.model.Tabuleiro;
import javafx.scene.shape.Rectangle;

public class TabuleiroController {

    @FXML
    private Button pauseButton;

    @FXML
    private Button restartButton;

    @FXML
    private GridPane tabuleiroGrid;

    private Tabuleiro tabuleiro;

    private RainhaController rainhaController;

    private int rodadas;

    private Timeline movimentoTimeline;
    private boolean movimentoEmAndamento;

    public TabuleiroController(int rodadas){
        this.tabuleiro = new Tabuleiro(8);
        this.movimentoEmAndamento = false;
        this.rodadas = rodadas;
    }

    @FXML
    private void initialize(){
        pauseButton.setOnAction(event -> pausarTabuleiro());
        restartButton.setOnAction(event -> reiniciarTabuleiro());
    }

    public void inicializar(){
        gerarTabuleiro();

        if(rainhaController == null){
            rainhaController = new RainhaController(tabuleiroGrid, tabuleiro.getTamanho(), this);
            rainhaController.inicializarRainhas();
            rainhaController.iniciarMovimento(rodadas);
        }
    }

    public void gerarTabuleiro(){
        tabuleiroGrid.getChildren().clear(); // Limpa o gridPane antes de preencher

        for(int i = 0; i < tabuleiro.getTamanho(); i++){
            for(int j = 0; j < tabuleiro.getTamanho(); j++){
                Rectangle celula = new Rectangle(50, 50); // Tamanho de cada célula

                // Define a cor das células e armazena no array
                if ((i + j) % 2 == 0) {
                    celula.setFill(Color.WHITE);
                } else {
                    celula.setFill(Color.BLACK);
                }

                tabuleiroGrid.add(celula, j, i);
            }
        }
    }

    @FXML
    private void pausarTabuleiro(){
        if(movimentoEmAndamento){
            movimentoTimeline.pause(); // Pausa as rainhas
            movimentoEmAndamento = false;
            pauseButton.setText("Play");
        } else{
            movimentoTimeline.play();
            movimentoEmAndamento = true; // Retoma movimento das rainhas
            pauseButton.setText("Pause");
        }
    }

    @FXML
    private void reiniciarTabuleiro(){
        tabuleiroGrid.getChildren().clear();

        // Recriando o tabuleiro
        gerarTabuleiro();
        rainhaController.inicializarRainhas();
        movimentoEmAndamento = true;

        pauseButton.setText("Pause");

        rainhaController.iniciarMovimento(rodadas);

    }

    public void setMovimentoTimeline(Timeline timeline) {
        this.movimentoTimeline = timeline; // Define a timeline do movimento das rainhas
    }
}
