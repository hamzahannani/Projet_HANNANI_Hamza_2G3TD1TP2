import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Point implements Serializable {
    private int X;
    private int Y;
    public Point(int A,int B){
        this.X= A;
        this.Y= B;
    }
    public Point(){
        this.X= 0;
        this.Y= 0;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    public void setX(int A){
        this.X= A;
    }
    public void setY(int B){
        this.Y=B;
    }
    @Override
    public String toString(){
        return"("+X+","+Y+")";
    }

}
