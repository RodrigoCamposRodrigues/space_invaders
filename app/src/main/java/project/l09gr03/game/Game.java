package project.l09gr03.game;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;

import project.l09gr03.states.State;
import project.l09gr03.gui.LanternaGUI;
import project.l09gr03.states.MenuState;
import project.l09gr03.model.menu.MainMenu;

public class Game
{
    private final LanternaGUI gui;
    private State state;
    private static int highScore;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new MainMenu());
        highScore = 0;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void start() throws IOException {
        int FPS = 60;
        int frameTime = 1000 / FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }

    public static void setHighScore(int score)
    {
        if(highScore < score)
        {
            highScore = score;
        }
    }

    public static int getHighScore()
    {
        return highScore;
    }

}
