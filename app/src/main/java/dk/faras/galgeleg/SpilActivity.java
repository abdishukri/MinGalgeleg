package dk.faras.galgeleg;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SpilActivity extends AppCompatActivity implements View.OnClickListener{

        Galgelogik spil= new Galgelogik();

    private TextView ordet, brugtBogstaver ;
    private EditText editText;
    private Button gætbtn;
    private ImageView imageView;
    private int[] image = new int[]{R.drawable.galge, R.drawable.forkert1,
            R.drawable.forkert2, R.drawable.forkert3, R.drawable.forkert4,
            R.drawable.forkert5, R.drawable.forkert6};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spil);




        ordet= (TextView) findViewById(R.id.textView);
        ordet.setText(spil.getSynligtOrd());


        editText=(EditText) findViewById(R.id.editText) ;



        gætbtn = (Button) findViewById(R.id.Gæt);
        gætbtn.setOnClickListener(this);


        brugtBogstaver = (TextView) findViewById(R.id.textView2);



        imageView = (ImageView) findViewById(R.id.imageView);



    }





    @Override
    public void onClick(View view) {



            if (view == gætbtn) {
                String gæt = editText.getText().toString().toLowerCase();
                spil.gætBogstav(gæt);
                ordet.setText(spil.getSynligtOrd());
                spil.getAntalForkerteBogstaver();
                brugtBogstaver.setText(spil.getBrugteBogstaver().toString());
                editText.setText("");
            }
            if (!spil.erSidsteBogstavKorrekt() && spil.getAntalForkerteBogstaver() < 7) {

                imageView.setImageResource(image[spil.getAntalForkerteBogstaver()]);
            }
            if (spil.erSpilletSlut()) {
                if (spil.erSpilletTabt()) {
                    ordet.setText("SPILLET ER TABT");
                } else {
                    ordet.setText("SPILLET ER VUNDET");
                }
            }

        }





    }
