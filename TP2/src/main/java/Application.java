import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        try {
            Game gj = new Game();
            gj.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
