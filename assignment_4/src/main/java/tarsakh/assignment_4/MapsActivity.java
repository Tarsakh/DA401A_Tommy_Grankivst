package tarsakh.assignment_4;

import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.app.FragmentTransaction;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements GoogleApiClient.ConnectionCallbacks, com.google.android.gms.location.LocationListener, QuestDialog.OnOptionSelected {

    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private GeoPoints mGeoPoints;
    private Marker mMarker;
    public Bundle args;
    public LocationRequest mLocationRequest;
    public boolean playerAnswered = true;
    public Vibrator mVibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        args = new Bundle();
        mGeoPoints = new GeoPoints();
        mGeoPoints.setCurrentTreasureLocation();
        mVibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        setUpMapIfNeeded();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .build();
        mGoogleApiClient.connect();

    }


    @Override
    protected void onResume() {
        super.onResume();

        setUpMapIfNeeded();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }


    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setMyLocationEnabled(true);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        LatLng home = new LatLng(55.608573, 12.995292);

        UiSettings mUISetting = mMap.getUiSettings();
        mUISetting.setZoomControlsEnabled(true);
        mUISetting.setMyLocationButtonEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(16));
        mMarker = mMap.addMarker(new MarkerOptions().position(mGeoPoints.getCurrentTreasureLocation()).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_station)));
    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.i("TAG", "Connected");
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }


    @Override
    public void onConnectionSuspended(int i) {
    }


    @Override
    public void onLocationChanged(Location location) {
        mGeoPoints.setCurrentPlayerLocation(location);
        if (mGeoPoints.isTreasureFound() && playerAnswered) {
            new_Question();
            playerAnswered = false;
        }
    }


    public void new_Question() {
        args.putInt("quest", mGeoPoints.getTreasureFoundCounter());
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        QuestDialog mDialog = new QuestDialog();
        mDialog.setArguments(args);
        mDialog.show(ft, "dialog");

        MediaPlayer enter = MediaPlayer.create(this, R.raw.enter);

        enter.start();

        mVibrator.vibrate(2000);
    }


    @Override
    public void onComplete(int option) {
        playerAnswered = true;
        Toast toast;
        //If answer is wrong --> game over
        if (option != mGeoPoints.Correct_Answers[mGeoPoints.getTreasureFoundCounter()]) {
            toast = Toast.makeText(getApplicationContext(), "Wrong answer, game over!!!", Toast.LENGTH_LONG);
            MediaPlayer wrong = MediaPlayer.create(this, R.raw.wa_wa_waaa);
            wrong.start();
            mMap.clear();
            playerAnswered = false;
        }
        //If answer is right --> continue
        else {
            toast = Toast.makeText(getApplicationContext(), "Right answer!!!", Toast.LENGTH_LONG);
            //If it is last treasure_point ---> player win
            if (mGeoPoints.getTreasureFoundCounter() == mGeoPoints.N_Treasures) {
                toast = Toast.makeText(getApplicationContext(), "CONGRATULATIONS, YOU FOUND ALL TREASURES!!!", Toast.LENGTH_LONG);
                MediaPlayer right = MediaPlayer.create(this, R.raw.ffvii_victory_fanfare);
                right.start();
                mVibrator.vibrate(200);
                mMap.clear();
                playerAnswered = false;
            }
            //If it is right answer but not last treasure_point ---> spawn new treasure_point
            else {
                mMarker.remove();
                mGeoPoints.incrementTreasureFoundCounter();
                mGeoPoints.setCurrentTreasureLocation();
                mMarker = mMap.addMarker(new MarkerOptions().position(mGeoPoints.getCurrentTreasureLocation()).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_station)));
            }
        }
        toast.show();
    }
}
