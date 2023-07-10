package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //EditText edtxtPlayerOne, edtxtPlayerTwo;
    private final List<int[]> cbnList = new ArrayList<>();
    private TextView txtNamePlayer1, txtNamePlayer2;
    private LinearLayout LNshowPlayer1, LNshowPlayer2;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    private int[] boxPositions = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int Playerturn = 1;

    private int totalSelectedBoxes = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNamePlayer1 = findViewById(R.id.txtNamePlayer1);
        txtNamePlayer2 = findViewById(R.id.txtNamePlayer2);

        LNshowPlayer1 = findViewById(R.id.LNshowPlayer1);
        LNshowPlayer2 = findViewById(R.id.LNshowPlayer2);

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);

        cbnList.add(new int[]{0, 1, 2});
        cbnList.add(new int[]{3, 4, 5});
        cbnList.add(new int[]{6, 7, 8});
        cbnList.add(new int[]{0, 3, 6});
        cbnList.add(new int[]{1, 4, 7});
        cbnList.add(new int[]{2, 5, 8});
        cbnList.add(new int[]{2, 4, 6});
        cbnList.add(new int[]{0, 4, 8});

        // get intent from AddPlayer
        final String getPlayerOneName = getIntent().getStringExtra("PlayerOne");
        final String getPlayerTwoName = getIntent().getStringExtra("PlayerTwo");

        txtNamePlayer1.setText(getPlayerOneName);
        txtNamePlayer2.setText(getPlayerTwoName);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(0)) {
                    showAction((ImageView) view, 0);

                }
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(1)) {
                    showAction((ImageView) view, 1);

                }
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(2)) {
                    showAction((ImageView) view, 2);

                }
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(3)) {
                    showAction((ImageView) view, 3);

                }
            }
        });
        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(4)) {
                    showAction((ImageView) view, 4);

                }
            }
        });
        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(5)) {
                    showAction((ImageView) view, 5);

                }
            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(6)) {
                    showAction((ImageView) view, 6);

                }
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(7)) {
                    showAction((ImageView) view, 7);
                }
            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isBoxSelected(8)) {
                    showAction((ImageView) view, 8);
                }
            }
        });
    }

    //position selected
    private boolean isBoxSelected(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }

    //show Action
    private void showAction(ImageView imgView, int selectedPosition) {
        boxPositions[selectedPosition] = Playerturn;
        if (Playerturn == -1) {
            imgView.setImageResource(R.drawable.cross);
            if (checkPlayerWin()) {
                ShowDialogWin showDialogWin = new ShowDialogWin(MainActivity.this, txtNamePlayer1.getText().toString() + " has won the match", MainActivity.this);
                showDialogWin.setCancelable(false);
                showDialogWin.show();
            } else if (totalSelectedBoxes == 9) {
                ShowDialogWin showDialogWin = new ShowDialogWin(MainActivity.this, "It is the match!", MainActivity.this);
                showDialogWin.setCancelable(false);
                showDialogWin.show();
            } else {
                ChangePlayerTurn(2);
                totalSelectedBoxes++;
            }
        } else {
            imgView.setImageResource((R.drawable.zero));
            if (checkPlayerWin()) {
                ShowDialogWin showDialogWin = new ShowDialogWin(MainActivity.this, txtNamePlayer2.getText().toString() + " has won the match", MainActivity.this);
                showDialogWin.setCancelable(false);
                showDialogWin.show();
            } else if (totalSelectedBoxes == 9) {
                ShowDialogWin showDialogWin = new ShowDialogWin(MainActivity.this, "It is the match!", MainActivity.this);
                showDialogWin.setCancelable(false);
                showDialogWin.show();
            } else {
                ChangePlayerTurn(-1);
                totalSelectedBoxes++;
            }
        }
    }

    //change playerturn
    private void ChangePlayerTurn(int currentPlayerTurn) {
        Playerturn = currentPlayerTurn;
        if (Playerturn == 1) {
            LNshowPlayer1.setBackgroundResource(R.drawable.round_back_boder); // Set the border for player 1
            LNshowPlayer2.setBackgroundResource(R.drawable.round_dark_blue); // Remove the border for player 2
        } else if (Playerturn == 2) {
            LNshowPlayer1.setBackgroundResource(R.drawable.round_back_boder); // Remove the border for player 1
            LNshowPlayer2.setBackgroundResource(R.drawable.round_dark_blue); // Set the border for player 2
        }
    }



    //check Player Win
    private boolean checkPlayerWin() {
        boolean response = false;
        for (int i = 0; i < cbnList.size(); i++) {
            final int[] cbn = cbnList.get(i);
            if (boxPositions[cbn[0]] == Playerturn && boxPositions[cbn[1]] == Playerturn && boxPositions[cbn[2]] == Playerturn) {
                response = true;
            }
        }
        return response;
    }

    public void restartMatch() {
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        Playerturn = 1;
        totalSelectedBoxes = 1;
        img1.setImageResource(R.drawable.round_dark_blue);
        img2.setImageResource(R.drawable.round_dark_blue);
        img3.setImageResource(R.drawable.round_dark_blue);
        img4.setImageResource(R.drawable.round_dark_blue);
        img5.setImageResource(R.drawable.round_dark_blue);
        img6.setImageResource(R.drawable.round_dark_blue);
        img7.setImageResource(R.drawable.round_dark_blue);
        img8.setImageResource(R.drawable.round_dark_blue);
        img9.setImageResource(R.drawable.round_dark_blue);
    }
}