package assignment.android.acadgild.savesp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btnSave,btnShow;
 EditText name,age,phone,city;
    SharedPreferences sharedPreferences;
    public static final String PREFS="personPrefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave=(Button)findViewById(R.id.btnSave);
        btnShow=(Button)findViewById(R.id.btnShow);
        name=(EditText)findViewById(R.id.editTextName);
        age=(EditText)findViewById(R.id.editTextAge);
        phone=(EditText)findViewById(R.id.editTextPhone);
        city=(EditText)findViewById(R.id.editTextCity);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String person_name=name.getText().toString();
                String person_age=age.getText().toString();
                int p_age=(Integer.parseInt(person_age));
                String person_phone=phone.getText().toString();
                int p_phone=(Integer.parseInt(person_phone));
                String p_city=city.getText().toString();
                 sharedPreferences=getSharedPreferences("PREFS",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("Name",person_name);
                editor.putInt("Age",p_age);
                editor.putInt("Phone",p_phone);
                editor.putString("city",p_city);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Successfully saved", Toast.LENGTH_SHORT).show();
            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p_Name=sharedPreferences.getString("Name",null);
                int p_Age=sharedPreferences.getInt("Age",0);
                int p_Phone=sharedPreferences.getInt("Phone",0);
                String p_City=sharedPreferences.getString("city",null);
                Toast.makeText(getApplicationContext(), "Name: "+p_Name+"\n"+"Age: "+p_Age+"\n"+"Phone: "+p_Phone+"\n"+"City: "+p_City, Toast.LENGTH_LONG).show();

            }
        });
    }
}
