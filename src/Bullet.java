import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Bullet extends Entity {
    public Bullet(Color color, int x, int y, int width, int height, Game game){
        super(color, x, y, width, height, game);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }
}
