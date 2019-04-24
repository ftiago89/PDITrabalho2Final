
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

//classe para processar o audio
public class AudioIO {
    private String nomeArquivo;
    
    public AudioIO(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    //le o audio e extrai as informacoes para serem trabalhadas.
    public double[][] readAudio() {
        File file = new File(this.nomeArquivo);
        AudioInputStream ais = null;
        try {
            ais = AudioSystem.getAudioInputStream(file);
            int frameLength = (int) ais.getFrameLength();
            int frameSize = (int) ais.getFormat().getFrameSize();
            byte[] eightBitByteArray = new byte[frameLength * frameSize];

            int result = ais.read(eightBitByteArray);

            int channels = ais.getFormat().getChannels();
            double[][] samples = new double[channels][frameLength];

            int sampleIndex = 0;
            for (int t = 0; t < eightBitByteArray.length;) {
                for (int channel = 0; channel < channels; channel++) {
                    int low = (int) eightBitByteArray[t];
                    t++;
                    int high = (int) eightBitByteArray[t];
                    t++;
                    int sample = getSixteenBitSample(high, low);
                    samples[channel][sampleIndex] = (double)sample;
                }
                sampleIndex++;
            }
            return samples;

        } catch (Exception exp) {

            exp.printStackTrace();

        } finally {

            try {
                ais.close();
            } catch (Exception e) {
            }
        }
        return null;
    }
    
    public void writeAudio(double[] samples){
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("src/samplesAudio/audioSaida.txt"));
            for(int i = 0; i<samples.length; ++i){
                buffWrite.write(String.valueOf(samples[i]) + "\n");
            }
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(AudioIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    protected int getSixteenBitSample(int high, int low) {
        return (high << 8) + (low & 0x00ff);
    }
}
  

