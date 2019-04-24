
import filters.Filtros;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    //metodo principal onde as questoes sao respondidas
    public static void main(String[] args) throws FileNotFoundException, IOException {


        //new Questoes().questao2(100);

        /*
        
        double[][] imgTeste = new double[8][8];

        imgTeste[0][0] = 10;        imgTeste[0][1] = 5;        imgTeste[0][2] = 2;        imgTeste[0][3] = 8.5;    imgTeste[0][4] = 1;        imgTeste[0][5] = 1.5;        imgTeste[0][6] = 0;    imgTeste[0][7] = 0.1;
        imgTeste[1][0] = 10;        imgTeste[1][1] = 5;        imgTeste[1][2] = 2;        imgTeste[1][3] = 8.5;    imgTeste[1][4] = 1;        imgTeste[1][5] = 1.5;        imgTeste[1][6] = 0;    imgTeste[1][7] = 0.1;
        imgTeste[2][0] = 10;        imgTeste[2][1] = 5;        imgTeste[2][2] = 2;        imgTeste[2][3] = 8.5;    imgTeste[2][4] = 1;        imgTeste[2][5] = 1.5;        imgTeste[2][6] = 0;    imgTeste[2][7] = 0.1;
        imgTeste[3][0] = 10;        imgTeste[3][1] = 5;        imgTeste[3][2] = 2;        imgTeste[3][3] = 8.5;    imgTeste[3][4] = 1;        imgTeste[3][5] = 1.5;        imgTeste[3][6] = 0;    imgTeste[3][7] = 0.1;
        
        imgTeste = filtro.FrequenciaImg(imgTeste);
        imgTeste = filtro.espacoImg(imgTeste);
        
        exibeMatriz(imgTeste);
        
        double[][] img2 = new double[8][8];

        img2[0][0] = 0;        img2[0][1] = 0;        img2[0][2] = 0;        img2[0][3] = 0;    img2[0][4] = 0;        img2[0][5] = 0;        img2[0][6] = 0;        img2[0][7] = 0;
        img2[1][0] = 0;        img2[1][1] = 1;        img2[1][2] = 0;        img2[1][3] = 1;    img2[1][4] = 0;        img2[1][5] = 1;        img2[1][6] = 0;        img2[1][7] = 1;
        img2[2][0] = 1;        img2[2][1] = 0;        img2[2][2] = 1;        img2[2][3] = 0;    img2[2][4] = 1;        img2[2][5] = 0;        img2[2][6] = 1;        img2[2][7] = 0;
        img2[3][0] = 0;        img2[3][1] = 1;        img2[3][2] = 0;        img2[3][3] = 1;    img2[3][4] = 0;        img2[3][5] = 1;        img2[3][6] = 0;        img2[3][7] = 1;

        
        System.out.println("\n\n**Original**\n\n");
        //exibeMatriz(img);
        
        System.out.println("\n\n**Indo para D(freq)**\n\n");
        img = filtro.FrequenciaImg(img);
        //exibeMatriz(img);
        
        System.out.println("\n\n**Indo para D(esp)**\n\n");
        img = filtro.espacoImg(img);
        //exibeMatriz(img);
         */
 /*
        img2[0] = new RunIDCT(img[0]).getResultadoFinal();
        exibeMatriz(img2);
        
        img2[0] = new RunDCT(img2[0]).getResultadoFinal();
        exibeMatriz(img2);
         */
 

        
        Scanner scan = new Scanner(System.in);
        
        
        
        while(true){
            System.out.print("Qual questão? ");
            int questao = Integer.valueOf(scan.next());

            //TRATAMENTO DAS QUESTOES
            switch (questao) {
                //questao 1
                case 1:
                    System.out.print("Valor de n para corte dos cossenos: ");
                    int n = Integer.valueOf(scan.next());
                    new Questoes().questao1(n);
                    break;
                //questao 2
                case 2:
                    System.out.print("Valor de n para corte dos cossenos: ");
                    int n2 = Integer.valueOf(scan.next());
                    new Questoes().questao2(n2);
                    break;
                //questao 3
                case 3:
                    System.out.print("Valor de c para deslocamento: ");
                    int c = Integer.valueOf(scan.next());
                    new Questoes().questao3(c);
                    break;
            }

        }
    }

    public static void exibe(double[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.err.print(vetor[i] + "\t");
        }
    }

    public static void exibeMatriz(double vetor[][]) {
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[0].length; j++) {
                System.out.print(vetor[i][j] + "\t");
            }
            System.out.println("");
        }
    }
}
