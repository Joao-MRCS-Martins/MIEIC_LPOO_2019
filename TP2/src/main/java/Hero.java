import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Hero extends Element {
    public Hero(int x, int y) {
        super(x, y);
    }

    public int getY() {
        return pos.getY();
    }

    public int getX() {
        return pos.getX();
    }

    public Position getPos() {
        return pos;
    }

    public void setPosition(Position pos) {
        this.pos = pos;
    }

    public Position moveUp() {
        return pos.moveUp();
    }

    public Position moveDown() {
        return pos.moveDown();
    }

    public Position moveLeft() {

        return pos.moveLeft();
    }

    public Position moveRight() {
        return pos.moveRight();
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#1b8f08"));
        graphics.enableModifiers(SGR.BOLD);
        super.draw(graphics);
        //graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
        /*graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2), "\\/");
        graphics.putString(new TerminalPosition(position.getX() * 2, position.getY() * 2+1), "/\\");
        */
    }
}

