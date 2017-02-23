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
    boolean wPressed, aPressed, sPressed, dPressed, leftClick, spacePressed, menu, play, pause;//Depressing, isn't it? Happy vALONEtine's day

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
        play = true;
        menu = false;
        pause = false;



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
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    spacePressed = true;
                }
                if(e.getKeyCode() == KeyEvent.VK_P){
                    pause = true;
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
        entities.add(new Ship(Color.red, getWidth()/2, getHeight()/2, 30, 30, this, 0) );

        for(int i = 0; i < 10; i++){
            entities.add(new Asteroid(Color.WHITE, (int)(25+(getWidth()-100)*Math.random()), (int)(25 + (getHeight() - 50)*Math.random()), 30, 30, this, true, entities.size()));
        }
    }
    public void collisions(){
        for(int i = 0; i < entities.size(); i++) {

            entities.get(i).checkCollisions();



        }
    }
    public void run(){
        timer = new Timer(1000/60, this);
        timer.start();
    }

    public Rectangle getHitbox(int index){
    return entities.get(index).getBounds();
    }

    public void paint(Graphics g){

        super.paint(g);
        if(menu){
            printSimpleString("ASTEROIDS",getWidth(),0,200,g);
        }
        if(play){
            for(Entity obj : entities){
                obj.paint(g);
            }
        }
        if(pause){
            printSimpleString("PAUSED",getWidth(), 0,200,g);
        }

    }

    public void addEntity(Entity ent){
        entities.add(ent);
    }

    public Entity getEntity(int index){
        return entities.get(index);
    }

    public void removeEntity(int index){
        entities.remove(index);
        for(int i = index; i < entities.size(); i++){
            entities.get(i).decrementIndex();

        }
    }

    public int getNextIndex(){
        return entities.size();
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
    public boolean isMenu(){
        return menu;
    }
    public boolean isPlay(){
        return play;
    }
    public boolean isPause(){
        return pause;
    }
    private void printSimpleString(String s, int width, int XPos, int YPos, Graphics g2d){
        int stringLen = (int)g2d.getFontMetrics().getStringBounds(s, g2d).getWidth();
        int start = width/2 - stringLen/2;
        g2d.drawString(s, start + XPos, YPos);
    }
}
