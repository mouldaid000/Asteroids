import javax.swing.*;
import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Ship extends Entity {

int bulletCooldown = 0;

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

        if(getGame().isLeftClick()){
            bulletCooldown = 30;
            bulletCooldown--;
            Game.addBullet(calcBulletDy(), calcBulletDx());


        }

        wallCollision();

        setX(getX() + getDx());
        setY(getY() + getDy());
    }

    public double calcBulletDx(){
        return
    }

    public double calcBulletDy(){

    }

    public double calcCursorAngle(){
        return Math.atan2()
    }
}
