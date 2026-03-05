package dto;

public class Estatistica {

    private double media;
    private double mediana;
    private double variancia;
    private double desvioPadrao;
    private double moda;

    public Estatistica(double media,
                       double mediana,
                       double variancia,
                       double desvioPadrao,
                       double moda) {

        this.media = media;
        this.mediana = mediana;
        this.variancia = variancia;
        this.desvioPadrao = desvioPadrao;
        this.moda = moda;
    }

    public double getMedia() { return media; }
    public double getMediana() { return mediana; }
    public double getVariancia() { return variancia; }
    public double getDesvioPadrao() { return desvioPadrao; }
    public double getModa() { return moda; }
}