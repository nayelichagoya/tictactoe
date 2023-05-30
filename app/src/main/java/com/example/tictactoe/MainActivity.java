package com.example.tictactoe;

import com.example.tictactoe.databinding.ActivityMainBinding;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    //variables
    ActivityMainBinding binding;
    private final ArrayList<int[]> combinationList = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0}; //9 zeros
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;
    private DialogInterface.OnCancelListener context;

    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        combinationList.add(new int[] {0,1,2});
        combinationList.add(new int[] {3,4,5});
        combinationList.add(new int[] {6,7,8});
        combinationList.add(new int[] {0,3,6});
        combinationList.add(new int[] {1,4,7});
        combinationList.add(new int[] {2,5,8});
        combinationList.add(new int[] {2,4,6});
        combinationList.add(new int[] {0,4,8});

        String getPlayerOneName= getIntent().getStringExtra("playerOne");
        String getPlayerTwoName= getIntent().getStringExtra("playerTwo");

        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(0))
                {
                    performAction((ImageView) view,0, savedInstanceState);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(1))
                {
                    performAction((ImageView) view,1, savedInstanceState);
                }
            }
        });

        binding.image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(2))
                {
                    performAction((ImageView) view,2, savedInstanceState);
                }
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(3))
                {
                    performAction((ImageView) view,3, savedInstanceState);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(4))
                {
                    performAction((ImageView) view,5, savedInstanceState);
                }
            }
        });

        binding.image6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(5))
                {
                    performAction((ImageView) view,5, savedInstanceState);
                }
            }
        });

        binding.image7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(6))
                {
                    performAction((ImageView) view,6, savedInstanceState);
                }
            }
        });

        binding.image8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(7))
                {
                    performAction((ImageView) view,7, savedInstanceState);
                }
            }
        });

        binding.image9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                if(isBoxSelectable(8))
                {
                    performAction((ImageView) view,8, savedInstanceState);
                }
            }
        });

    }

    private void performAction(ImageView imageView, int selectedBoxPosition, Bundle savedInstanceState)
    {
        boxPositions [selectedBoxPosition] = playerTurn;

        // declaring winner for player 2
        MainActivity MainActivity = null;
        if(playerTurn == 1)
        {
            imageView.setImageResource(R.drawable.ic_baseline_cancel_24);
            if (checkResults())
            {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()
                        + " is a Winner! YIPPE", MainActivity.this, savedInstanceState, context, Context);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else if (totalSelectedBoxes == 9)
            {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity, savedInstanceState, context, Context);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else
            {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } //end of if player turn


        //declaring winner for player 2
        else
        {
            imageView.setImageResource (R.drawable.ic_baseline_circle_24);
            if(checkResults())
            {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, binding.playerOneName.getText().toString()
                        + " is a Winner! YIPPE", MainActivity.this, savedInstanceState, context, Context);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }

            else if(totalSelectedBoxes == 9)
            {
                ResultDialog resultDialog = new ResultDialog(MainActivity.this, "Match Draw", MainActivity, savedInstanceState, context, Context);
                resultDialog.setCancelable(false);
                resultDialog.show();
            }
            else
            {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }
    }


    //switching players
    private void changePlayerTurn (int currentPlayerTurn)
    {
        playerTurn = currentPlayerTurn;

//if statement
        if (playerTurn == 1)
        {
            binding.playerOneLayout.setBackgroundResource (R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource (R.drawable.white_box);
        }

//else statement
        else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }
    // checking results
    private boolean checkResults()
    {
        boolean response = false;

        for (int i = 0; i < combinationList.size(); i++)
        {
            final int[] combination = combinationList.get(i);

            if (boxPositions[combination[0]] == playerTurn && boxPositions[combination[1]] == playerTurn &&
                    boxPositions[combination[2]] == playerTurn)
            {
                response = true;
            }
        } // end of for loop
        return response;
    } //end of boolean

    //clicking boxes
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;

        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    // white boxes
    public void restartHatch()
    {
        boxPositions = new int[] {0,0,0,0,0,0,0,0,0}; //9 zero
        playerTurn = 1;
        totalSelectedBoxes = 1;

        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);

    }

    public void restartMatch()
    {

    }
} //end of public class


