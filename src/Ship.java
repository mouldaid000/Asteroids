import javax.swing.*;
import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Ship extends Entity {

boolean bulletFired = false;

    public Ship(Color color, int x, int y, int width, int height, Game game){
        super(color, x, y, width, height, game);
    }
    public void paint(Graphics g){
        g.setColor(getColor());
        g.fillOval(getX(),getY(), getWidth(), getHeight());
    }

    public void move(){
     double prevDx, prevDy;
     prevDx = getDx();
     prevDy = getDy();

        if(getGame().iswPressed()){

            setDy(getDy() - 0.25);

        }

        if(getGame().isaPressed()){
            setDx(getDx() - 0.25);

        }

        if(getGame().issPressed()){
            setDy(getDy() + 0.25);

        }

        if(getGame().isdPressed()){
            setDx(getDx() + 0.25);

        }

        if(getSpeed() > getMaxSpeed()){
            setDx(prevDx);
            setDy(prevDy);
        }

        if(getGame().isLeftClick() && !bulletFired){
            bulletFired = true;

            getGame().addEntity(new Bullet(Color.yellow, getX() + (getWidth()) / 2, getY() + (getHeight()) / 2, 10, 10, calcBulletDy(), calcBulletDx(), getGame()));


        }

        if(!getGame().isLeftClick())
            bulletFired = false;

        wallCollision();

        setX(getX() + getDx());
        setY(getY() + getDy());
    }

    public double calcBulletDx(){
        return 10 * Math.cos(calcCursorAngle());
    }

    public double calcBulletDy(){
        return 10 * Math.sin(calcCursorAngle());
    }

    public double calcCursorAngle(){
        return Math.atan2(getGame().getCursorY() - getY(), getGame().getCursorX() - getX());
    }
}
