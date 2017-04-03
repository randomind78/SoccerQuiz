package com.marconota.soccerquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //method to calculate quiz score
    public int calculateScore() {
        int quizScore = 0;
        //Provides values for QUESTION 1(radio button)
        int question1Value = 0;
        RadioButton italyRadioButton = (RadioButton) findViewById(R.id.italy);
        boolean italyRadioButtonIsChecked = italyRadioButton.isChecked();
        RadioButton brazilRadioButton = (RadioButton) findViewById(R.id.brazil);
        boolean brazilRadioButtonIsChecked = brazilRadioButton.isChecked();
        RadioButton germanyRadioButton = (RadioButton) findViewById(R.id.germany);
        boolean germanyRadioButtonIsChecked = germanyRadioButton.isChecked();

        // Check which radio button was clicked
        if (italyRadioButtonIsChecked) {
            question1Value = 0;


        } else if (brazilRadioButtonIsChecked) {
            question1Value = 0;


        } else if (germanyRadioButtonIsChecked) {
            question1Value = 1;

        }


        //Provides values for QUESTION2 (edit text)

        EditText editTextPlayerQuestion2 = (EditText) findViewById(R.id.question2_edittext);
        String question2TextValue = editTextPlayerQuestion2.getText().toString();
        question2TextValue = question2TextValue.trim();
        int question2Value = 0;
        if (question2TextValue.equalsIgnoreCase("Messi")) {
            question2Value = 1;

        } else {
            question2Value = 0;


        }


        //Provides values for QUESTION3 (radio button)

        int question3Value = 0;
        RadioButton riveraRadioButton = (RadioButton) findViewById(R.id.rivera);
        boolean riveraRadioButtonIsChecked = riveraRadioButton.isChecked();
        RadioButton voellerRadioButton = (RadioButton) findViewById(R.id.voeller);
        boolean voellerRadioButtonIsChecked = voellerRadioButton.isChecked();
        RadioButton linekerRadioButton = (RadioButton) findViewById(R.id.lineker);
        boolean linekerRadioButtonIsChecked = linekerRadioButton.isChecked();

        // Check which radio button was clicked
        if (riveraRadioButtonIsChecked) {
            question3Value = 0;


        } else if (voellerRadioButtonIsChecked) {
            question3Value = 0;

        } else if (linekerRadioButtonIsChecked) {
            question3Value = 1;

        }


        //Provides values for QUESTION 4 (radio button) >

        int question4Value = 0;
        RadioButton hollandRadioButton = (RadioButton) findViewById(R.id.holland);
        boolean hollandRadioButtonIsChecked = hollandRadioButton.isChecked();
        RadioButton italyRadioButtonQ4 = (RadioButton) findViewById(R.id.italy_question4);
        boolean italyRadioButtonQ4IsChecked = italyRadioButtonQ4.isChecked();
        RadioButton brazilRadioButtonQ4 = (RadioButton) findViewById(R.id.brazil_question4);
        boolean brazilRadioButtonQ4IsChecked = brazilRadioButtonQ4.isChecked();

        // Check which radio button was clicked
        if (hollandRadioButtonIsChecked) {
            question4Value = 0;

        } else if (italyRadioButtonQ4IsChecked) {
            question4Value = 0;


        } else if (brazilRadioButtonQ4IsChecked) {
            question4Value = 1;

        }


        //Provides values for QUESTION 5 (checkbox)

        int question5Value = 0;
        CheckBox schillaci_checkbox = (CheckBox) findViewById(R.id.schillaci);
        boolean schillaciValue = schillaci_checkbox.isChecked();
        CheckBox casiraghi_checkbox = (CheckBox) findViewById(R.id.casiraghi);
        boolean casiraghiValue = casiraghi_checkbox.isChecked();
        CheckBox dossena_checkbox = (CheckBox) findViewById(R.id.dossena);
        boolean dossenaValue = dossena_checkbox.isChecked();
        if (schillaciValue & casiraghiValue == false & dossenaValue == false) {
            question5Value = 1;

        } else {

            question5Value = 0;

        }


        //Provides values for QUESTION 6 (radio button)

        int question6Value = 0;
        RadioButton benzemaRadioButton = (RadioButton) findViewById(R.id.benzema);
        boolean benzemaRadioButtonIsChecked = benzemaRadioButton.isChecked();
        RadioButton ibrahimovicRadioButton = (RadioButton) findViewById(R.id.ibrahimovic);
        boolean ibrahimovicRadioButtonIsChecked = ibrahimovicRadioButton.isChecked();
        RadioButton cristianoRonaldoRadioButton = (RadioButton) findViewById(R.id.cristiano_ronaldo);
        boolean cristianoRonaldoRadioButtonIsChecked = cristianoRonaldoRadioButton.isChecked();

        // Check which radio button was clicked
        if (benzemaRadioButtonIsChecked) {
            question6Value = 0;

        } else if (ibrahimovicRadioButtonIsChecked) {
            question6Value = 0;


        } else if (cristianoRonaldoRadioButtonIsChecked) {
            question6Value = 1;

        }
// Calculate quiz score

        quizScore = question1Value + question2Value + question3Value + question4Value + question5Value + question6Value;
        return quizScore;
    }


    //Method to display a toast message with score and ability message, when submit button is clicked
    public void displayScore(View view) {
        String abilityMessage = "";
        int acceptedRepliesFinalValue = calculateScore();
        if (acceptedRepliesFinalValue == 0) {
            abilityMessage = getString(R.string.youhavetobetteryoursoccerknowledge);
        } else if (acceptedRepliesFinalValue <= 2) {
            abilityMessage = getString(R.string.youknowsomethingaboutsoccer);
        } else if (acceptedRepliesFinalValue <= 4) {
            abilityMessage = getString(R.string.prettygoodsoccerknowledge);
        } else if (acceptedRepliesFinalValue <= 6) {
            abilityMessage = getString(R.string.soccerexpert);
        }
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.acceptedreplies) + acceptedRepliesFinalValue + getString(R.string.of6);
        text = text + "\n" + abilityMessage;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


}


