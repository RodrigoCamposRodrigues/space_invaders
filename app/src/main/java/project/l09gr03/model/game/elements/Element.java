package project.l09gr03.model.game.elements;
import project.l09gr03.model.Position;

public abstract class Element {

    private Position position;

    public Element(int x, int y)
    {
        this.position = new Position(x,y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

}
