import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Element {

    protected Position pos;

    public Element(int x, int y) {
        pos = new Position(x, y);
    }

    public int getX() {
        return pos.getX();
    }

    public int getY() {
        return pos.getY();
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void draw(TextGraphics graphics) {
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "X");
    }

    public boolean equals(Position pos) {
        return this.getX() == pos.getX() && this.getY() == pos.getY();
    }


}
