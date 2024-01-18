package project.l09gr03.states;

import project.l09gr03.controller.Controller;
import project.l09gr03.controller.menu.MenuHighScoreController;
import project.l09gr03.model.menu.MenuHighScore;
import project.l09gr03.viewer.Viewer;
import project.l09gr03.viewer.menu.MenuHighScoreViewer;

public class MenuHighScoreState extends State<MenuHighScore> {

    public MenuHighScoreState(MenuHighScore menuHighScore) {
        super(menuHighScore);
    }

    @Override
    protected Viewer<MenuHighScore> getViewer() {
        return new MenuHighScoreViewer(getModel());
    }

    @Override
    protected Controller<MenuHighScore> getController() {
        return new MenuHighScoreController(getModel());
    }

}
