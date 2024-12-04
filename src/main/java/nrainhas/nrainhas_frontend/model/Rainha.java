package nrainhas.nrainhas_frontend.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rainha {
    private int linha;
    private int coluna;

    public Rainha(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
}
