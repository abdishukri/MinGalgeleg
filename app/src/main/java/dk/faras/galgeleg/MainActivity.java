package dk.faras.galgeleg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

private Button spilbtn, hjælpbtn,indstillingbtn;






    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    spilbtn=(Button) findViewById(R.id.knap2);
        spilbtn.setOnClickListener(this);
    hjælpbtn= (Button) findViewById(R.id.knap1) ;
    hjælpbtn.setOnClickListener(this);
    indstillingbtn=(Button) findViewById(R.id.knap3) ;
    indstillingbtn.setOnClickListener(this);



    }


    @Override

    public void onClick(View view) {

    if (spilbtn==view){
        Intent intent= new Intent(this,SpilActivity.class);
        startActivity(intent);
    }

    if (hjælpbtn==view){
        Intent intent= new Intent(this,HjaelpActivity.class);
        startActivity(intent);

    }
    if (indstillingbtn==view){
        Intent intent= new Intent(this,IndstillingerActivity.class);
        startActivity(intent);
    }


    }
}