package sbca.tests.summary;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sbca.tests.framework.BaseTest;
import sbca.tests.framework.TestListener;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class SummaryPageTests extends BaseTest {

    @Test
    public void shouldFailBecauseOneDoesNotEqualTwo() {
        assertEquals(1, 2);
    }
}
