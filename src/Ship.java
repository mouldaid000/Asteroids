import javax.swing.*;
import java.awt.*;

/**
 * Created by mouldaid000 on 2/10/2017.
 */
public class Ship extends Entity {

boolean bulletFired = false;
boolean visible = true;

    public Ship(Color color, int x, int y, int width, int height, Game game, int index){
        super(color, x, y, width, height, game, index);
    }
    public void paint(Graphics g){
        if(visible) {
            g.setColor(Color.red);
            g.fillOval(getX(), getY(), getWidth(), getHeight());
        }
    }

    public void move(){
     double prevDx, prevDy;
     prevDx = getDx();
     prevDy = getDy();

        if(getGame().iswPressed()){

            setDy(getDy() - .125);

        }

        if(getGame().isaPressed()){
            setDx(getDx() - .125);

        }

        if(getGame().issPressed()){
            setDy(getDy() + .125);

        }

        if(getGame().isdPressed()){
            setDx(getDx() + .125);

        }

        if(getSpeed() > getMaxSpeed()){
            setDx(prevDx);
            setDy(prevDy);
        }

        if(getGame().isLeftClick() && !bulletFired && !Stats.isInvincible()){
            bulletFired = true;

            getGame().addEntity(new Bullet(Color.yellow, getX() + (getWidth()) / 2, getY() + (getHeight()) / 2, 10, 10, calcBulletDy(), calcBulletDx(), getGame(), getGame().getNextIndex()));


        }

        if(!getGame().isLeftClick())
            bulletFired = false;

        if(Stats.isInvincible()){
            if(visible){
                visible = false;
            }
            else
                visible = true;

            Stats.decrementInvulnTimer();
        }
        else
            visible = true;

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

    public void kill(){
Stats.removeLife();
Stats.resetHealth();
setX(getGame().getWidth() / 2);
setY(getGame().getHeight() / 2);
Stats.resetInvulnTimer();

    }

    public void checkCollisions(){
    for(int i = 1; i < getGame().getNextIndex(); i++){
    if(getGame().getHitbox(i).intersects(getBounds())){
        if(getGame().getEntity(i) instanceof Asteroid && !Stats.isInvincible()){
            getGame().removeEntity(i);
            Stats.health--;

            if(Stats.getHealth() <= 0){
     kill();


            }
        }
    }
}
    }
}
