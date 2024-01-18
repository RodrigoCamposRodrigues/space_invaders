package project.l09gr03.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.model.menu.MenuGameOver;
import project.l09gr03.model.menu.MenuHighScore;

import java.util.List;

public class MenuTest {
    private MainMenu mainmenu;
    private MenuGameOver menugameover;
    private MenuHighScore menuhighscore;
    @BeforeEach
    void TestSetup() {
        List<String> entries;
        mainmenu= new MainMenu();
        menugameover= new MenuGameOver();
        menuhighscore= new MenuHighScore();
    }

    @Test
    void MainMenuTest(){
        mainmenu.nextEntry();
        assertEquals(Boolean.TRUE,mainmenu.isSelectedHighScore());
        mainmenu.nextEntry();
        mainmenu.nextEntry();
        assertEquals(Boolean.TRUE,mainmenu.isSelectedStart());
        mainmenu.previousEntry();
        assertEquals(Boolean.TRUE,mainmenu.isSelectedExit());
    }
    @Test
    void MenuGameOverTest(){
        assertEquals(Boolean.TRUE,menugameover.isSelectedBacktoMenu());
        menugameover.nextEntry();
        assertEquals(Boolean.TRUE,menugameover.isSelectedExit());

    }

    @Test
    void MenuHighScoreTest(){
        assertEquals(Boolean.TRUE,menuhighscore.isSelectedBacktoMenu());
        menuhighscore.nextEntry();
        assertEquals(Boolean.TRUE,menuhighscore.isSelectedExit());

    }


}
