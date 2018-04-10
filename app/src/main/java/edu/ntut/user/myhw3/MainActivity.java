package edu.ntut.user.myhw3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRadGrpSex;
    private RadioButton mRadBtnMale;
    private RadioButton mRadBtnFemale;
    private Spinner mSpnAge;
    private ArrayList<CheckBox> listChkHobbies;
    private Button mBtnOK;
    private TextView mTxtHobbyResult;

    private MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadGrpSex = (RadioGroup) findViewById(R.id.radGrpSex);
        mRadBtnMale = (RadioButton) findViewById(R.id.radBtnMale);
        mRadBtnFemale = (RadioButton) findViewById(R.id.radBtnFemale);

        mSpnAge = (Spinner) findViewById(R.id.spnAge);

        listChkHobbies = new ArrayList<>();
        listChkHobbies.add((CheckBox) findViewById(R.id.chkMusic));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkSing));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkDance));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkTravel));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkReading));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkWriting));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkClimbing));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkSwim));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkEating));
        listChkHobbies.add((CheckBox) findViewById(R.id.chkDrawing));

        mBtnOK = (Button) findViewById(R.id.btnOK);

        mTxtHobbyResult = (TextView) findViewById(R.id.txtHobbyResult);

        mBtnOK.setOnClickListener(btnOKOnClick);
        mRadGrpSex.setOnCheckedChangeListener(radGrpSexOnCheckedChange);

        main = this;
    }

    private RadioGroup.OnCheckedChangeListener radGrpSexOnCheckedChange = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            ArrayAdapter<String> adapter;
            String entries[];

            if ((RadioButton) findViewById(i) == mRadBtnMale) {
                entries = getResources().getStringArray(R.array.male_age);
                adapter = new ArrayAdapter<String>(main, android.R.layout.simple_list_item_1, entries);
            }
            else {
                entries = getResources().getStringArray(R.array.female_age);
                adapter = new ArrayAdapter<String>(main, android.R.layout.simple_list_item_1, entries);
            }

            mSpnAge.setAdapter(adapter);
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String hobbies = getResources().getString(R.string.hobby_result);
            for (CheckBox chkHobby : listChkHobbies) {
                if (chkHobby.isChecked()) {
                    hobbies += chkHobby.getText().toString() + " ";
                }
            }

            mTxtHobbyResult.setText(hobbies);
        }
    };
}
