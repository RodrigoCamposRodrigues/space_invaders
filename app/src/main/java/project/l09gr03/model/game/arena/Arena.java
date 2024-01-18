package project.l09gr03.model.game.arena;

import project.l09gr03.model.Position;
import project.l09gr03.model.game.elements.Laser;
import project.l09gr03.model.game.elements.Ship;
import project.l09gr03.model.game.elements.Alien;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    private final int height;
    private final int width;
    private Ship ship;
    private List<Laser> lasers;
    private List<Alien> aliens;
    public Arena(int height, int width)
    {
        this.height = height;
        this.width = width;
        this.lasers = new ArrayList<Laser>();
        this.aliens = new ArrayList<Alien>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ship getShip() {
        return ship;
    }

    public List<Laser> getLasers()
    {
        return this.lasers;
    }
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setLasers(List<Laser> lasers)
    {
        this.lasers = lasers;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public boolean ifOutOfBounds(Position position) {
        if(position.getX() > this.width - 2)
        {
            return true;
        }
        else if(position.getX() < 0)
        {
            return true;
        }
        else if (position.getY() > this.height) {
            return true;
        }
        else if (position.getY() < 0) {
            return true;
        }

        return false;
    }

}
