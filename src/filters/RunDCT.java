package filters;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

//classe que vai dividir o vetor x[n] em 4 para ser calculado por 4 threads.
public class RunDCT {

    private double[] dados1, dados2, dados3, dados4, resultadoFinal;
    private RunnableDCT r1, r2, r3, r4;
    boolean isPronto = false;

    //copia os arrays para nao dar problema de sincronismo
    public RunDCT(double[] dados) {
        this.dados1 = dados;
        this.dados2 = Arrays.copyOf(dados1, dados1.length);
        this.dados3 = Arrays.copyOf(dados1, dados1.length);
        this.dados4 = Arrays.copyOf(dados1, dados1.length);
        run();
    }

    //divide os limites que cada runnable vai rodar e executa em 4 threads
    private void run() {
        int step = dados1.length / 4;

        r1 = new RunnableDCT(dados1, 0, step, dados1.length);
        r2 = new RunnableDCT(dados2, step, 2 * step, dados2.length);
        r3 = new RunnableDCT(dados3, 2 * step, 3 * step, dados3.length);
        r4 = new RunnableDCT(dados4, 3 * step, 4 * step, dados4.length);

        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();
        Thread t3 = new Thread(r3);
        t3.start();
        Thread t4 = new Thread(r4);
        t4.start();

        //espera todas as execuções acabarem
        while (t1.isAlive() || t2.isAlive() || t3.isAlive() || t4.isAlive()) {
            ;//comando vazio
        }
        /*
        for(int i = 0; i<r2.getResultadoParte().length; ++i) System.out.print(r2.getResultadoParte()[i] + " ");
        for(int i = 0; i<r2.getResultadoParte().length; ++i) System.out.print(r2.getResultadoParte()[i] + " ");
        for(int i = 0; i<r3.getResultadoParte().length; ++i) System.out.print(r3.getResultadoParte()[i] + " ");
        for(int i = 0; i<r4.getResultadoParte().length; ++i) System.out.print(r4.getResultadoParte()[i] + " ");
         */

        //junta os 4 vetores resultantes das 4 threads e forma o X[k]
        resultadoFinal = combine(r1.getResultadoParte(), r2.getResultadoParte(),
                r3.getResultadoParte(), r4.getResultadoParte());

        for (int k = 0; k < resultadoFinal.length; k++) {
            resultadoFinal[k] = new BigDecimal(resultadoFinal[k]).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
        }

        isPronto = true;
    }

    //concatena 4 arrays
    private double[] combine(double[] a, double[] b, double[] c, double[] d) {
        int length = a.length + b.length + c.length + d.length;
        double[] result = new double[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, 2 * b.length, c.length);
        System.arraycopy(d, 0, result, 3 * c.length, d.length);
        return result;
    }

    public double[] getResultadoFinal() {
        while (!isPronto) {
            System.err.println("no ta pronto");
        }
        return resultadoFinal;
    }

}
