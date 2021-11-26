import java.awt.*;
import static java.lang.Math.min;
import static java.lang.Math.PI;

public class Cercle extends Ellipse {

    public Cercle(Color C){super(C);}

    public Cercle(int SemiAxysX) {
        super(SemiAxysX, SemiAxysX);
    }

    public Cercle(int px, int py, Color c) {
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB){
        int l = min(heightBB,widthBB);
        this.SemiAxysX=l;
        this.SemiAxysY=l;
    }

    public int getDiametre() {
        return SemiAxysX;
    }

    public double getPerimeter() {
        return SemiAxysX * PI;
    }

    public double getSurface() {
        return Math.pow(PI * (SemiAxysX / 2), 2);
    }

}
