package tarsakh.assignment_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("MainActivity", "In onCreate");

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.main_Activity_Id, new Frag_Movie_List())
                    .commit();


        /*
        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.main_Activity_Id, new Frag_Movie_List());
            ft.commit();*/
        }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
