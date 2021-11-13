import ch.epfl.sweng.locator.Geolocator;
import ch.epfl.sweng.locator.PositionRange;
import ch.epfl.sweng.locator.Precision;

public class TreasureFinder {

    private final LocationInterface locationInterface;

    // There MUST be a parameterless constructor,
    // it is used by our Super-Fancy-Framework-That-Does-Not-Support-Parameters™
    public TreasureFinder() {
        locationInterface = new GeolocatorLocator();
    }

    public TreasureFinder( LocationInterface locationInterface){
        this.locationInterface = locationInterface;
    }

    public String getHint(Position treasurePos) {
        Position position;
        try{
           position = locationInterface.getUserPosition();
        }catch (Exception e) {
            return "The treasure blabla";
        }
        double userLatitude = position.latitude;
        double userLongitude = position.longitude;


        if (userLatitude > 70) {
            return "Nope, the treasure is not at the North Pole.";
        }

        // Not accurate because of the Earth's curvature. Better calculation coming next sprint!
        double diff = Math.sqrt(Math.pow(treasurePos.latitude - userLatitude, 2) + Math.pow(treasurePos.longitude - userLongitude, 2));

        if (diff < 0.005) {
            return "You're right there!";
        }

        if (diff < 0.05) {
            return "Close...";
        }

        if (diff < 0.5) {
            return "Not too far.";
        }

        return "Far away.";
    }
}
