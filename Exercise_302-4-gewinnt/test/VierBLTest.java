
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value = Parameterized.class)
public class VierBLTest {

    @Parameterized.Parameter(value = 0)
    public Value player;
    @Parameterized.Parameter(value = 1)
    public Value winner;

    @Parameterized.Parameters(name = "expRes=Res")
    public static Iterable<Object[]> data1() {
        return Arrays.asList(new Object[][]{
            {Value.PLAYER2, Value.PLAYER2} ,
            {Value.PLAYER1, Value.PLAYER1},
            {Value.EMPTY, Value.EMPTY}
        });
    }

    public VierBLTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of testWinner method, of class VierBL.
     */
    @Test
    public void testTestWinner() {
        System.out.println("testWinner");
        VierBL instance = new VierBL(10, 6);
        try {
            //player 2 sollte gewinnen
            if(player==Value.PLAYER2){
            instance.makeMove(0);
            instance.makeMove(9);
            instance.makeMove(1);
            instance.makeMove(8);
            instance.makeMove(3);
            instance.makeMove(7);
            instance.makeMove(4);
            instance.makeMove(6);
           
        }
            //player 1 sollte gewinnen
            if(player==Value.PLAYER1){
               instance.makeMove(6);
            instance.makeMove(0);
            instance.makeMove(9);
            instance.makeMove(1);
            instance.makeMove(8);
            instance.makeMove(3);
            instance.makeMove(7);
            instance.makeMove(4);
            
            
           
        }
            //keiner sollte gewinnen
            if(player==Value.EMPTY){
            instance.makeMove(0);
            instance.makeMove(1);
            instance.makeMove(2);
            instance.makeMove(3);
            instance.makeMove(4);
            instance.makeMove(5);
            instance.makeMove(6);
            instance.makeMove(7);
           
        }

        } catch (Exception ex) {
            Logger.getLogger(VierBLTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Value expResult = winner;
        Value result = instance.testWinner();
        System.out.println("expResult: "+expResult+"   result: "+result);
        assertEquals(expResult, result);
     
    }

}
