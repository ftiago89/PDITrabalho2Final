package filters;

public class DeslocaFrequencia {
    private double[] X;
    private int deslocamento;

    //classe que desloca o vetor X[k] a partir de um c dado positivo
    public DeslocaFrequencia(double[] X, int deslocamento) {
        this.X = X;
        this.deslocamento = deslocamento;
        run();
    }
    
    private void run(){
        for (int i=0; i<this.X.length; ++i){
            if((i+this.deslocamento)>=X.length){
                this.X[i] = 0.0;
            }else{
                this.X[i] = X[i+this.deslocamento];
            }
        }
    }
    
}
