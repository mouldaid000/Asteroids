import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Bullet extends Entity {
    public Bullet(Color color, int x, int y, int width, int height, double dy, double dx, Game game){
        super(color, x, y, width, height, game);
        setDx(dx);
        setDy(dy);
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
    }
}
