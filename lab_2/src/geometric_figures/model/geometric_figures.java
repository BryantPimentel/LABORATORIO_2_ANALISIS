package geometric_figures.model;

import java.util.*;

public abstract class geometric_figures {

    public geometric_figures() {
    }

    private String colorarea;

    private String colorborde;

    public String getColoarea() {
        // TODO implement here
        return this.colorarea;
    }

    public void setColorarea(String colorarea) {
        // TODO implement here
        this.colorarea=colorarea;
    }

    public String getColorborde() {
        // TODO implement here
        return this.colorborde;
    }

    public void setColorborde(String colorborde) {
        // TODO implement here
        this.colorborde=colorborde;
    }

}