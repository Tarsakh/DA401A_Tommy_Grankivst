package tarsakh.assignment_2;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "In onCreate");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.Main_Activity_Id , new Frag_Movie_List());
        ft.commit();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "In onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "In onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "In onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "In onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "In onStop");
    }

}
