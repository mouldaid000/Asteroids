import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */

public class Asteroid extends Entity {
    private boolean original = true;
    public Asteroid(Color color, int x, int y, int width, int height, Game game, int index){
        super(color,x,y,width,height,game, index);
        setRandomVelocity();
    }
    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }

    public void move(){
        wallCollision();

        setX(getX() + getDx());
        setY(getY() + getDy());
    }

    public void setRandomVelocity(){
        double speed = (Math.random() * 3) + 1;
        double angle = Math.random() * (2 * Math.PI);

        if(!original){
            speed *= 2;
        }

        setDy(speed * Math.sin(angle));
        setDx(speed * Math.cos(angle));


    }

    public void split(){

    }
}
