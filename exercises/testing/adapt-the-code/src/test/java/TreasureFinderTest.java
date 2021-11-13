import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class TreasureFinderTest {

    @Test
    void exampleTest() {
        assertThat(1 + 1, is(2));
    }

    @Test
    void testWithGoodDataIsCorrect(){
        LocationService locationService = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(45, 45 );
            }
        };
        TreasureFinder treasureFinder = new TreasureFinder(locationService);
        Position treasure = new Position(0, 0);
        assertThat(treasureFinder.getHint(treasure), is("Far away."));
    }

    @Test
    void testExactLocation(){

        TreasureFinder treasureFinder = new TreasureFinder();
        Position player = new Position(46.516659, 6.5641015 );
        assertThat(treasureFinder.getHint(player), is("Far away."));
    }




}
