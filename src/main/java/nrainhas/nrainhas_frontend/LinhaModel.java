package nrainhas.nrainhas_frontend;

public class LinhaModel{
    private double comecoX;
    private double comecoY;
    private double fimX;
    private double fimY;

    public LinhaModel(double comecoX, double comecoY, double fimX, double fimY) {
        this.comecoX = comecoX;
        this.comecoY = comecoY;
        this.fimX = fimX;
        this.fimY = fimY;
    }

    public double getComecoX() {
        return comecoX;
    }

    public double getComecoY() {
        return comecoY;
    }

    public double getFimX() {
        return fimX;
    }

    public double getFimY() {
        return fimY;
    }
}
