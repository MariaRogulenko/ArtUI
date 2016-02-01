package course.example.artui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.ImageView;
import android.graphics.Color;



public class MainActivity extends Activity {

    private SeekBar seekBar;
    private ImageView mView1;
    private ImageView mView2;
    private ImageView mView3;
    private ImageView mView4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seek);
        mView1 = (ImageView) findViewById(R.id.image1);
        mView2 = (ImageView) findViewById(R.id.image2);
        mView3 = (ImageView) findViewById(R.id.image3);
        mView4 = (ImageView) findViewById(R.id.image4);

        mView1.setBackgroundColor(Color.argb(150, 0, 0, 0));
        mView2.setBackgroundColor(Color.argb(150, 100, 0, 100));
        mView3.setBackgroundColor(Color.argb(150, 0, 50, 50));
        mView4.setBackgroundColor(Color.argb(150, 150, 0, 100));


        seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                mView1.setBackgroundColor(Color.argb(150, progress, progress, 0));
                mView2.setBackgroundColor(Color.argb(150, 100, progress, 100));
                mView3.setBackgroundColor(Color.argb(150, progress, 50, 50));
                mView4.setBackgroundColor(Color.argb(150, 150, progress, 100));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

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
        MyDialogFragment mDialog = MyDialogFragment.newInstance();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            mDialog.show(getFragmentManager(), "dialog");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
