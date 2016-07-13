package net.northwestvision.hw_activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SumaryActivity extends AppCompatActivity {
    TextView adressTxt;
    Button showMapBtn;
    private String newCity;
    private String newAddress;
    private String newName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumary);
        adressTxt = (TextView) findViewById(R.id.adress_txt);
        showMapBtn = (Button) findViewById(R.id.showmap_btn);
        Intent intent = this.getIntent();
        newCity = intent.getStringExtra("city");
        newAddress = intent.getStringExtra("adress");
        newName = intent.getStringExtra("name");
        adressTxt.setText(String.valueOf(newName) + ", " + String.valueOf(newAddress)  + ", Град " + String.valueOf(newCity));
        showMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://maps.google.com/maps?z=12&t=m&q=loc:" + newCity + "+" + newAddress));
                startActivity(intent);
            }
        });
    }
}
