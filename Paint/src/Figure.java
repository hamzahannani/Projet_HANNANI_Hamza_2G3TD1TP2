import java.awt.*;
import java.io.Serializable;

abstract public class Figure implements Serializable {

    public Color color;
    public Point origin;
    public Figure(Point P, Color C) {
        this.origin = P;
        this.color = C;
    }

    @Override
    public String toString(){
        return "Rectangle :  ("+origin.getX()+","+origin.getY()+")";
    }

    public abstract double getPerimeter();
    public abstract double getSurface();
    public void setColor(Color color){this.color=color;}
    public void setorigin(Point P){this.origin=P;}
    public abstract void setBoundingBox(int heightBB, int widthBB);
    public abstract void draw(Graphics g);
}

