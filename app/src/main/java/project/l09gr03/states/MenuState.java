package project.l09gr03.states;

import project.l09gr03.model.menu.MainMenu;
import project.l09gr03.controller.menu.MenuController;
import project.l09gr03.controller.Controller;
import project.l09gr03.viewer.menu.MenuViewer;
import project.l09gr03.viewer.Viewer;

public class MenuState extends State<MainMenu> {

    public MenuState(MainMenu model) {
        super(model);
    }

    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<MainMenu> getController() {
        return new MenuController(getModel());
    }

}
