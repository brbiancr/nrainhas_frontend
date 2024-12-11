package nrainhas.nrainhas_frontend.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import nrainhas.nrainhas_frontend.model.Rainha;
import nrainhas.nrainhas_frontend.model.Tabuleiro;
import nrainhas.nrainhas_frontend.view.TabuleiroView;

import java.util.Arrays;
import java.util.Random;

public class RainhaController {

    private Tabuleiro tabuleiro;
    private TabuleiroView tabuleiroView;

    public RainhaController(Tabuleiro tabuleiro, TabuleiroView tabuleiroView) {
        this.tabuleiro = tabuleiro;
        this.tabuleiroView = tabuleiroView;
    }

    public void adicionarRainhaAleatoria() {
        int[] posicao;

        do{
            posicao = gerarPosicaoAleatoria();
        } while(colisao(posicao));

        Rainha rainha = new Rainha(posicao[0], posicao[1]);

        tabuleiro.adicionarRainha(rainha);
        tabuleiroView.adicionarRainha(rainha);
    }

    private boolean colisao(int[] posicao) {
        for(Rainha rainha: tabuleiro.getRainhas()){
            if(rainha.getLinha() == posicao[0] && rainha.getColuna() == posicao[1])
                return true;
        }
        return false;
    }

    public void moverRainhaAleatoriamente(Rainha rainha) {
        int linhaAntiga = rainha.getLinha();
        int colunaAntiga = rainha.getColuna();

        tabuleiroView.removerRainha(rainha);

        int[] novaPosicao;

        do{
            novaPosicao = gerarPosicaoAleatoria(); // Nova posição da rainha
        } while (colisao(novaPosicao));

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
