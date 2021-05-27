package sg.edu.ep.c346.id20029318.democontextmenutranslation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedTxt;
    TextView tvTranslatedTxt2;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    tvTranslatedTxt = findViewById(R.id.tvTranslatedTxt);
    tvTranslatedTxt2 = findViewById(R.id.tvTranslatedTxt2);
    registerForContextMenu(tvTranslatedTxt);
    registerForContextMenu(tvTranslatedTxt2);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"English");
        menu.add(0,1,1,"Italian");

        if (v == tvTranslatedTxt){
            wordClicked = "hello";
        }
        else if (v == tvTranslatedTxt2) {
            wordClicked = "bye";
        }
    }

    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("hello")) {
            if(item.getItemId() == 0) {
                tvTranslatedTxt.setText("Hello");
                return true; //success
            }
            else if (item.getItemId() == 1) {
                tvTranslatedTxt.setText("Ciao");
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("bye")){
            if (item.getItemId()==0){
                tvTranslatedTxt2.setText("Bye");
            }
            else if (item.getItemId() == 1) {
                tvTranslatedTxt2.setText("Addio");
            }
        }
        if(item.getItemId()==0) { //check whether the selected menu item ID is 0
            //code for action
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();

            return true; //menu item successfully handled
        }
        else if(item.getItemId()==1) { //check if the selected menu item ID is 1
            //code for action
            Toast.makeText(MainActivity.this, "Italian is chosen", Toast.LENGTH_SHORT).show();

            return true;  //menu item successfully handled
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation


    }




}

