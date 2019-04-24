package filters;

public class Filtros {

    
    public Filtros() {

    }

    public double[][] FrequenciaImg(double[][] img) {
        
        //Aplica nas linhas
        for (int i = 0; i < img.length; i++) {
            img[i] = new RunDCT(img[i]).getResultadoFinal();
        }
         
        //encontra a transposta da imagem
        img = transposta(img);

        //Aplica nas colunas
        for (int i = 0; i < img.length; i++) {
            img[i] = new RunDCT(img[i]).getResultadoFinal();
        }
        img = transposta(img);
        
        return img;

    }

    public double[][] espacoImg(double[][] img) {
        
        //Aplica nas linhas
        for (int i = 0; i < img.length; i++) {
            img[i] = new RunIDCT(img[i]).getResultadoFinal();
        }
         
        //encontra a transposta da imagem
        img = transposta(img);
        
        //Aplica nas colunas
        for (int i = 0; i < img.length; i++) {
            img[i] = new RunIDCT(img[i]).getResultadoFinal();
        }
        
        img = transposta(img);

        return img;
    }

    public void exibeMatriz(double vetor[][]) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[0].length; j++) {
                time(100);
                System.out.print(vetor[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public double[][] transposta(double vetor[][]) {
        int linha = vetor.length;
        int coluna = vetor[0].length;
        double[][] transposta = new double[coluna][linha];

        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                transposta[j][i] = vetor[i][j];
            }
        }
        return transposta;
    }

    public void exibeMatriz(double vetor[]) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "\t");
            System.out.println("");
        }
    }

    public void time(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception err) {
        }
    }
}
