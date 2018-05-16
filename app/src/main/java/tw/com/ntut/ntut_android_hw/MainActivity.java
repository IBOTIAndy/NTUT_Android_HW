package tw.com.ntut.ntut_android_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView mTxtCost;
    TextView mTxtDate;

    DatePicker mDpkDate;
    Spinner mSpnCategory;

    Button mBtnAdd;
    Button mBtnSee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtCost = (TextView) findViewById(R.id.txtCost);
        mTxtDate = (TextView) findViewById(R.id.txtDate);
        mDpkDate = (DatePicker) findViewById(R.id.dpkDate);
        mSpnCategory = (Spinner) findViewById(R.id.spnCategory);
        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnSee = (Button) findViewById(R.id.btnSee);

        mDpkDate.setOnDateChangedListener(dpkDateOnDataChangedListener);
        mBtnAdd.setOnClickListener(btnAddOnClickListener);
        mBtnSee.setOnClickListener(btnSeeOnClickListener);
    }

    private DatePicker.OnDateChangedListener dpkDateOnDataChangedListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener btnAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener btnSeeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
        }
    };
}
