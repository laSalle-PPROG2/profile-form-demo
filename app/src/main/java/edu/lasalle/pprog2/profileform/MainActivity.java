package edu.lasalle.pprog2.profileform;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private EditText name;
    private EditText surname;
    private RadioButton male;
    private RadioButton female;
    private RadioButton other;
    private Spinner country;
    private SeekBar volume;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name_edittext);
        surname = (EditText) findViewById(R.id.surname_edittext);
        male = (RadioButton) findViewById(R.id.male_radiobutton);
        female = (RadioButton) findViewById(R.id.female_radiobutton);
        other = (RadioButton) findViewById(R.id.other_gender_radiobutton);
        country = (Spinner) findViewById(R.id.country_spinner);
        volume = (SeekBar) findViewById(R.id.volume_seekBar);
    }

    public void onButtonSaveClick(View view) {
        Log.d(TAG, "Button clicked");
        Log.d(TAG, formDataToString());
    }

    private String formDataToString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ").append(name.getText().toString()).append('\n');
        builder.append("Surname: ").append(surname.getText().toString()).append('\n');
        builder.append("Gender: ").append(selectedGender()).append('\n');
        builder.append("Country: ").append(country.getSelectedItem()).append('\n');
        builder.append("Volume: ").append(volume.getProgress()).append("%\n");

        return builder.toString();
    }

    private String selectedGender() {
        if (male.isChecked()) {
            return male.getText().toString();
        } else if (female.isChecked()) {
            return female.getText().toString();
        } else {
            return other.getText().toString();
        }
    }
}
