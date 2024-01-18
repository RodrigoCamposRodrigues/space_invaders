package project.l09gr03.controller.menu;

import project.l09gr03.controller.Controller;
import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.menu.MenuHighScore;
import project.l09gr03.states.GameState;
import project.l09gr03.model.game.arena.LoaderArenaBuilder;
import project.l09gr03.states.MenuHighScoreState;

import java.io.IOException;

public class MenuController extends Controller<MainMenu> {

    public MenuController(MainMenu menu) {
        super(menu);
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder().createArena()));
                if(getModel().isSelectedHighScore()) game.setState(new MenuHighScoreState(new MenuHighScore()));
        }
    }

}
