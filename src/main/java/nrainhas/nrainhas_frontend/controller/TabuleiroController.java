package nrainhas.nrainhas_frontend.controller;

import nrainhas.nrainhas_frontend.model.Tabuleiro;
import nrainhas.nrainhas_frontend.view.TabuleiroView;

import java.util.Random;

public class TabuleiroController {
    private Tabuleiro tabuleiro;
    private TabuleiroView tabuleiroView;
    private RainhaController rainhaController;
    private int quantidadeRainhas;

    public TabuleiroController(Tabuleiro tabuleiro, TabuleiroView tabuleiroView, int quantidadeRainhas){
        this.tabuleiro = tabuleiro;
        this.tabuleiroView = tabuleiroView;
        this.rainhaController = new RainhaController(tabuleiro, tabuleiroView);
        this.quantidadeRainhas = quantidadeRainhas;

        inicializarInterface();
    }

    private void inicializarInterface() {
        tabuleiro.getRainhas().forEach(rainha ->
                tabuleiroView.adicionarRainha(rainha));
    }

    public void adicionarRainhas() {
        for(int i = 0; i < quantidadeRainhas; i++)
            rainhaController.adicionarRainhaAleatoria();
    }
}
