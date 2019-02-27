import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {

    private int width;
    private int height;
    Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;


    public Arena (int w, int h) {
        width = w;
        height = h;
        hero = new Hero(10, 10);
        walls = createWalls();
        coins = createCoins();
        monsters = createMonsters();
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width * 2, height * 2), ' ');
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
        hero.draw(graphics);

    }

    public int processKey(com.googlecode.lanterna.input.KeyStroke key) {
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
            default:
                break;
        }
        if (verifyMonsterCollisions(hero.getPos())) return -1;
        moveMonsters();
        if (verifyMonsterCollisions(hero.getPos())) return -1;
        return 0;
    }


    private void moveHero(Position position) {
        if (canHeroMove(position)) {
            retrieveCoins(position);
            hero.setPosition(position);
        }
    }

    private boolean canHeroMove(Position position) {
        return position.getX() > 0 && position.getX() < this.width - 1 && position.getY() >= 1 && position.getY() < this.height - 1;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        return coins;
    }

    private void retrieveCoins(Position pos) {
        for (Coin coin : coins) {
            if (coin.equals(pos)) {
                coins.remove(coin);
                break;
            }
        }
    }

    private List<Monster> createMonsters() {
        Random rand = new Random();
        ArrayList<Monster> mons = new ArrayList<>();

        int num = 0;
        while (num < 6) {
            Position newPos = new Position(rand.nextInt(width - 2) + 1, rand.nextInt(height - 2) + 1);

            if (!monsterInPos(newPos)) {
                mons.add(new Monster(newPos.getX(), newPos.getY()));
                num++;
            }
        }
        return mons;
    }

    private boolean monsterInPos(Position position) {
        if (monsters == null)
            return false;

        for (Monster monster : monsters)
            if (monster.equals(position))
                return true;
        return false;
    }

    private boolean verifyMonsterCollisions(Position position) {
        for (Monster monster : monsters) {
            if (monster.equals(position))
                return true;
        }
        return false;
    }

    private void moveMonsters() {
        for (Monster monster : monsters) {
            Position newPos = monster.move(width, height);
            if (canHeroMove(newPos))
                monster.setPos(newPos);
        }
    }
}
