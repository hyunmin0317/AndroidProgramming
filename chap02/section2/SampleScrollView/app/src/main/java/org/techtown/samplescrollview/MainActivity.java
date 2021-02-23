package org.techtown.samplescrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {
    ScrollView scrollView;
    ImageView imageView;
    BitmapDrawable bitmap;
    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrollView = findViewById(R.id.scrollView);
        imageView = findViewById(R.id.imageView);
        scrollView.setHorizontalScrollBarEnabled(true);
        showImage();
    }

    public void onButton1Clicked(View v) {
        showImage();
    }

    private void showImage() {
        int bitmapWidth, bitmapHeight;
        Resources res = getResources();
        if (imageIndex == 0) {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image01);
            imageIndex = 1;
        }
        else {
            bitmap = (BitmapDrawable) res.getDrawable(R.drawable.image02);
            imageIndex = 0;
        }
        bitmapWidth = bitmap.getIntrinsicWidth();
        bitmapHeight = bitmap.getIntrinsicHeight();
        imageView.setImageDrawable(bitmap);
        imageView.getLayoutParams().width = bitmapWidth;
        imageView.getLayoutParams().height = bitmapHeight;
    }
}