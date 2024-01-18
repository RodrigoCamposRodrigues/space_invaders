package project.l09gr03.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import project.l09gr03.model.game.arena.Arena;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import project.l09gr03.model.game.elements.Laser;
import project.l09gr03.model.game.elements.Ship;

public class ArenaTest {
    private Position position1;

    private Position position2;

    private Arena arena;

    private Ship ship;
    private Laser laser;

    @BeforeEach
    void setUp() {
        position1=new Position(30,30);
        position2=new Position(5,5);
        arena = new Arena(20, 20);
        ship= new Ship(4,5);
        laser= new Laser(ship);
    }

    @Test
    void ifOutOfBoundsTest() {
        assertEquals(true, arena.ifOutOfBounds(position1));
        assertEquals(false, arena.ifOutOfBounds(position2));
    }

    @Test
    void LaserTest() {
        assertEquals(new Position(4, 5), ship.getPosition());
    }

    @Test
    void ShipTest() {
        assertEquals(0,ship.getScore());
        assertEquals(3,ship.getLife());
        ship.decreaseLife();
        assertEquals(2,ship.getLife());
        ship.increaseScore(10);
        assertEquals(10,ship.getScore());
        ship.setScore(15);
        assertEquals(15,ship.getScore());
        ship.decreaseScore(10);
        assertEquals(5,ship.getScore());
    }

}
