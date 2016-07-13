package net.northwestvision.hw_activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText yearsField;
    EditText adressField;
    EditText cityField;
    EditText dobField;
    Button nextBtn;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        yearsField = (EditText) findViewById(R.id.years_field);
        adressField = (EditText) findViewById(R.id.adress_field);
        cityField = (EditText) findViewById(R.id.city_field);
        dobField = (EditText) findViewById(R.id.dob_field);
        nextBtn = (Button) findViewById(R.id.next_btn);

        Intent intent2 = this.getIntent();
        name = intent2.getStringExtra("name");

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SumaryActivity.class);
                intent.putExtra("city", cityField.getText().toString());
                intent.putExtra("adress", adressField.getText().toString());
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
