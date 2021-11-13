import ch.epfl.sweng.locator.Geolocator;
import ch.epfl.sweng.locator.PositionRange;
import ch.epfl.sweng.locator.Precision;

public class GeolocatorLocator implements LocationInterface {

    private Geolocator geolocator = new Geolocator(Precision.FINE);

    @Override
    public Position getUserPosition() throws Exception {
        if (!geolocator.isLocationServiceRunning()) {
            geolocator.startLocationService();
        }

        PositionRange userPositionRange = geolocator.getUserPosition();
        double userLatitude = (userPositionRange.maxLatitude + userPositionRange.minLatitude) / 2.0;
        double userLongitude = (userPositionRange.maxLongitude + userPositionRange.minLongitude) / 2.0;
        return new Position(userLatitude, userLongitude);
    }
}
