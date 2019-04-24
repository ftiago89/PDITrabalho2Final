
package filters;

//classe que representa o objeto runnable que vai ser rodado pela thread
public class RunnableIDCT implements Runnable{
    private double[] cossenos;
    private int N;
    private double[] resultadoParte;
    private int n;
    private int limite;
    
    public RunnableIDCT(double[] dados, int n, int limite, int N){
        this.cossenos = dados;
        this.N = N;
        this.n = n;
        this.limite = limite;
    }

    @Override
    public void run() {
        resultadoParte = new DCT().IDct(this.cossenos, this.n, this.limite, this.N);
    }

    public double[] getResultadoParte() {
        return resultadoParte;
    }
    
}
