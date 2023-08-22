package entities;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CapturaDeTela {

    public static void capturarTelaComCamadaPreta() throws AWTException, IOException {

        BufferedImage captura = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

      
        BufferedImage imagemComCamada = new BufferedImage(captura.getWidth(), captura.getHeight(), BufferedImage.TYPE_INT_ARGB);
        
     
        Graphics2D g2d = imagemComCamada.createGraphics();
        g2d.drawImage(captura, 0, 0, null);
        g2d.dispose();

   
        g2d = imagemComCamada.createGraphics();
    
        g2d.setColor(Color.BLACK);
        
        g2d.fillRect(0, 0, imagemComCamada.getWidth(), imagemComCamada.getHeight());
        g2d.dispose();
       
        ImageIO.write(imagemComCamada, "png", new File("captura.png"));
       
    }

}