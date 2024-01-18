package project.l09gr03.states;

import project.l09gr03.controller.Controller;
import project.l09gr03.controller.game.ArenaController;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.viewer.Viewer;
import project.l09gr03.viewer.game.GameViewer;

public class GameState extends State<Arena>{

    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }

}
