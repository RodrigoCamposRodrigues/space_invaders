package project.l09gr03.controller.menu;

import project.l09gr03.controller.Controller;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.model.menu.MenuHighScore;
import project.l09gr03.states.MenuState;

import java.io.IOException;

public class MenuHighScoreController extends Controller<MenuHighScore> {

    public MenuHighScoreController(MenuHighScore menuHighScore) {
        super(menuHighScore);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if(getModel().isSelectedBacktoMenu()) game.setState(new MenuState(new MainMenu()));
                if(getModel().isSelectedExit()) game.setState(null);
        }
    }

}
