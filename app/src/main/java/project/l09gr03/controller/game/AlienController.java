package project.l09gr03.controller.game;

import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.Position;
import project.l09gr03.game.Game;
import project.l09gr03.gui.GUI;
import project.l09gr03.model.game.arena.LoaderArenaBuilder;
import project.l09gr03.model.game.elements.Alien;
import project.l09gr03.states.GameState;

import java.io.IOException;

public class AlienController extends GameController
{
    private long lastMovement;
    private Alien.DIRECTION direction;
    private Alien.DIRECTION checkLastDirection;
    private boolean checkReachedLowerLimit;

    public AlienController(Arena arena)
    {
        super(arena);
        this.lastMovement = 0;
        this.direction = Alien.DIRECTION.RIGHT;
        this.checkLastDirection = this.direction;
        this.checkReachedLowerLimit = false;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        direction();

        if (time - lastMovement > 500) {
            for (Alien alien : getModel().getAliens()) {

                ifShipCollidedWithAlien(game, alien);

                ifDirectionChanged();

                moveAlienRight(alien, this.direction);
                moveAlienLeft(alien, this.direction);

            }
            this.lastMovement = time;
        }
    }

    private void ifDirectionChanged() {
        if(checkDirectionChanged() && !this.checkReachedLowerLimit)//se a direção tiver mudado
        {
            for (Alien alien1 : getModel().getAliens()) {
                moveAlienDown(alien1);
                this.checkLastDirection = this.direction;
            }
        }
    }

    private void ifShipCollidedWithAlien(Game game, Alien alien) throws IOException {
        if(checkCollisionWithShip(alien))
        {
            getModel().getShip().decreaseLife();
            game.setState(new GameState(new LoaderArenaBuilder().createArenaWithShip(getModel().getShip())));
            getModel().getShip().setScore(0);
        }
    }


    public void moveAlienRight(Alien alien, Alien.DIRECTION direction)
    {
        if(direction == Alien.DIRECTION.RIGHT) {
            moveAlien(alien, alien.getPosition().getRight());
        }
    }

    public void moveAlienLeft(Alien alien, Alien.DIRECTION direction)
    {
        if(direction == Alien.DIRECTION.LEFT) {
            moveAlien(alien, alien.getPosition().getLeft());
        }
    }

    public void moveAlienDown(Alien alien)
    {
        moveAlien(alien, alien.getPosition().getDown());
    }

    private void moveAlien(Alien alien, Position position) {

        alien.setPosition(position);
    }

    public void direction() //encontrar a direção que quero que os aliens se movam
    {
        //procurar a posição mais à direita,esquerda,cima e baixo
        int greatestX = getModel().getAliens().get(0).getPosition().getX();
        int lowestX = getModel().getAliens().get(0).getPosition().getX();
        int lowestY = getModel().getAliens().get(0).getPosition().getY();
        for(Alien alien1 : getModel().getAliens())
        {
            if(alien1.getPosition().getX() > greatestX) greatestX = alien1.getPosition().getX();
            if(alien1.getPosition().getX() < lowestX) lowestX = alien1.getPosition().getX();
            if(alien1.getPosition().getY() > lowestY) lowestY = alien1.getPosition().getY();
        }

        ifReachedRightLimit(greatestX);
        ifReachedLeftLimit(lowestX);
        ifReachedLowerLimit(lowestY);
    }

    private void ifReachedLeftLimit(int lowestX) {
        if(lowestX == 0)
        {
            this.direction = Alien.DIRECTION.RIGHT;
        }
    }

    private void ifReachedRightLimit(int greatestX) {
        if(greatestX == getModel().getWidth() - 2)
        {
            this.direction = Alien.DIRECTION.LEFT;
        }
    }

    private void ifReachedLowerLimit(int lowestY)
    {
        if(lowestY == 19)
        {
            this.checkReachedLowerLimit = true;
        }
    }

    public boolean checkDirectionChanged()
    {
        return this.checkLastDirection != this.direction;
    }

    public boolean checkCollisionWithShip(Alien alien)
    {
        return alien.getPosition().equals(getModel().getShip().getPosition());
    }

}
