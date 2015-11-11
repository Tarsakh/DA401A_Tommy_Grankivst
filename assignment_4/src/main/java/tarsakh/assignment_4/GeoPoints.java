package tarsakh.assignment_4;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Tommy on 2015-11-09.
 */

public class GeoPoints {

    public final int N_Treasures = 3;
    private final double Radius = 15;
    private final double[][] Treasure_Locations = {{55.609455, 12.996928}, {55.611167, 12.994578}, {55.608149, 12.991692}, {55.607552, 12.999615}};
    public final int[] Correct_Answers = {1, 2, 0, 2};
    private static int Treasures_Found = 0;
    private Location current_player_location;
    private Location current_treasure_location;
    private LatLng latLng;


    public GeoPoints() {

    }


    public void setCurrentPlayerLocation(Location location) {
        current_player_location = new Location("");
        current_player_location.setLongitude(location.getLongitude());
        current_player_location.setLatitude(location.getLatitude());
    }


    public void setCurrentTreasureLocation() {
        current_treasure_location = new Location("");
        current_treasure_location.setLongitude(Treasure_Locations[Treasures_Found][1]);
        current_treasure_location.setLatitude(Treasure_Locations[Treasures_Found][0]);
    }


    public void incrementTreasureFoundCounter() {
        Treasures_Found += 1;
    }


    public LatLng getCurrentTreasureLocation() {
        latLng = new LatLng(current_treasure_location.getLatitude(), current_treasure_location.getLongitude());
        return latLng;
    }


    public int getTreasureFoundCounter() {
        return Treasures_Found;
    }


    public boolean isTreasureFound() {
        if (current_player_location.distanceTo(current_treasure_location) <= Radius) {
            return true;
        }
        return false;
    }
}
