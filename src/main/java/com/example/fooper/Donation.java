package com.example.fooper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Donation extends AppCompatActivity {

//    TextView Qnty,Food,Address,Name,Mobile,Subscribe,Title;
    EditText etName,etNumber,etAdress;
    Spinner SpinnerQ,SpinnerFT,SpinnerSub;
    Button Submit;
    CompoundButton SwitchSub;
    ImageView ivLocate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        etAdress = findViewById(R.id.etAdress);

        SpinnerFT = findViewById(R.id.SpinnerFT);
        SpinnerQ = findViewById(R.id.SpinnerQ);
        SpinnerSub = findViewById(R.id.SpinnerSub);

        Submit = findViewById(R.id.Submit);

        SwitchSub = findViewById(R.id.SwitchSub);

        ivLocate = findViewById(R.id.ivLocate);

        addspinneritem1(SpinnerFT);
        addspinneritem2(SpinnerQ);
        addspinneritem3(SpinnerSub);
        addlistenerSwitch(SwitchSub);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().isEmpty()||etNumber.getText().toString().isEmpty()
                   ||etAdress.getText().toString().isEmpty())
                {
                    Toast.makeText(Donation.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    writedata();
                }
            }
        });

        ivLocate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Donation.this, "Location Taken", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void writedata()
    {
        DonationData data = new DonationData(etName.getText().toString().trim(),etNumber.getText().toString().trim(),
                etAdress.getText().toString().trim(),SpinnerFT.getSelectedItem().toString().trim(),
                SpinnerQ.getSelectedItem().toString().trim());

        Map<String, Object> user;
        user = new HashMap<>();
        user.put("Name",etName.getText().toString().trim());
        user.put("Number",etNumber.getText().toString().trim());
        user.put("Adress",etAdress.getText().toString().trim());
        user.put("Food",SpinnerFT.getSelectedItem().toString().trim());
        user.put("Quant",SpinnerQ.getSelectedItem().toString().trim());

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("DonationData").setValue(user);

    }

    public void addspinneritem1(Spinner a)
    {
        List<String> list = new ArrayList<String>();
        list.add("Raw");
        list.add("Cooked");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a.setAdapter(dataAdapter);
    }

    public void addspinneritem2(Spinner a)
    {
        List<String> list = new ArrayList<String>();
        list.add("for 1-5 Adults");
        list.add("for 5-10 Adults");
        list.add("for 10-15 Adults");
        list.add("for 15+ Adults");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a.setAdapter(dataAdapter);

    }

    public void addspinneritem3(Spinner a)
    {
        List<String> list = new ArrayList<String>();
        list.add("Daily");
        list.add("Weekly");
        list.add("Every 14 Days ");
        list.add("Monthly");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        a.setAdapter(dataAdapter);

    }

    private void addlistenerSwitch(CompoundButton Switch)
    {
        Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    SpinnerSub.setVisibility(VISIBLE);

                }
                else
                {
                    SpinnerSub.setVisibility(GONE);

                }
            }
        });
    }

}
