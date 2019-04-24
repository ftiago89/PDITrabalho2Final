
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

//classe para plotar um grafico utilizando a library JFreeChart
public class Grafico {
    
    public void plotar(double[] vetor, String nomeArquivo, String titulo, String x){
        OutputStream arquivo = null;
        try {
            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            
            for (int i=0; i<vetor.length; ++i){
                ds.addValue(vetor[i], "", String.valueOf(i));
            }
            
            JFreeChart grafico = ChartFactory.createLineChart(titulo, x, "", ds, PlotOrientation.VERTICAL, true, true, false);
            arquivo = new FileOutputStream("graficos/"+ nomeArquivo);
            ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            arquivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                arquivo.close();
            } catch (IOException ex) {
                Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
