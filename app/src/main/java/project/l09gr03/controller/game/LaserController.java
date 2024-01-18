package project.l09gr03.controller.game;

import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.game.elements.Laser;

public class LaserController extends GameController {

    public LaserController(Arena arena) {
        super(arena);
    }

    public void moveLaser(Laser laser)
    {
        laser.setPosition(laser.getPosition().getUp());
    }


    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        for(Laser laser : getModel().getLasers())
        {
            moveLaser(laser);
        }
    }

}
