import java.awt.*;
import static java.lang.Math.min;
public class Square extends Rectangle {

    public Square(Color C){super(C);}

    public Square(int px, int py, Color C) {
        super(px, py, C);
    }

    public void setLength(int length) {
        this.height = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        int l = min(heightBB,widthBB);
        this.height = l;
        this.width = l;
    }
}
