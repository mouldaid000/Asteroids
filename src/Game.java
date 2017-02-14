/**
 * Created by mouldaid000 on 2/10/2017.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends JPanel implements ActionListener{
    Timer timer;
    int positionX, positionY;
    boolean wPressed, aPressed, sPressed, dPressed, spacePressed; //Depressing, isn't it? Happy vALONEtine's day
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

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                //for the memes
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_W){
                    wPressed = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e){

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
        entities.get(0);
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
}
