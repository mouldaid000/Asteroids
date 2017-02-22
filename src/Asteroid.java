import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */

public class Asteroid extends Entity {
    int hitTimer;
    private boolean original = true;
    public Asteroid(Color color, int x, int y, int width, int height, Game game, boolean original, int index){
        super(color,x,y,width,height,game, index);
        this.original = original;
        hitTimer = 10;
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
        hitTimer--;
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

    public void split() {
        if(hitTimer <= 0){
        for (int i = 0; i < 2; i++) {
            getGame().addEntity(new Asteroid(Color.WHITE, getX(), getY(), (int) (getWidth() / 1.5), (int)(getHeight() / 1.5), getGame(), false, getGame().getNextIndex()));
        }

        getGame().removeEntity(getIndex());
    }
    }

    public void kill(){
        split();
    }
}
