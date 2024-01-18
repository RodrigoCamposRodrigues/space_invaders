package project.l09gr03.model.game.elements;



import project.l09gr03.game.Game;

public class Ship extends Element {

    private int life = 3;
    private int score;

    public Ship(int x, int y)
    {
        super(x,y);
        this.score = 0;
    }

    public int getLife(){return this.life;}

    public void decreaseLife(){this.life--;}

    public void increaseScore(int score) {
        this.score += score;
    }

    public void decreaseScore(int score) {
        this.score -= score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

}
