import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    private Position position;

    public Hero(int x, int y) {
        position = new Position(x, y);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public void setPosition(Position pos) {
        position = pos;
    }

    public Position moveUp() {
        return new Position(position.getX(),position.getY()-1);
    }

    public Position moveDown() {
        return new Position(position.getX(),position.getY()+1);
    }

    public Position moveLeft() {
        return new Position(position.getX()-1,position.getY());
    }

    public Position moveRight() {
        return new Position(position.getX()+1,position.getY());
    }
    public void draw(Screen screen) {
        screen.setCharacter(this.getX(),this.getY(), new TextCharacter('X'));
    }
}
