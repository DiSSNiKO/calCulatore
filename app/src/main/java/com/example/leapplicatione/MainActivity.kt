package com.example.leapplicatione

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.leapplicatione.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var mainNumber : Double = 0.0
    var operatorPreviouslyClicked = false
    var tempMainNumStr = ""
    var currentOperator = ""
    val utils = utils()
    fun onAnyOperatorPressed(baton: AppCompatButton, mainNum:TextView) {
        if(operatorPreviouslyClicked == false) {
            currentOperator = baton.getText().toString()
            mainNumber = utils.mainNumToDouble(mainNum.getText().toString())
            mainNum.setText("")
            operatorPreviouslyClicked = true
        } else {
            currentOperator = baton.getText().toString()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindingShortcut()
    }
    fun bindingShortcut() {
        with(binding){
            button0.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"0",mainNum)
            }
            button1.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"1",mainNum)
            }
            button2.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"2",mainNum)
            }
            button3.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"3",mainNum)

            }
            button4.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"4",mainNum)

            }
            button5.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"5",mainNum)

            }
            button6.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"6",mainNum)

            }
            button7.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"7",mainNum)

            }
            button8.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"8",mainNum)

            }

            button9.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),"9",mainNum)

            }
            buttonfloat.setOnClickListener {
                tempMainNumStr = utils.AddToMainNumStr(mainNum.getText().toString(),".",mainNum)
            }
            buttonac.setOnClickListener {
                tempMainNumStr = utils.clearAll(mainNum)
                mainNumber = 0.0
            }
            buttonminus.setOnClickListener {
                onAnyOperatorPressed(buttonminus, mainNum)
            }
            buttonperc.setOnClickListener {
                onAnyOperatorPressed(buttonperc, mainNum)
            }
            buttonplus.setOnClickListener {
                onAnyOperatorPressed(buttonplus, mainNum)
            }
            buttondivide.setOnClickListener {
                onAnyOperatorPressed(buttondivide, mainNum)
            }
            buttonmultiply.setOnClickListener {
                onAnyOperatorPressed(buttonmultiply, mainNum)
            }
            buttonpm.setOnClickListener {
                mainNum.setText((utils.mainNumToDouble(mainNum.getText().toString())*-1).toString())
            }
            buttonequals.setOnClickListener {
                if(operatorPreviouslyClicked) {
                    val inputNum = utils.mainNumToDouble(mainNum.getText().toString())
                    mainNumber = utils.executoOperation(mainNumber, inputNum, currentOperator)
                    mainNum.setText(utils.removeDotZero(utils.scuffedRoundToTwoDecimals(mainNumber)))
                    operatorPreviouslyClicked = false
                }
            }
        }
    }
}