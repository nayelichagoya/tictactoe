package com.example.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class ResultDialog extends Dialog
{

    public ResultDialog(@NonNull Context, MainActivity activity, String message, MainActivity mainActivity, Bundle savedInstanceState, OnCancelListener context, Context Context)
    {
        super(Context);
        // this.message = message;
        //this.mainActivity = mainActivity;


        private void onCreate Object Bundle;
        {

                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_result_dialog);

                TextView messageText = findViewById(R.id.messageText);
                Button startAgainButton = findViewById(R.id.startGameButton);

                messageText.setText(message);

                startAgainButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {

                    }
                });

        } // end of result dialog
    }
} //end of public class


