package tw.com.ntut.ntut_android_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RecordActivity extends AppCompatActivity {

    ListView mLtvRecord;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Intent intent = getIntent();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1);
        arrayAdapter.addAll(intent.getStringArrayListExtra("dataList"));

        mLtvRecord = (ListView) findViewById(R.id.ltvRecord);
        mLtvRecord.setAdapter(arrayAdapter);
    }
}
