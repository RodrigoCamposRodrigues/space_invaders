package project.l09gr03.controller.game;

import project.l09gr03.controller.Controller;
import project.l09gr03.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {

    public GameController(Arena arena) {
        super(arena);
    }

}
