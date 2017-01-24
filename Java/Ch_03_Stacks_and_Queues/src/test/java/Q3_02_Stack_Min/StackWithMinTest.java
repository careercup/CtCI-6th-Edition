package Q3_02_Stack_Min;

import static org.junit.Assert.*;

/**
 * Created by mgobaco on 1/23/17.
 */
public class StackWithMinTest {

    @org.junit.Test
    public void testPush() throws Exception {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(1);
        stackWithMin.push(2);
        assertEquals(1, stackWithMin.min());
    }

    @org.junit.Test
    public void testMin() throws Exception {

    }
}