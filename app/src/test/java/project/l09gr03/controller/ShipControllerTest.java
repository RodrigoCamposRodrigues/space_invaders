package project.l09gr03.controller;

import project.l09gr03.controller.game.ShipController;
import project.l09gr03.model.Position;
import project.l09gr03.model.game.arena.Arena;
import project.l09gr03.model.game.elements.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShipControllerTest {
    private ShipController controller;
    private Ship ship;
    private Arena arena;


    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);
        ship = new Ship(1, 5);
        arena.setShip(ship);
        controller = new ShipController(arena);
    }


    @Test
    void moveShipRightTest() {
        controller.moveShipRight();
        assertEquals(new Position(2, 5), ship.getPosition());
    }

    @Test
    void moveShipLeftTest() {
        controller.moveShipLeft();
        assertEquals(new Position(0, 5), ship.getPosition());
    }



}

