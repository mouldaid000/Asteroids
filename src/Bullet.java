import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Bullet extends Entity {
    private int bulletTimer;
    public Bullet(Color color, int x, int y, int width, int height, double dy, double dx, Game game, int index){
        super(color, x, y, width, height, game, index);
        setDx(dx);
        setDy(dy);
        bulletTimer = 420;

    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public void move(){
        wallCollision();

        setX(getX() + getDx());
        setY(getY() + getDy());
        bulletTimer--;
        if(bulletTimer <= 0){
            getGame().removeEntity(getIndex());
        }
    }

    public void kill(){
getGame().removeEntity(getIndex());
    }

    public void checkCollisions(){
        for(int i = 1; i < getGame().getNextIndex(); i++){
            if(getGame().getHitbox(i).intersects(getBounds())){
                if(getGame().getEntity(i) instanceof Asteroid){
                    getGame().getEntity(i).kill();
                }
            }
        }
    }
}
