package de.mjpegsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.niqdev.mjpeg.DisplayMode;
import com.github.niqdev.mjpeg.Mjpeg;
import com.github.niqdev.mjpeg.MjpegInputStream;
import com.github.niqdev.mjpeg.MjpegView;


public class MjpegSample extends AppCompatActivity {

    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(R.layout.activity);

        MjpegView mjpegView = (MjpegView) findViewById(R.id.VIEW_NAME);


        Mjpeg.newInstance()
                .credential("admin", "admin")
                .open("http://192.168.5.10/cgi-bin/mjpg/video.cgi?")
                .subscribe((MjpegInputStream inputStream) -> {

                    mjpegView.setSource(inputStream);
                    mjpegView.setDisplayMode(DisplayMode.BEST_FIT);
                    mjpegView.showFps(true);
                });
    }
}
