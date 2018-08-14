package my.edu.utem.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   TextView result;
   int random;
   int numberOfTries;
   boolean gameOn;
   Button Reset_Button,Click_Button;

int rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=findViewById(R.id.textView_hello);
        Reset_Button=findViewById(R.id.buttonreset);
        Click_Button=findViewById(R.id.button_random);
        InitializeGame();

    }

    public void InitializeGame() {
        rand = (int)Math.ceil(Math.random() *100);
        numberOfTries=3;
        gameOn=true;
        result.setText("");
        Reset_Button.setVisibility(View.GONE);
        Click_Button.setVisibility(View.VISIBLE);

    }

    public void button_click(View view) {
        if (result.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
        }
        random=Integer.parseInt(result.getText().toString());

        Log.d("debug","random");
        numberOfTries--;
        if (random<rand) {

            Toast.makeText(MainActivity.this, "number too small", Toast.LENGTH_LONG).show();
        }
        else if (random > rand) {
            Toast.makeText(MainActivity.this, "number too big", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(MainActivity.this, "You Win", Toast.LENGTH_LONG).show();
            gameOn=false;
        }
        if (numberOfTries == 0 && gameOn)
        {
            result.setText("Sorry, Do another round");
            gameOn=false;
            Reset_Button.setVisibility(View.VISIBLE);
            Click_Button.setVisibility(View.GONE);
        }

    }

    public void buttonreset(View view) {
        InitializeGame();
    }
}
