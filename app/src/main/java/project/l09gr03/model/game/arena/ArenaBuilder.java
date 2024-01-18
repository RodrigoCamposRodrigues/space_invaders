package project.l09gr03.model.game.arena;

import project.l09gr03.model.game.elements.Laser;
import project.l09gr03.model.game.elements.Ship;
import project.l09gr03.model.game.elements.Alien;
import java.util.List;

public abstract class ArenaBuilder
{
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setShip(createShip());
        arena.setAliens(createAliens());
        arena.setLasers(createLasers());
        return arena;
    }

    public Arena createArenaWithShip(Ship ship) {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setShip(ship);
        arena.setAliens(createAliens());
        arena.setLasers(createLasers());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();
    protected abstract List<Alien> createAliens();

    protected abstract Ship createShip();

    protected abstract List<Laser> createLasers();

}
