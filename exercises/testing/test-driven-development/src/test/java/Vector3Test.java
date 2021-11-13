import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

final class Vector3Test {

    @Test
    public void sampleTest() {
        assertThat(1, is(1));
    }

    @Test
    public void checkSizeIsZero(){
        Vector3 vector = new Vector3(0, 0, 0);
        assertThat(vector.isNull(), is(true));

    }

}
