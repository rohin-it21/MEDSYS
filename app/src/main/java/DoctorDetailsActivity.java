package com.example.healtha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private final String[][] doctor_details1 = {
            {"Doctor Name : Ajit Saste ", "Hospital Address : Pimpri ", "Exp : 5yrs ", "Mobile No : 9898989898 ", "600"},
            {"Doctor Name : Prasad Pawar ", "Hospital Address : Nigdi ", "Exp : 15yrs ", "Mobile No : 7878787878 ", "900"},
            {"Doctor Name : Swapnil Kale ", "Hospital Address : Pune ", "Exp : 8yrs ", "Mobile No : 8898989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh ", "Hospital Address : ChinChwad ", "Exp : 6yrs ", "Mobile No : 9898000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj ", "Exp : 7yrs ", "Mobile No : 7798989898 ", "800"}
    };
    private final String[][] doctor_details2 = {
            {"Doctor Name : Ajit Saste ", "Hospital Address : Pimpri ", "Exp : 5yrs ", "Mobile No : 9898989898 ", "600"},
            {"Doctor Name : Prasad Pawar ", "Hospital Address : Nigdi ", "Exp : 15yrs ", "Mobile No : 7878787878 ", "900"},
            {"Doctor Name : Swapnil Kale ", "Hospital Address : Pune ", "Exp : 8yrs ", "Mobile No : 8898989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh ", "Hospital Address : ChinChwad ", "Exp : 6yrs ", "Mobile No : 9898000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj ", "Exp : 7yrs ", "Mobile No : 7798989898 ", "800"}
    };
    private final String[][] doctor_details3 = {
            {"Doctor Name : Ajit Saste ", "Hospital Address : Pimpri ", "Exp : 5yrs ", "Mobile No : 9898989898 ", "600"},
            {"Doctor Name : Prasad Pawar ", "Hospital Address : Nigdi ", "Exp : 15yrs ", "Mobile No : 7878787878 ", "900"},
            {"Doctor Name : Swapnil Kale ", "Hospital Address : Pune ", "Exp : 8yrs ", "Mobile No : 8898989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh ", "Hospital Address : ChinChwad ", "Exp : 6yrs ", "Mobile No : 9898000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj ", "Exp : 7yrs ", "Mobile No : 7798989898 ", "800"}
    };
    private final String[][] doctor_details4 = {
            {"Doctor Name : Ajit Saste ", "Hospital Address : Pimpri ", "Exp : 5yrs ", "Mobile No : 9898989898 ", "600"},
            {"Doctor Name : Prasad Pawar ", "Hospital Address : Nigdi ", "Exp : 15yrs ", "Mobile No : 7878787878 ", "900"},
            {"Doctor Name : Swapnil Kale ", "Hospital Address : Pune ", "Exp : 8yrs ", "Mobile No : 8898989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh ", "Hospital Address : ChinChwad ", "Exp : 6yrs ", "Mobile No : 9898000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj ", "Exp : 7yrs ", "Mobile No : 7798989898 ", "800"}
    };
    private final String[][] doctor_details5 = {
            {"Doctor Name : Ajit Saste ", "Hospital Address : Pimpri ", "Exp : 5yrs ", "Mobile No : 9898989898 ", "600"},
            {"Doctor Name : Prasad Pawar ", "Hospital Address : Nigdi ", "Exp : 15yrs ", "Mobile No : 7878787878 ", "900"},
            {"Doctor Name : Swapnil Kale ", "Hospital Address : Pune ", "Exp : 8yrs ", "Mobile No : 8898989898 ", "300"},
            {"Doctor Name : Deepak Deshmukh ", "Hospital Address : ChinChwad ", "Exp : 6yrs ", "Mobile No : 9898000000 ", "500"},
            {"Doctor Name : Ashok Panda ", "Hospital Address : Katraj ", "Exp : 7yrs ", "Mobile No : 7798989898 ", "800"}
    };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonBMCartBack);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        if (title.compareTo("Family Physicians") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("Dietician") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("Dentist") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("Surgeon") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        tv.setText(title);
        btn.setOnClickListener(v -> startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class)));
        list = new ArrayList<>();
        int i;
        for (i = 0; i < doctor_details.length; i++) {
            item = new HashMap<>();
            item.put("Line1", doctor_details[i][0]);
            item.put("Line2", doctor_details[i][1]);
            item.put("Line3", doctor_details[i][2]);
            item.put("Line4", doctor_details[i][3]);
            item.put("Line5", "Con Fees:" + doctor_details[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(list, this);
        ListView lst = findViewById(R.id.listViewBMCart);
        lst.setAdapter(sa);
        sa.notifyDataSetChanged();
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_details[i][0]);
                it.putExtra("text3", doctor_details[i][1]);
                it.putExtra("text4", doctor_details[i][3]);
                it.putExtra("text5", doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}