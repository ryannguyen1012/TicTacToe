package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText edtxtPlayerOne = findViewById(R.id.edtxtPlayerOne);
        final EditText edtxtPlayerTwo=findViewById(R.id.edtxtPlayerTwo);
        final Button btnStartGame=findViewById(R.id.btnStartGame);

         btnStartGame.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                final String getPlayerOneName=edtxtPlayerOne.getText().toString();
                final String getPlayerTwoName=edtxtPlayerTwo.getText().toString();
                if (getPlayerOneName.isEmpty()|| getPlayerTwoName.isEmpty())
                {
                    Toast.makeText(AddPlayers.this,"Please Enter Player Name!!!",Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(AddPlayers.this,MainActivity.class);
                    intent.putExtra("PlayerOne",getPlayerOneName);
                    intent.putExtra("PlayerTwo",getPlayerTwoName);
                    startActivity(intent);
                }
             }
         });

    }
}