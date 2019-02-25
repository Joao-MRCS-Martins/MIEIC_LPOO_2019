import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.List;

public class Arena {

    private int width;
    private int height;
    Hero hero = new Hero(10,10);
    private List<Wall> walls;

    public Arena (int w, int h) {
        width = w;
        height = h;
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        hero.draw(graphics);
    }

    public void processKey(com.googlecode.lanterna.input.KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
        }
    }


    private void moveHero(Position position) {
       if(canHeroMove(position))
        hero.setPosition(position);
    }

    private boolean canHeroMove(Position position) {
        return position.getX() >0 && position.getX() < this.width && position.getY() > 0 && position.getY() < this.height;
    }
}
