package sbca.tests.summary;

import org.testng.annotations.Test;
import sbca.tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SummaryPageTests extends BaseTest {

    @Test
    public void failingTest() {
        assertEquals(1, 2);
    }
}
