package coursera.modernartui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

import java.util.zip.Inflater;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seek = (SeekBar) findViewById(R.id.seekBar);
        final View[] views = new View[6];
        views[0] = (View) findViewById(R.id.view1);
        views[1] = (View) findViewById(R.id.view2);
        views[2] = (View) findViewById(R.id.view3);
        views[3] = (View) findViewById(R.id.view4);
        views[4] = (View) findViewById(R.id.view5);
        views[5] = (View) findViewById(R.id.view6);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //slide changes boxes colors
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                for (View view : views) {
                    int color = Color.parseColor((String) view.getTag());
                    if (color != getResources().getColor(R.color.pink)) {
                        view.setBackgroundColor(color + progress);
                    }
                }
            }

            //not used
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            //not used
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
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
        if (id == R.id.action_more_info) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Inspired by art! To see more Art click here");
            dialog.setCancelable(true);
            dialog.setPositiveButton("Visit MOMA",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Intent moma = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                            startActivity(moma);
                        }
                    });
            dialog.setNegativeButton("Not Now",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alert11 = dialog.create();
            alert11.show();
        }

        return super.onOptionsItemSelected(item);
    }

}
