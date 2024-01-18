package project.l09gr03.model.game.elements;

public class Laser extends Element {

    private final int len = 2;

    public Laser(Ship ship)
    {
        super(ship.getPosition().getX(), ship.getPosition().getY());
    }

}
