import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Asteroid extends Entity {
    public Asteroid(Color color, int x, int y, int width, int height, Game game){
        super(color,x,y,width,height,game);
    }
    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
