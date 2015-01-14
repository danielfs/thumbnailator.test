package io.github.danielfs.thumbnailatortest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import net.coobird.thumbnailator.Thumbnails;

public class Exemplo1 {

    public static void main(String[] args) {
        String endereco =
           "http://onsitepcsolution.com/wp-content/uploads/2014/08/java_tech.jpg";
        
        tamanhoFixo(endereco);
        
        System.out.println("Finalizado.");
    }

    public static void tamanhoFixo(String endereco) {
        try {
            URL url = new URL(endereco);
            BufferedImage imagemOriginal = ImageIO.read(url);

            BufferedImage miniatura = Thumbnails.of(imagemOriginal)
                    .size(500, 500)
                    .keepAspectRatio(true)
                    .asBufferedImage();
            
            escreverArquivo(imagemOriginal, "/tmp/original.jpg");
            escreverArquivo(miniatura, "/tmp/miniatura.jpg");
            
        } catch (IOException ex) {
            Logger.getLogger(Exemplo1.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public static void escreverArquivo(BufferedImage image, String path) {
        try {
            File file = new File(path);
            ImageIO.write(image, "jpg", file);
        } catch (IOException ex) {
            Logger.getLogger(Exemplo1.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }
}
