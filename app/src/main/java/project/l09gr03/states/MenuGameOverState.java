package project.l09gr03.states;

import project.l09gr03.controller.Controller;
import project.l09gr03.controller.menu.MenuGameOverController;
import project.l09gr03.model.menu.MenuGameOver;
import project.l09gr03.viewer.Viewer;
import project.l09gr03.viewer.menu.MenuGameOverViewer;

public class MenuGameOverState extends State<MenuGameOver> {

    public MenuGameOverState(MenuGameOver model) {
        super(model);
    }

    @Override
    protected Viewer<MenuGameOver> getViewer() {
        return new MenuGameOverViewer(getModel());
    }

    @Override
    protected Controller<MenuGameOver> getController() {
        return new MenuGameOverController(getModel());
    }

}
