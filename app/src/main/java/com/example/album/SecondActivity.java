package com.example.album;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private Button btn;
    private ImageView imageView2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.e(this.getClass().getName(),"onCreate");
        setContentView(R.layout.activity_second);
        btn = findViewById(R.id.btn);
        imageView2 = findViewById(R.id.image2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_PICK,null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,"image/*");
                startActivityForResult(intent,2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if ((requestCode == 2)){
            //从相册返回的数据
            Log.e(this.getClass().getName(),"Result:"+data.toString());
            if (data != null){
                //得到图片的全路径
                Uri uri = data.getData();
                imageView2.setImageURI(uri);
                Log.e(this.getClass().getName(),"Uri:"+String.valueOf(uri));
            }
        }
    }
}
