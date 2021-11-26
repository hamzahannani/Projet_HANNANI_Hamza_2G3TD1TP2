import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements ActionListener {
    Drawing Drawing = new Drawing();

    public Window(String Title, int x, int y) {
        super(Title);
        this.setSize(x, y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = this.getContentPane();


        this.setBackground(Color.white);
        Drawing.repaint();
        contentPanel.add(Drawing,"Center");

        JPanel Touches = new JPanel();
        JMenuBar m = new JMenuBar();

        JMenu menu1 = new JMenu("File");
        menu1.addActionListener(this);
        JMenuItem open = new JMenuItem("Open");
        open.addActionListener(this);
        menu1.add(open);
        JMenuItem New = new JMenuItem("New");
        menu1.add(New);
        New.addActionListener(this);
        JMenuItem Save = new JMenuItem("Save");
        menu1.add(Save);
        Save.addActionListener(this);
        JMenuItem Quit = new JMenuItem("Quit");
        menu1.add(Quit);
        Quit.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        Quit.addActionListener(this);
        Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        JMenu menu2 = new JMenu("About");
        menu2.addActionListener(this);
        JMenuItem Author = new JMenuItem("Author");
        menu2.add(Author);
        Author.addActionListener(this);




        m.add(menu1);
        m.add(menu2);
        contentPanel.add(m, "North");
        JPanel couleurs = new JPanel();
        JButton noir = new JButton("noir");
        couleurs.add(noir);
        noir.setBackground(Color.black);
        noir.setForeground(Color.white);
        noir.addActionListener(this);

        JButton rouge = new JButton("rouge");
        couleurs.add(rouge);
        rouge.setBackground(Color.red);
        rouge.addActionListener(this);

        JButton vert = new JButton("vert");
        couleurs.add(vert);
        vert.setBackground(Color.green);
        vert.addActionListener(this);

        JButton bleu = new JButton("bleu");
        couleurs.add(bleu);
        bleu.setBackground(Color.blue);
        bleu.setForeground(Color.white);
        bleu.addActionListener(this);

        JButton jaune = new JButton("jaune");
        couleurs.add(jaune);
        jaune.setBackground(Color.yellow);
        jaune.addActionListener(this);

        JButton rose = new JButton("rose");
        couleurs.add(rose);
        rose.setBackground(Color.PINK);
        rose.addActionListener(this);

        JButton magenta = new JButton("magenta");
        couleurs.add(magenta);
        magenta.setBackground(Color.magenta);
        magenta.addActionListener(this);

        JButton orange = new JButton("orange");
        couleurs.add(orange);
        orange.setBackground(Color.ORANGE);
        orange.addActionListener(this);


        JPanel figures = new JPanel();
        JButton Ellipse = new JButton("paintPackage.Ellipse");
        figures.add(Ellipse);
        Ellipse.addActionListener(this);

        JButton Cercle = new JButton("paintPackage.Cercle");
        figures.add(Cercle);
        Cercle.addActionListener(this);

        JButton Rectangle = new JButton("paintPackage.Rectangle");
        figures.add(Rectangle);
        Rectangle.addActionListener(this);

        JButton Square = new JButton("paintPackage.Square");
        figures.add(Square);
        Square.addActionListener(this);


        Touches.add(couleurs);
        Touches.add(figures);
        couleurs.setLayout(new GridLayout(2, 4));
        figures.setLayout(new GridLayout(2, 2));
        Touches.setLayout(new GridLayout(1, 2));
        contentPanel.add(Touches, "South");


        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case"New":
                Drawing.getList().clear(); repaint();
                break;
            case"Quit":
                System.exit(0);
                break;
            case"Save":
                String Save_ad =  JOptionPane.showInputDialog(null, " Save: ");
                Drawing.save(Save_ad);
                break;
            case"Open":
                String Open_ad = JOptionPane.showInputDialog(null,"Open: ");
                Drawing.open(Open_ad);
                repaint();
                break;
            case"noir":
                Drawing.setColor(Color.black);
                break;
            case"rouge":
                Drawing.setColor(Color.red);
                break;
            case"vert":
                Drawing.setColor(Color.green);
                break;
            case"bleu":
                Drawing.setColor(Color.blue);
                break;
            case"jaune":
                Drawing.setColor(Color.yellow);
                break;
            case"rose":
                Drawing.setColor(Color.pink);
                break;
            case"magenta":
                Drawing.setColor(Color.magenta);
                break;
            case"orange":
                Drawing.setColor(Color.orange);
                break;

            case "paintPackage.Ellipse" :
                Drawing.setFigure(new Ellipse(Drawing.getColor()));
                Drawing.setNameFigure("Ellipse");
                break;
            case "paintPackage.Rectangle":
                Drawing.setFigure(new Rectangle(Drawing.getColor()));
                Drawing.setNameFigure("Rectangle");
                break;
            case "paintPackage.Square":
                Drawing.setFigure(new Square(Drawing.getColor()));
                Drawing.setNameFigure("Square");
                break;
            case "paintPackage.Cercle":
                Drawing.setFigure( new Cercle (Drawing.getColor()));
                Drawing.setNameFigure("Cercle");
                break;
            case "Author":
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog( info, "Authors : HANNANI Hamza",
                        "information",JOptionPane.INFORMATION_MESSAGE);
                break;



        }
    }
}

