package nrainhas.nrainhas_frontend.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import nrainhas.nrainhas_frontend.model.Rainha;
import nrainhas.nrainhas_frontend.model.Tabuleiro;
import nrainhas.nrainhas_frontend.view.TabuleiroView;

import java.util.Random;

public class RainhaController {

    private Tabuleiro tabuleiro;
    private TabuleiroView tabuleiroView;

    public RainhaController(Tabuleiro tabuleiro, TabuleiroView tabuleiroView) {
        this.tabuleiro = tabuleiro;
        this.tabuleiroView = tabuleiroView;
    }

    public void adicionarRainhaAleatoria() {
        int[] posicao = gerarPosicaoAleatoria();

        Rainha rainha = new Rainha(posicao[0], posicao[1]);

        tabuleiro.adicionarRainha(rainha);
        tabuleiroView.adicionarRainha(rainha);
    }


    public void moverRainhaAleatoriamente(Rainha rainha) {
        int linhaAntiga = rainha.getLinha();
        int colunaAntiga = rainha.getColuna();

        tabuleiroView.removerRainha(rainha);

        int[] novaPosicao = gerarPosicaoAleatoria(); // Nova posição da rainha

        rainha.setLinha(novaPosicao[0]);
        rainha.setColuna(novaPosicao[1]);

        tabuleiroView.atualizarRainhaVisual(linhaAntiga, colunaAntiga, rainha);
    }

    private int[] gerarPosicaoAleatoria() {
        Random random = new Random();
        int linha = random.nextInt(tabuleiro.getTamanho());
        int coluna = random.nextInt(tabuleiro.getTamanho());
        return new int[]{linha, coluna};
    }

    public void iniciarMovimentoAleatorio() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            if (!tabuleiro.getRainhas().isEmpty())
                tabuleiro.getRainhas().forEach(this::moverRainhaAleatoriamente);

        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
