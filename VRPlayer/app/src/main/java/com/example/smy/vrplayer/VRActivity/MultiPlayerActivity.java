package com.example.smy.vrplayer.VRActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.example.smy.vrplayer.R;
import com.example.smy.vrplayer.VRView.CustomMultiPlayView;

public class MultiPlayerActivity extends Activity {

    public static final String VIDEO_PATH = "vrvideopath";
    CustomMultiPlayView multiPlayView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_multi_player);

        multiPlayView = (CustomMultiPlayView) findViewById(R.id.playerView);
        multiPlayView.setDataSource(getIntent().getStringExtra(VIDEO_PATH));

        /*VRSettingView settingView = new VRSettingView(getBaseContext(), null);
        settingView.setDataSource(convertLayoutToBitmap());
        settingView.setBackgroundColor(Color.BLUE);
        addContentView(settingView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));

        CustomMultiPlayView multiPlayView = new CustomMultiPlayView(getBaseContext(), null);
        multiPlayView.setDataSource(getIntent().getStringExtra(VIDEO_PATH));
        addContentView(multiPlayView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,FrameLayout.LayoutParams.MATCH_PARENT));*/
    }

    public Bitmap convertLayoutToBitmap(){
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.picture_setting_float, null);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;

        Log.d("SDBG","get measure : " + width + " ;  " + height);
        int widthSpec = View.MeasureSpec.makeMeasureSpec(width, View.MeasureSpec.EXACTLY);
        int heightSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY);
        view.measure(widthSpec, heightSpec);
        view.layout(0, 0, width, height);

        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();

        return bitmap;
    }

}
