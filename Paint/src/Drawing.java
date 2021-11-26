import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.*;

public class Drawing extends JPanel implements MouseListener,MouseMotionListener, Serializable {

    Color color;
    Figure figure;
    ArrayList<Figure> list;
    String NameFigure;
    int X;
    int Y;


    public Drawing(){
        super();
        color=Color.black;
        NameFigure="Rectangle";
        figure =new Rectangle(0,0);
        list = new ArrayList<Figure>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    public void setNameFigure(String NameFigure){this.NameFigure=NameFigure;}
    public void setColor(Color color) {
        this.color = color;
    }
    public void setFigure(Figure figure) {
        this.figure=figure;
    }

    public Figure getFigure(){return this.figure;}
    public Color getColor(){return this.color;}
    public String getNameFigure(){return this.NameFigure;}
    public ArrayList<Figure> getList(){return list;}

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.white);
        for (Figure f: list){f.draw(g);}
    }

    public void mouseDragged(MouseEvent e){
        int dX=Math.abs(e.getX()-X);
        int dY=Math.abs(e.getY()-Y);
        figure.setBoundingBox(dX, dY);
        repaint();
        if(NameFigure=="Cercle" | NameFigure=="Square"){
            if (e.getX() < X){
                figure.setorigin(new Point(Math.max(X-dY,e.getX()),Y));
            }
            if (e.getY() < Y){
                figure.setorigin(new Point(X,Math.max(Y-dX,e.getY())));
            }
            if (e.getX() < X && e.getY() < Y){
                figure.setorigin(new Point(Math.max(X-dY,e.getX()),Math.max(Y-dX,e.getY())));
            }
        }
        else{
            if (e.getX() < X){
                figure.setorigin(new Point(e.getX(),Y));
            }
            if (e.getY() < Y){
                figure.setorigin(new Point(X,e.getY()));
            }
            if (e.getX() < X && e.getY() < Y){
                figure.setorigin(new Point(e.getX(),e.getY()));
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        X=e.getX();
        Y=e.getY();
        figure.setColor(color);
        figure.setorigin(new Point(X,Y));
        list.add(getFigure());
        System.out.println(getFigure());
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {

    }
    public void mouseMoved(MouseEvent e){


    }
    public void save(String fileName){
        try{
            FileOutputStream fos = new FileOutputStream(FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

            oos.close();
        }
        catch (Exception e){
            System.out.println("Oooops Problem !");
        }
    }

    public void open(String fileName){
        try{
            FileInputStream fis = new FileInputStream(FileSystemView.getFileSystemView().getHomeDirectory()+"\\"+fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            list = (ArrayList<Figure>) ois.readObject();

            ois.close();
        }
        catch (Exception e){
            System.out.println("Ooops Problem");
        }
    }
}
