package project.l09gr03.controller.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.l09gr03.controller.menu.MenuGameOverController;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.menu.MenuGameOver;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuGameOverControllerTest {
    private MenuGameOver menugameover;
    private Game game;
    private MenuGameOverController menugameovercontroller;

    @BeforeEach
    void TestSetup() throws IOException {
        menugameover=new MenuGameOver();
        menugameovercontroller= new MenuGameOverController(menugameover);
        game = Mockito.mock(Game.class);
        game.start();
    }

    @Test
    void TestUpCase() throws IOException {
        menugameovercontroller.step(game, GUI.ACTION.UP,501);
        assertEquals(Boolean.TRUE, menugameover.isSelectedExit());
    }
    @Test
    void TestDownCase() throws IOException {
        menugameovercontroller.step(game, GUI.ACTION.DOWN,501);
        assertEquals(Boolean.TRUE, menugameover.isSelectedExit());
    }
}
