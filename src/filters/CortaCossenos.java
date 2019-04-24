package filters;


import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//clase que vai ordenar os cossenos por valor absoluto decrescentemente, preservar
//os n cossenos mais importantes e zerar os outros. Depois vai colocar os cossenos
//que sobraram em seu local original no vetor X[k]
public class CortaCossenos {

    private int n;
    private double[] X;
    private double[] saida;

    public CortaCossenos(double[] X, int n) {
        this.n = n;
        this.X = X;
        this.saida = new double[this.X.length];
        run();
    }

    //faz uma lista de elementos formados pelo indice e valor de X[k], ordena,
    //zera os cossenos menos importantes dados pelo limite n.
    private void run() {
        //povoa a lista de elementos
        List<Element> elements = new ArrayList<Element>();
        for (int i = 0; i < X.length; ++i) {
            elements.add(new Element(i, X[i]));
        }

        //ordena os elementos pelos valores
        Collections.sort(elements);

        //zera os elementos que se encontram depois de n
        for (; this.n < elements.size(); ++this.n) {
            elements.get(n).value = 0.0;
        }

        //for(Element e: elements) System.out.println(e.index);
        //povoa um array colocando os valores dos elementos que sobraram em seu
        //indice original
        for (Element e : elements) {
            saida[e.index] = e.value;
        }

        //for(int i=0;i<saida.length;++i) System.out.println(saida[i]);
    }

    //retorna o array de saida com os cossenos mais importantes e os menos importantes
    //zerados
    public double[] getSaida() {
        return saida;
    }

}

//classe que implementa comparable para fazer a comparacao entre dois elementos
//sendo cada elemento o conjunto de indice e valor do array X[k]
class Element implements Comparable<Element> {

    int index;
    double value;

    Element(int index, double value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Element e) {
        if (abs(this.value) > abs(e.value)) {
            return -1;
        } else if (abs(e.value) > abs(this.value)) {
            return 1;
        }
        return 0;
    }
}
