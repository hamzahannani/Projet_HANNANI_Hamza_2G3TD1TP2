import java.awt.*;
import java.lang.Math;
import static java.lang.Math.sqrt;

public class Ellipse extends Figure {

    int SemiAxysX;
    int SemiAxysY;
    public Ellipse (Color C){super(new Point(0,0),C);}

    public Ellipse (int a, int b) {super(new Point(a,b),Color.black);}

    public Ellipse (int px, int py, Color c) {
        super(new Point(px,py), c);
    }

    public void setBoundingBox(int heightBB, int widthBB){
        this.SemiAxysX=heightBB;
        this.SemiAxysY=widthBB;
    }

    public double getPerimeter(){return 2*Math.PI*sqrt((SemiAxysX*SemiAxysX + SemiAxysY*SemiAxysY)/2);}
    public double getSurface(){return Math.PI*SemiAxysY*SemiAxysX/4;}
    public int getSemiAxysX(){return this.SemiAxysX;}
    public int getSemiAxysY(){return this.SemiAxysY;}

    public void draw(Graphics g){
        g.setColor(this.color);
        g.fillOval(origin.getX(),origin.getY(),SemiAxysX,SemiAxysY);}
    @Override
    public String toString(){
        return "Ellipse d'origine : " + origin + "de taille :"+SemiAxysX+" et de largeur "+SemiAxysY;
    }
}
