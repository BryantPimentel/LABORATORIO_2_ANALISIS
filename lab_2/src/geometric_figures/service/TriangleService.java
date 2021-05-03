package geometric_figures.service;

import geometric_figures.model.RectangleEntity;
import geometric_figures.model.TriangleEntity;
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

public class TriangleService extends geometric_figures {
     TriangleEntity triangle = new TriangleEntity();
    Color ColorFigura = null;
    Color ColorBorde = null;

    public TriangleService() {
    }
    
    
     public void CrearTriangle(int base,int altura,String colorarea,String colorborde) {   
          triangle.setAltura(altura);
          triangle.setBase(base);
          triangle.setColorarea(colorarea);
          triangle.setColorborde(colorborde);
          switch(triangle.getColoarea()){
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
         switch(triangle.getColorborde()){
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
          return (float) (triangle.getBase()*triangle.getAltura());  
    }

     @Override 
       public float getPerimeter() {
        // TODO implement here
          return (float) ((triangle.getAltura()*2)+(triangle.getBase()*1));
    }
       
       
       
       
    @Override
    public void getdrawFigure(Graphics g) {
         g.setColor(ColorBorde);
        int xpoints[] = {(int)(200-(triangle.getBase()/2)), (int)(200), (int)(200+(triangle.getBase()/2))};
        int ypoints[] = {(int)(200+(triangle.getAltura()/2)), (int)(200-triangle.getAltura()), (int)(200+(triangle.getAltura()/2))};
        int npoints = 3;
        g.drawPolygon(xpoints, ypoints, npoints);
        g.setColor(ColorFigura);
   
        g.fillPolygon(xpoints, ypoints, npoints); 
    }

    @Override
    public void getimage(String formato) {
          BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);
           Graphics2D g3d = bufferedImage.createGraphics();
           g3d.setColor(ColorFigura);
           g3d.fillRect((int)(200-(triangle.getAltura()/2)), (int)(200-(triangle.getBase())), triangle.getAltura(), triangle.getBase());
           g3d.setColor(ColorBorde);
           g3d.drawRect((int)(200-(triangle.getAltura()/2)), (int)(200-(triangle.getBase())), triangle.getAltura(), triangle.getBase());
           g3d.dispose();
   File file = new File("triangle."+formato);
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