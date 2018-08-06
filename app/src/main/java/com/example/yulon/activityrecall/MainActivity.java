package com.example.yulon.activityrecall;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtResult;
    private Button mBtnShowActivity2;
    final static private int LAUNCH_GAME = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);

        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnShowActivity2 = (Button)findViewById(R.id.btnShowActivity2);

        mBtnShowActivity2.setOnClickListener(btnShowActivity2OnClk);
    }

    private View.OnClickListener btnShowActivity2OnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();

            it.setClass(MainActivity.this, Main2Activity.class);

            Bundle bundle = new Bundle();
            bundle.putString("Key1", "來自 Activity1 的訊息");
            it.putExtras(bundle);

//            startActivity(it);
            startActivityForResult(it, LAUNCH_GAME);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode != LAUNCH_GAME){
            return;
        }

        switch (resultCode){
            case RESULT_OK:
                Bundle bundle = data.getExtras();

                String s = bundle.getString("Key2");
                mTxtResult.setText(s);
                break;
        }
    }
}
