import Model.Player1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Player1Test {
    Player1 player1 ;
    @BeforeEach
    void setUp() {
        player1 = new Player1();
    }

    @Test
    void TurnsCalculatorForPlayers() {
        player1.TurnCalculator(3);
        assertEquals(3,player1.getTurns());
    }
}