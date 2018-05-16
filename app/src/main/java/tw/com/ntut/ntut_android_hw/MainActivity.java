package tw.com.ntut.ntut_android_hw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtCost;
    private TextView mTxtDate;

    private DatePicker mDpkDate;
    private Spinner mSpnCategory;

    private Button mBtnAdd;
    private Button mBtnSee;

    private ArrayList<String> dataList;
    private int dataCount;


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

        dataList = new ArrayList<>();
        dataCount = 0;
    }

    private DatePicker.OnDateChangedListener dpkDateOnDataChangedListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            // 取得使用者選擇的日期
            String result = String.valueOf(year) + "/"  + String.valueOf(monthOfYear + 1) + "/" + String.valueOf(dayOfMonth);
            // 顯示在文字框裡
            mTxtDate.setText(result);
        }
    };

    private View.OnClickListener btnAddOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 取得新一筆資料
            String count = "項目 " + String.valueOf(dataCount);
            String date = mTxtDate.getText().toString();
            String category = mSpnCategory.getSelectedItem().toString();
            String cost = mTxtCost.getText().toString();
            // 用 Toast 顯示金額
            Toast.makeText(MainActivity.this, cost, Toast.LENGTH_SHORT).show();
            // 存入 ArrayList
            dataList.add(count + "\t" + date + "\t" + category + "\t" + cost);
        }
    };

    private View.OnClickListener btnSeeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "3", Toast.LENGTH_SHORT).show();
        }
    };
}
