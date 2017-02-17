import java.awt.*;
/**
 * Created by mouldaid000 on 2/10/2017.
 */
public abstract class Entity {
    
    //This comment was made via internets by Ethan Thompson.
    
    private Game game;
    private Color color;
    private int x, y, width, height;

    private double dx, dy, maxSpeed;

    public abstract void move();

    public Entity(Color color, int x, int y, int width, int height, Game game){
        this.game = game;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxSpeed = 20;


    }
    public boolean collides(Entity other){
        return getBounds().intersects(other.getBounds());
    }
    public abstract void paint(Graphics g);

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getCenterX(){
        return x - (width / 2);
    }

    public int getCenterY(){
        return y - (height / 2);
    }

    public void wallCollision(){
        double nextLeft = x + dx;
        double nextRight = x + width + dx;
        double nextTop = y + dy;
        double nextBottom = y + height + dy;

        if(nextTop <=0){
            y = game.getHeight() - height;
        }

        if(nextBottom > game.getHeight()){
            y = 0;
        }

        if(nextLeft <= 0){
            x = game.getWidth() - width;
        }

        if(nextRight > game.getWidth()){
            x = 0;
        }
    }



    public void setX(double x) {
        this.x = (int)Math.round(x);
    }

    public int getY() {
        return y;
    }

    public void setY(double y) {
        this.y = (int)Math.round(y);
    }

    public int getWidth() {
        return width;
    }



    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight(){
        return height;
    }
    public void setHeight(){
        this.height = height;
    }

    public double getDx() {
        return dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public double getSpeed(){
       return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    public double getMaxSpeed(){
        return maxSpeed;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }

}
