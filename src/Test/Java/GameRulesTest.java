import Model.GameRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    GameRules gr;

    @BeforeEach
    void setUp() {
        gr = new GameRules();
    }
    @Test
    void fillClickedCellAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                4,2,4,1,3,2,5,2,4,3
        };
        Object[] indexesActual = (gr.GridRules(4,2)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(5,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstRowLastColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                0,5,0,4,1,5
        };
        Object[] indexesActual = (gr.GridRules(0,5)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInLastRowFirstColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                5,0,5,1,4,0
        };
        Object[] indexesActual = (gr.GridRules(5,0)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstRowFirstColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                0,0,0,1,1,0
        };
        Object[] indexesActual = (gr.GridRules(0,0)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInLastRowLastColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                5,5,5,4,4,5
        };
        Object[] indexesActual = (gr.GridRules(5,5)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstRowAnyColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                0,2,0,1,1,2,0,3
        };
        Object[] indexesActual = (gr.GridRules(0,2)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(4,gr.getCount());
    }
    @Test
    void fillClickedCellInLastRowAnyColumnAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                5,2,5,1,4,2,5,3
        };
        Object[] indexesActual = (gr.GridRules(5,2)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(4,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstColumAnyRowAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                1,0,1,1,0,0,2,0
        };
        Object[] indexesActual = (gr.GridRules(1,0)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(4,gr.getCount());
    }
    @Test
    void fillClickedCellInLastColumAnyRowAndNeighboursGetCountOfCells() throws Exception {
        Object[] indexes = new Object[]{
                1,5,1,4,0,5,2,5
        };
        Object[] indexesActual = (gr.GridRules(1,5)).toArray();
        assertArrayEquals(indexes,indexesActual);
        assertEquals(4,gr.getCount());
    }

}