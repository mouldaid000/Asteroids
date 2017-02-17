/**
 * Created by mouldaid000 on 2/10/2017.
 */
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener{
    Timer timer;
    int cursorX, cursorY;
    boolean wPressed, aPressed, sPressed, dPressed, leftClick, spacePressed; //Depressing, isn't it? Happy vALONEtine's day
    ArrayList<Entity> entities;

    public Game(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("ASTEROIDS");
        setPreferredSize(new Dimension(1024,768));
        setBackground(Color.black);
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);



        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //for the memes
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    wPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    sPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    aPressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    dPressed = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_W){
                    wPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_S){
                    sPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_A){
                    aPressed = false;
                }
                if(e.getKeyCode() == KeyEvent.VK_D){
                    dPressed = false;
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMoved(MouseEvent e){
                super.mouseMoved(e);
                cursorX = e.getX();
                cursorY = e.getY();
            }
        });

        addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(e.getButton() == MouseEvent.BUTTON1){
                    leftClick = true;
                    System.out.println("Mouse clicked");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(e.getButton() == MouseEvent.BUTTON1){
                    leftClick = false;
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }
    public static void main(String[] args){
        Game game = new Game();
        game.init();
        game.run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        collisions();
        entities.get(0).move();
        for(int i = 1; i < entities.size(); i++){
            entities.get(i).move();
        }
        repaint();
    }
    public void init(){
        entities = new ArrayList<Entity>();
        entities.add(new Ship(Color.red, getWidth()/2, getHeight()/2, 30, 30, this));

        for(int i = 0; i < 10; i++){
            entities.add(new Asteroid(Color.green, (int)(25+(getWidth()-100)*Math.random()), (int)(25 + (getHeight() - 50)*Math.random()), 30, 30, this));
        }
    }
    public void collisions(){
        for(int i = 1; i < entities.size(); i++){
            if(entities.get(0).collides(entities.get(i))){
                if(entities.get(i) instanceof Asteroid){
                    entities.remove(i);
                    JOptionPane.showMessageDialog(null, "You dead cuz");
                }
            }
        }
    }
    public void run(){
        timer = new Timer(1000/60, this);
        timer.start();
    }
    public void paint(Graphics g){
        super.paint(g);
        for(Entity obj : entities){
            obj.paint(g);
        }
    }

    public void addBullet(double dy, double dx){
        entities.add(new Bullet(Color.yellow, entities.get(0).getX() + (entities.get(0).getWidth()) / 2, entities.get(0).getY() + (entities.get(0).getHeight()) / 2, 10, 10, dy, dx, this));
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public boolean iswPressed() {
        return wPressed;
    }

    public boolean isaPressed() {
        return aPressed;
    }

    public boolean issPressed() {
        return sPressed;
    }

    public boolean isdPressed() {
        return dPressed;
    }

    public boolean isLeftClick() {
        return leftClick;
    }

    public boolean isSpacePressed() {
        return spacePressed;
    }
}
