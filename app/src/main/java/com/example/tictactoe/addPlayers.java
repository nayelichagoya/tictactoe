package com.example.tictactoe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class addPlayers extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        //start button
        startGameButton.setOnClickListener(new View.OnClickListener()
        {
            private Context addPlayers;

            @Override
            public void onClick(View view) {
                String getPlayerOneName = playerOne.getText().toString();
                String getPlayerTwoName = playerTwo.getText().toString();

//if statement
                if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty())
                {
                    Toast.makeText(addPlayers,
                            "Please enter player name",
                            Toast.LENGTH_SHORT).show();
                }

//else statement
                else
                {
                    Intent intent = new Intent (addPlayers, MainActivity.class);
                    intent.putExtra("playerOne", getPlayerOneName);
                    intent.putExtra ("playerTwo", getPlayerTwoName);
                    startActivity(intent);
                }
            }
        });

    } //end of void

} // end of class
