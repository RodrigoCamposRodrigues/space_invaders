package project.l09gr03.controller.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.l09gr03.controller.menu.MenuHighScoreController;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.menu.MenuHighScore;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuHighScoreControllerTest {
    private MenuHighScore menuhighscore;
    private Game game;
    private MenuHighScoreController menuhighscorecontroller;

    @BeforeEach
    void TestSetup() throws IOException {
        menuhighscore=new MenuHighScore();
        menuhighscorecontroller= new MenuHighScoreController(menuhighscore);
        game = Mockito.mock(Game.class);
        game.start();
    }

    @Test
    void TestUpCase() throws IOException {
        menuhighscorecontroller.step(game, GUI.ACTION.UP,501);
        assertEquals(Boolean.TRUE, menuhighscore.isSelectedExit());
    }
    @Test
    void TestDownCase() throws IOException {
        menuhighscorecontroller.step(game, GUI.ACTION.DOWN,501);
        assertEquals(Boolean.TRUE, menuhighscore.isSelectedExit());
    }
}
