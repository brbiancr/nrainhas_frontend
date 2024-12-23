package nrainhas.nrainhas_frontend.view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import nrainhas.nrainhas_frontend.model.Rainha;

public class TabuleiroView extends GridPane {

    private Color[][] coresTabuleiro;

    public TabuleiroView(int tamanho){
        inicializarTabuleiro(tamanho);
    }

    public void inicializarTabuleiro(int tamanho){

        coresTabuleiro = new Color[tamanho][tamanho]; // Inicializa o array de cores

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                Rectangle celula = new Rectangle(50, 50); // Tamanho de cada célula

                // Define a cor das células e armazena no array
                if ((i + j) % 2 == 0) {
                    celula.setFill(Color.WHITE);
                    coresTabuleiro[i][j] = Color.WHITE;
                } else {
                    celula.setFill(Color.BLACK);
                    coresTabuleiro[i][j] = Color.BLACK;
                }

                this.add(celula, j, i);
            }
        }
    }

    public void adicionarRainha(Rainha rainha) {
        Circle rainhaView = new Circle(20, Color.GREEN); // Representa a rainha
        add(rainhaView, rainha.getColuna(), rainha.getLinha()); // Adiciona a rainha na célula correspondente

        setHalignment(rainhaView, HPos.CENTER);
        setValignment(rainhaView, VPos.CENTER);

    }

    public void removerRainha(Rainha rainha) {
        getChildren().removeIf(node ->
                GridPane.getColumnIndex(node) == rainha.getColuna() && GridPane.getRowIndex(node) == rainha.getLinha());
    }

    public void atualizarRainhaVisual(int linhaAntiga, int colunaAntiga, Rainha rainha) {
        // Adiciona as células corretamente
        Rectangle celulaAntiga = new Rectangle(50, 50);
        Rectangle celulaNova = new Rectangle(50, 50);

        // Garantir que a célula onde a rainha foi movida tenha a cor certa
        Color corAntiga = coresTabuleiro[linhaAntiga][colunaAntiga];
        Color corNova = coresTabuleiro[rainha.getLinha()][rainha.getColuna()];

        celulaAntiga.setFill(corAntiga);
        celulaNova.setFill(corNova);

        this.add(celulaAntiga, colunaAntiga, linhaAntiga);
        this.add(celulaNova, rainha.getColuna(), rainha.getLinha());

        // Adiciona a rainha na nova posição
        adicionarRainha(rainha);
    }
}
