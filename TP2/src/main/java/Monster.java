import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Monster extends Element {

    public Monster(int x, int y) {
        super(x, y);
    }

    public Position move(int width, int height) {
        Random rand = new Random();
        Position newPos = pos;

        boolean valid = false;
        while (!valid) {
            int move = rand.nextInt(4);
            switch (move) {
                case 0:
                    newPos = new Position(pos.getX() - 1, pos.getY());
                    break;
                case 1:
                    newPos = new Position(pos.getX() + 1, pos.getY());
                    break;
                case 2:
                    newPos = new Position(pos.getX(), pos.getY() - 1);
                    break;
                case 3:
                    newPos = new Position(pos.getX(), pos.getY() + 1);
                    break;
            }
            if (newPos.getX() > 1 && newPos.getX() < width - 1 && newPos.getY() > 1 && newPos.getY() < height - 1)
                valid = true;
        }
        return newPos;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#ba0007"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(pos.getX(), pos.getY()), "O");
    }
}
