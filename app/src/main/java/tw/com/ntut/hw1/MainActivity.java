package tw.com.ntut.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText mEdtSex, mEdtAge;
    TextView mTxtR;
    Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdtSex = (EditText)findViewById(R.id.edtSex);
        mEdtAge = (EditText)findViewById(R.id.edtAge);
        mTxtR = (TextView)findViewById(R.id.txtR);
        mBtnOK = (Button)findViewById(R.id.btnOK);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String userSex = mEdtSex.getText().toString();
            int userAge = Integer.parseInt(mEdtAge.getText().toString());

            String suggestion = getString(R.string.suggestion);

            if (userSex.equals(getString(R.string.male))) {
                if (userAge < 30) {
                    suggestion += getString(R.string.sug_not_hurry);

                } else if (userAge >= 30 && userAge <= 35) {
                    suggestion += getString(R.string.sug_find_couple);

                } else {
                    suggestion += getString(R.string.sug_get_married);

                }

            } else if (userSex.equals(getString(R.string.female))) {
                if (userAge < 28) {
                    suggestion += getString(R.string.sug_not_hurry);

                } else if (userAge >= 28 && userAge <= 32) {
                    suggestion += getString(R.string.sug_find_couple);

                } else {
                    suggestion += getString(R.string.sug_get_married);

                }

            }

            mTxtR.setText(suggestion);

        }
    };
}
