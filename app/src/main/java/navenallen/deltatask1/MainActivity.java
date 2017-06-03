package navenallen.deltatask1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String RGB_NAME = "MyRGBValues";
    int r=0, g=0, b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences rgbValues = getSharedPreferences(RGB_NAME, 0);
        r =  rgbValues.getInt("r", 0);
        g = rgbValues.getInt("g", 0);
        b = rgbValues.getInt("b", 0);
        setViewColor();
        SeekBar redSeekBar = (SeekBar)findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                r=progress;
                setViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar greenSeekBar = (SeekBar)findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                g=progress;
                setViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        SeekBar blueSeekBar = (SeekBar)findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                b=progress;
                setViewColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void setViewColor(){
        LinearLayout bgView = (LinearLayout) findViewById(R.id.backgroundView);
        TextView red = (TextView) findViewById(R.id.redTextView);
        TextView blue = (TextView) findViewById(R.id.blueTextView);
        TextView green = (TextView) findViewById(R.id.greenTextView);
        bgView.setBackgroundColor(Color.rgb(r,g,b));
        red.setText(r+"\0");
        blue.setText(b+"\0");
        green.setText(g+"\0");
    }

    public void resetRGB(View view){
        r=g=b=0;
        setViewColor();
    }

    @Override
    protected void onStop(){
        super.onStop();

        SharedPreferences rgbValues = getSharedPreferences(RGB_NAME, 0);
        SharedPreferences.Editor editor = rgbValues.edit();
        editor.putInt("r", r);
        editor.putInt("g", g);
        editor.putInt("b", b);

        editor.commit();

    }


};

