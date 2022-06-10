package test;

import org.junit.*;
import static org.junit.Assert.*;
import problems.*;
import org.junit.Test;


public class TestLogic {

    /**
     * @Test
     * @Test(timeout=1000)
     * @BeforeClass
     * @Before
     * @After
     * @AfterClass
     */

    @Test
    public void testFindMax() {
        assertEquals(4, Calculations.findMax(new int[]{1, 3, 4, 2}));
        assertEquals("This is not working", -1, Calculations.findMax(new int[]{-12, -1, -3, -4, -2}));

    }
}