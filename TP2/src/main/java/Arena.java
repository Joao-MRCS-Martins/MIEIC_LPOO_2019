import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {

    private int width;
    private int height;

    public Arena (int w, int h) {
        width = w;
        height = h;
    }
    Hero hero = new Hero(10,10);

    public void draw(Screen screen) throws IOException {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
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
