package com.example.yulon.activityrecall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private TextView mTxtResult;
    private Button mBtnShowActivity1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        mTxtResult = (TextView)findViewById(R.id.txtResult2);
        mBtnShowActivity1 = (Button)findViewById(R.id.btnShowActivity1);

        Bundle bundle = getIntent().getExtras();
        mTxtResult.setText(bundle.getString("Key1"));

        mBtnShowActivity1.setOnClickListener(btnShowActivity1OnClk);
    }

    private View.OnClickListener btnShowActivity1OnClk = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent();

            Bundle bundle = new Bundle();
            bundle.putString("Key2", "來自 Activity2 的訊息");

            it.putExtras(bundle);
            setResult(RESULT_OK, it);
            finish();
        }
    };
}
