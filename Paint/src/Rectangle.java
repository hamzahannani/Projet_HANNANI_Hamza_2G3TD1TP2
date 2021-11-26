import java.awt.*;

public class Rectangle extends Figure {
    int px;
    int py;
    int height;
    int width;

    public Rectangle (Color C){super(new Point(0,0),C);}

    public Rectangle (int a, int b){
        super(new Point(0,0),Color.black);
        this.height=a;
        this.width=b;
    }

    public Rectangle(int px, int py, Color C){
        super(new Point(px,py),C);
        this.height=0;
        this.width=0;
    }
    public void draw(Graphics g){
        g.setColor(color);
        g.fillRect(origin.getX(),origin.getY(),height,width);
    }

    @Override
    public String toString(){
        return "Rectangle d'origine : " + origin + "de taille :"+height+" et de largeur "+width;
    }

    public void setBoundingBox(int heightBB, int widthBB){
        this.height=heightBB;
        this.width=widthBB;
    }
    public double getPerimeter(){return 2*height+2*width;}
    public double getSurface(){return height*width;}
    public int getHeight(){return height;}
    public int getWidth(){return width;}

    public void setHeight(int height){
        this.height=height;
    }
    public void setWidth(int width){this.width=width;}
}
