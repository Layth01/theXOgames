package com.example.layth.thexogame

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    protected fun buclicked(view: View) {
        val buselected: Button = view as Button
        var cellID = 0
        when (buselected.id) {
            R.id.button -> cellID = 1
            R.id.button1 -> cellID = 2
            R.id.buton2 -> cellID = 3
            R.id.button3 -> cellID = 4
            R.id.button4 -> cellID = 5
            R.id.button5 -> cellID = 6
            R.id.button6 -> cellID = 7
            R.id.button7 -> cellID = 8
            R.id.button8 -> cellID = 9
        }
        Toast.makeText(this, "CellID is " + cellID, Toast.LENGTH_SHORT).show()
        playGame(cellID, buselected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var ActivePlayer = 1

    fun playGame(cellID: Int, buselected: Button) {
        if (ActivePlayer == 1) {
            buselected.text = "X"
            buselected.setBackgroundResource(R.color.blue)
            player1.add(cellID)
            ActivePlayer = 2
            AutoPlay()
        } else {
            buselected.text = "0"
            buselected.setBackgroundResource(R.color.darkgreen)
            player2.add(cellID)
            ActivePlayer = 1

        }


        buselected.isEnabled = false
        checkwinner()
    }

    fun checkwinner() {
        var winner = -1
        //row=1

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        //colomun
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner != -1 )
        {
            if (winner==1)
            {
                Toast.makeText(this, "The winner is player 1", Toast.LENGTH_LONG).show()
            }
            if (winner==2)
            {
                Toast.makeText(this, "The winner is player 2", Toast.LENGTH_LONG).show()
            }

        }


    }
    fun AutoPlay()
    {
        var emptyCell=ArrayList<Int>()
        for (cellID in 1..9)
        {
            if (!(player1.contains(cellID) || player2.contains(cellID)))
            {
                emptyCell.add(cellID)
            }
        }
        var r=Random()
        val randIndex=r.nextInt(emptyCell.size-0)+0
        val cellID= emptyCell.get(randIndex)
        var buSelect:Button?
        when(cellID) {
            1 -> buSelect = button
            2 -> buSelect = button1
            3 -> buSelect = buton2
            4 -> buSelect = button3
            5 -> buSelect = button4
            6 -> buSelect = button5
            7 -> buSelect = button7
            8 -> buSelect = button8
            else
            ->
            {
                buSelect = button
            }
        }
        playGame(cellID,buSelect)


    }
}


