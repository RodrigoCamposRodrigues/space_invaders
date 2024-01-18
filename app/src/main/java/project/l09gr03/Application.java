package project.l09gr03;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import project.l09gr03.game.Game;

public class Application {

    public static void main(String[] args) throws IOException, URISyntaxException, FontFormatException {
        System.out.println("Starting application...");
        Game game = new Game();
        game.start();
    }

}
