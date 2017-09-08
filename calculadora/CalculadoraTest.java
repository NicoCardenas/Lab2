import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CalculadoraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CalculadoraTest{

    private Calculadora a1, a2 ,a3;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        a1 = new Calculadora();
        a2 = new Calculadora();
        a3 = new Calculadora();
    }

    @Test
    public void deberiaAdicionar(){
        a1.adicione(1, 60.0);
    }
    
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
