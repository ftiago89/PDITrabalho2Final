package filters;

//classe que representa o objeto runnable que vai ser rodado pela thread
public class RunnableDCT implements Runnable {

    private double[] dados;
    private int N;
    private double[] resultadoParte;
    private int k;
    private int limite;

    public RunnableDCT(double[] dados, int k, int limite, int N) {
        this.dados = dados;
        this.N = N;
        this.k = k;
        this.limite = limite;
    }

    @Override
    public void run() {
        resultadoParte = new DCT().Dct(this.dados, this.k, this.limite, this.N);
    }

    public double[] getResultadoParte() {
        return resultadoParte;
    }

}
