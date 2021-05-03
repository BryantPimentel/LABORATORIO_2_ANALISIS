package geometric_figures.service;

import geometric_figures.model.CircleEntity;
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

public class CircleService extends geometric_figures {
    CircleEntity circle = new CircleEntity(); 
    Color ColorFigura = null;
    Color ColorBorde = null;
    public CircleService() {

    }
     public void CrearCircle(int radio,String colorarea,String colorborde) {   
         circle.setRadio(radio);
         circle.setColorarea(colorarea);
         circle.setColorborde(colorborde);
          switch(circle.getColoarea()){
            case "Negro":
                 ColorFigura = Color.BLACK;
            break;
            case "Rojo":
                ColorFigura = Color.RED;
            break;  
        }
         switch(circle.getColorborde()){
            case "Negro":
                 ColorBorde = Color.BLACK;
            break;
            case "Rojo":
                ColorBorde = Color.RED;
            break;  
        }
    }
    @Override 
    public float getArea() {
        // TODO implement here
          return (float) (Math.PI*Math.pow(circle.getRadio(), 2)); 
    }
     @Override 
    public float getPerimeter() {
        // TODO implement here
        return (float) (2*Math.PI*circle.getRadio());
    }
    @Override
    public void getdrawFigure(Graphics g) {
         Graphics2D g2d =(Graphics2D) g; 
        g2d.setColor(ColorFigura); 
        g2d.fillOval((int)(200-(circle.getRadio()/2)),(int)(200-(circle.getRadio()/2)), circle.getRadio(), circle.getRadio());
        g2d.setColor(ColorBorde);
        g2d.drawOval((int)(200-(circle.getRadio()/2)),(int)(200-(circle.getRadio()/2)), circle.getRadio(), circle.getRadio());
       
    }

    @Override
    public void getimage(String formato) {
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
        Graphics2D g3d = bufferedImage.createGraphics();
        g3d.setColor(ColorFigura);
        g3d.fillOval((int)(200-(circle.getRadio()/2)),(int)(200-(circle.getRadio()/2)),circle.getRadio(), circle.getRadio());
        g3d.setColor(ColorBorde);
        g3d.drawOval((int)(200-(circle.getRadio()/2)),(int)(200-(circle.getRadio()/2)), circle.getRadio(), circle.getRadio());
        g3d.dispose(); 
         File file = new File("circle."+formato);
        switch(formato){
            case "PNG":
                try {
                    ImageIO.write(bufferedImage, "png", file);
                } catch (IOException ex) {
                    Logger.getLogger(CircleService.class.getName()).log(Level.SEVERE, null, ex);
                }
            break;
            case "JPG":    
            try {
                ImageIO.write(bufferedImage, "jpg", file);
            } catch (IOException ex) {
                Logger.getLogger(CircleService.class.getName()).log(Level.SEVERE, null, ex);
            }  
            break;  
        }
       
       
    }

}