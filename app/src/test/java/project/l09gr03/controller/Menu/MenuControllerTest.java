package project.l09gr03.controller.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import project.l09gr03.controller.menu.MenuController;
import project.l09gr03.game.Game;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.gui.GUI;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class MenuControllerTest {

    private MainMenu menu;
    private Game game;
    private MenuController menuController;

    @BeforeEach
    void TestSetup() throws IOException {
        menu=new MainMenu();
        menuController= new MenuController(menu);
        game = Mockito.mock(Game.class);
        game.start();
    }

    @Test
    void TestUpCase() throws IOException {
        menuController.step(game, GUI.ACTION.UP,501);
        assertEquals(Boolean.TRUE, menu.isSelectedExit());
    }
    @Test
    void TestDownCase() throws IOException {
        menuController.step(game, GUI.ACTION.DOWN,501);
        assertEquals(Boolean.TRUE, menu.isSelectedHighScore());
    }
}
