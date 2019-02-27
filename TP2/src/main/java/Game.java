import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {

    Screen screen;
    Arena arena;

    public Game() throws IOException {
        arena = new Arena(80, 24);
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();

    }
    private void draw() throws IOException {
        screen.clear();
        arena.draw( screen.newTextGraphics());
        screen.refresh();
    }

    public void run() throws IOException {
        this.draw();
        KeyStroke key;
        while(true) {
            key = screen.readInput();
            this.draw();
            int game_on = arena.processKey(key);
            if (game_on == -1) {
                this.screen.close();
                System.out.println("GAME OVER! GIT GUD.");
                break;
            }
            if(key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') {
                screen.close();
                break;
            }
        }
    }
}
