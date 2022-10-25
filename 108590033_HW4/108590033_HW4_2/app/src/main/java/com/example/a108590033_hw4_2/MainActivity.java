package com.example.a108590033_hw4_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
        Button buttonCamera = (Button)findViewById(R.id.button);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            String uri_string = getString(R.string.edittext_uri)
                    + uri.toString();
            TextView textView = findViewById(R.id.website_edittext);
            textView.setText(uri_string);
        }
        buttonCamera.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v) {
                //使用Intent調用其他服務幫忙拍照
                Intent intent_camera = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent_camera, 0);
            }

        });
    }
    public void openWebsite(View view) {
        // Get the URL text.
        String url = mWebsiteEditText.getText().toString();

        // Parse the URI and create the intent.
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }
    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.button_share)
                .setText(txt)
                .startChooser();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //拍照後顯示圖片
        ImageView iv = (ImageView)findViewById(R.id.imagecaptured);
        if (resultCode == RESULT_OK)
        {
            //取出拍照後回傳資料
            Bundle extras = data.getExtras();
            //將資料轉換為圖像格式
            Bitmap bmp = (Bitmap) extras.get("data");
            //載入ImageView
            iv.setImageBitmap(bmp);
        }

        //覆蓋原來的Activity
        super.onActivityResult(requestCode, resultCode, data);
    }
}
