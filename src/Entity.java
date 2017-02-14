import java.awt.*;
/**
 * Created by mouldaid000 on 2/10/2017.
 */
public abstract class Entity {
    private Game game;
    private Color color;
    private int x, y, width, height, dy, dx;

    public void move(){
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

        x+=dx;
        y+=dx;
    }

    public Entity(Color color, int x, int y, int width, int height, Game game){
        this.game = game;
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        dx = -4;
        dy = 4;
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

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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

    public void setDx(int dx) {
        this.dx = dx;
    }

    public double getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public void playerMove(){
        setX(game.positionX);
        setY(game.positionY);
    }
}
