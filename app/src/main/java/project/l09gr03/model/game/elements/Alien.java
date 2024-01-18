package project.l09gr03.model.game.elements;

public class Alien extends Element {

    private boolean isAlive;


    public Alien(int x, int y)
    {
        super(x,y);;
        this.isAlive = true;
    }

    public enum DIRECTION {RIGHT, LEFT}



}
