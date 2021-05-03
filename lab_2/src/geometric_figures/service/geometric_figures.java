package geometric_figures.service;

import java.awt.Graphics;
import java.util.*;

public abstract class geometric_figures {

    public geometric_figures() {
    }

    public float getArea() {
        // TODO implement here
        return 0.0f;
    }

    public float getPerimeter() {
        // TODO implement here
        return 0.0f;
    }

    public abstract void getdrawFigure(Graphics g) ;
    public abstract void getimage(String formato) ;
}