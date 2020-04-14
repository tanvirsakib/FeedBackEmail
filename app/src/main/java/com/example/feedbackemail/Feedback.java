package com.example.feedbackemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity implements View.OnClickListener {

    private EditText nameEditText, messageEditText;
    private Button submitButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        nameEditText = findViewById(R.id.nameEditText);
        messageEditText = findViewById(R.id.messageEditText);

        submitButton = findViewById(R.id.submitButton);
        clearButton = findViewById(R.id.clearButton);

        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (v.getId()==R.id.submitButton){
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"tanvirsakib370@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT,"Name: "+name+"\n Message: "+message);
                startActivity(Intent.createChooser(intent,"Feedback with"));

            }else if (v.getId()==R.id.clearButton){
                nameEditText.setText("");
                messageEditText.setText("");
            }

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Exception: "+e,Toast.LENGTH_SHORT).show();
        }


    }
}
