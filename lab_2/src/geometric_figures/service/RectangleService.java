package geometric_figures.service;


import geometric_figures.model.RectangleEntity;

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

public class RectangleService extends geometric_figures {
 RectangleEntity rectangle = new RectangleEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;
    public RectangleService() {
        
        
    }
      public void CrearRectangle(int base,int altura,String colorarea,String colorborde) {   
          rectangle.setAltura(altura);
          rectangle.setBase(base);
          rectangle.setColorarea(colorarea);
          rectangle.setColorborde(colorborde);
          switch(rectangle.getColoarea()){
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
         switch(rectangle.getColorborde()){
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
          return (float) (rectangle.getBase()*rectangle.getAltura());  
    }
      
       @Override 
       public float getPerimeter() {
        // TODO implement here
          return (float) ((rectangle.getAltura()*2)+(rectangle.getBase()*2));
    }
      
      
      
      
      
      
      
    @Override
    public void getdrawFigure(Graphics g) {
            g.setColor(ColorFigura);
            g.fillRect((int)(200-(rectangle.getAltura()/2)), (int)(200-(rectangle.getBase()/2)), rectangle.getAltura(), rectangle.getBase());
            g.setColor(ColorBorde);
            g.drawRect((int)(200-(rectangle.getAltura()/2)), (int)(200-(rectangle.getBase()/2)), rectangle.getAltura(), rectangle.getBase());
    }
    
    
    
    

    @Override
    public void getimage(String formato) {
          BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
           Graphics2D g3d = bufferedImage.createGraphics();
           g3d.setColor(ColorFigura);
           g3d.fillRect((int)(200-(rectangle.getAltura()/2)), (int)(200-(rectangle.getBase()/2)), rectangle.getAltura(), rectangle.getBase());
           g3d.setColor(ColorBorde);
           g3d.drawRect((int)(200-(rectangle.getAltura()/2)), (int)(200-(rectangle.getBase()/2)), rectangle.getAltura(), rectangle.getBase());
           g3d.dispose();
           
      File file = new File("rectangle."+formato);
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