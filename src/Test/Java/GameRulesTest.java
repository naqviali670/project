import Model.GameRules;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.Button;
import org.junit.jupiter.api.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class GameRulesTest {
    GameRules gr;
    Button [][] button;
    @BeforeEach
    void setUp() {
        gr = new GameRules();

        button = new Button[6][6];

        int i = 0, j = 0;
        for(i=0; i <6; i++)
        {
            for(j=0; j<6; j++)
            {
                button[i][j] = new Button();
                if(i==2 && j==2)
                {
                    button[i][j].setText("X");
                }
            }
        }
    }
    @Test
    void ExceptionWhenDataAlreadyFilledAndPlayerClickedThatNode()
    {
        assertThrows(Exception.class,()->{
            gr.GridRules(button,2,2);
        });
    }
    @Test
    void fillClickedCellAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,4,2);
        assertEquals(5,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstRowLastColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,0,5);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInLastRowFirstColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,5,0);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInFirstRowFirstColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,0,0);
        assertEquals(3,gr.getCount());
    }
    @Test
    void fillClickedCellInLastRowLastColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,5,5);
        assertEquals(3,gr.getCount());
    }
    void fillClickedCellInFirstRowAnyColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,0,2);
        assertEquals(4,gr.getCount());
    }
    void fillClickedCellInLastRowAnyColumnAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,5,2);
        assertEquals(4,gr.getCount());
    }
    void fillClickedCellInFirstColumAnyRowAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,1,0);
        assertEquals(4,gr.getCount());
    }
    void fillClickedCellInLastColumAnyRowAndNeighboursGetCountOfCells() throws Exception {
        gr.GridRules(button,1,5);
        assertEquals(4,gr.getCount());
    }
    }


