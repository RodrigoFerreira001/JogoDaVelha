package com.flavinhaerodrigo.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var player1Score = 0
        var player2Score = 0
        var player1Character = Random.nextInt(0, 2)
        var player2Character = if (player1Character == 0) 1 else 0
        var turn = Random.nextInt(0, 2)
        var board = mutableListOf(
            mutableListOf(-1, -1, -1),
            mutableListOf(-1, -1, -1),
            mutableListOf(-1, -1, -1)
        )
        var isEndOfTheGame = false
        var winner = -1

        clearBoard()

        btn0_0.setOnClickListener {
            swapImage(btn0_0,turn)

            board[0][0] = turn

            if ((board[0][1] == turn && board[0][2] == turn)
                || (board[1][1] == turn && board[2][2] == turn)
                || (board[1][0] == turn && board[2][0] == turn)) {

                isEndOfTheGame = true
                winner = turn
            }

            turn = if(turn == 0) 1 else 0
            btn0_0.isClickable = false
        }

        btn0_1.setOnClickListener {
            swapImage(btn0_1,turn)

            board[0][1] = turn

            if ((board[0][0] == turn && board[0][2] == turn)
                || (board[1][1] == turn && board[2][1] == turn)) {

                isEndOfTheGame = true
                winner = turn
            }

            turn = if(turn == 0) 1 else 0
            btn0_1.isClickable = false
        }

        btn0_2.setOnClickListener {
            swapImage(btn0_2, turn)
            board[0][2] = turn

            if ((board[0][0] == turn && board[0][1] == turn)
                || (board[1][1] == turn && board[2][0] == turn)
                || (board[1][2] == turn && board[2][2] == turn)) {

                isEndOfTheGame = true
                winner = turn
            }

            turn = if(turn == 0) 1 else 0
            btn0_2.isClickable = false
        }

        btn1_0.setOnClickListener {
            swapImage(btn1_0, turn)
            board[1][0] = turn

            if ((board[0][0] == turn && board[2][0] == turn)
                || (board[1][1] == turn && board[1][0] == turn)) {

                isEndOfTheGame = true
                winner = turn
            }

            turn = if(turn == 0) 1 else 0
            btn1_0.isClickable = false
        }

        btn1_1.setOnClickListener {
            swapImage(btn1_1, turn)
            board[1][1] = turn

            if ((board[0][1] == turn && board[2][1] == turn)
                || (board[1][0] == turn && board[1][2] == turn)
                || (board[1][2] == turn && board[2][2] == turn)) {

                isEndOfTheGame = true
                winner = turn
            }

            turn = if(turn == 0) 1 else 0
            btn0_2.isClickable = false
        }

    }

    fun clearBoard() {
        btn0_0.setImageDrawable(null)
        btn0_1.setImageDrawable(null)
        btn0_2.setImageDrawable(null)
        btn1_0.setImageDrawable(null)
        btn1_1.setImageDrawable(null)
        btn1_2.setImageDrawable(null)
        btn2_0.setImageDrawable(null)
        btn2_1.setImageDrawable(null)
        btn2_2.setImageDrawable(null)
    }

    fun swapImage(btn: ImageView, turn: Int){
        if (turn == 0) {
            btn.setImageDrawable(getDrawable(R.drawable.outline_brightness_1_black_48))
        } else {
            btn.setImageDrawable(getDrawable(R.drawable.outline_clear_black_48))
        }
    }
}
