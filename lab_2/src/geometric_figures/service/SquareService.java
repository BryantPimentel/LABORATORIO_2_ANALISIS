package geometric_figures.service;

import geometric_figures.model.SquareEntity;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class SquareService extends geometric_figures {
    SquareEntity square = new SquareEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;
    public SquareService() {
    }
    
      public void CrearSquare(int lado,String colorarea,String colorborde) {   
          square.setLado(lado);
          square.setColorarea(colorarea);
          square.setColorborde(colorborde);
          switch(square.getColoarea()){
            case "Negro":
                 ColorFigura = Color.BLACK;
            break;
            case "Rojo":
                ColorFigura = Color.RED;
            break;  
            case "Anaranjado":
                ColorFigura = Color.ORANGE;
            break;  
        }
         switch(square.getColorborde()){
            case "Negro":
                 ColorBorde = Color.BLACK;
            break;
            case "Rojo":
                ColorBorde = Color.RED;
            break;  
             case "Anaranjado":
                ColorBorde = Color.ORANGE;
            break;  
        }
    }
    @Override 
    public float getArea() {
        // TODO implement here
          return (float) (square.getLado()*square.getLado());  
    }
     @Override 
    public float getPerimeter() {
        // TODO implement here
        return (float) (square.getLado()*4);
    }
    @Override
    public void getdrawFigure(Graphics g) {
            g.setColor(ColorFigura);
            g.fillRect((int)(200-(square.getLado()/2)), (int)(200-(square.getLado()/2)), square.getLado(), square.getLado());
             g.setColor(ColorBorde);
            g.drawRect((int)(200-(square.getLado()/2)), (int)(200-(square.getLado()/2)), square.getLado(), square.getLado());
    }

    @Override
    public void getimage(String formato) {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g3d = bufferedImage.createGraphics();
        g3d.setColor(ColorFigura);
        g3d.fillRect((int)(200-(square.getLado()/2)), (int)(200-(square.getLado()/2)), square.getLado(), square.getLado());
        g3d.setColor(ColorBorde);
        g3d.drawRect((int)(200-(square.getLado()/2)), (int)(200-(square.getLado()/2)), square.getLado(), square.getLado());
        g3d.dispose(); 
         File file = new File("square."+formato);
        switch(formato){
            case "PNG":
                try {
                    ImageIO.write(bufferedImage, "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(SquareService.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case "JPG":    
            try {
                ImageIO.write(bufferedImage, "jpg", file);
            } catch (IOException ex) {
                Logger.getLogger(SquareService.class.getName()).log(Level.SEVERE, null, ex);
            }  
            break;  
        }
    }

}