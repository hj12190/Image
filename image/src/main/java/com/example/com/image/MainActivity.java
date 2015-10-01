package com.example.com.image;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    Switch switch1;
    RadioGroup rGroup1;
    RadioButton jellybean, kitkat, lollipop;
    ImageView android1;
    Button btnFinsh, btnFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("안드로이드 사진 보기");

        text1 = (TextView) findViewById(R.id.Text1);
        switch1 = (Switch) findViewById(R.id.Switch1);

        text2 = (TextView) findViewById(R.id.Text2);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        jellybean = (RadioButton) findViewById(R.id.Jellybean);
        kitkat = (RadioButton) findViewById(R.id.Kitkat);
        lollipop = (RadioButton) findViewById(R.id.Lollipop);

        android1 = (ImageView) findViewById(R.id.Android1);

        btnFinsh = (Button) findViewById(R.id.BtnFinsh);
        btnFirst = (Button) findViewById(R.id.BtnFirst);


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {

                if (switch1.isChecked() == true) {
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    android1.setVisibility(android.view.View.VISIBLE);

                    rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {

                            switch (rGroup1.getCheckedRadioButtonId()) {
                                case R.id.Jellybean:
                                    android1.setImageResource(R.drawable.jellybean);
                                    break;
                                case R.id.Kitkat:
                                    android1.setImageResource(R.drawable.kitkat);
                                    break;
                                case R.id.Lollipop:
                                    android1.setImageResource(R.drawable.lollipop);
                                    break;
                            }

                        }

                    });
                } else {
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    android1.setVisibility(android.view.View.INVISIBLE);
                }

            }

        });


        btnFinsh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
