package com.profjpbaugh.fragmentexampletoolbars

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import com.profjpbaugh.fragmentexampletoolbars.databinding.FragmentToolbarBinding
import kotlin.math.sqrt


class ToolbarFragment : Fragment(), SeekBar.OnSeekBarChangeListener {

    private lateinit var binding : FragmentToolbarBinding

    //working strings
    var buildStr1 = ""
    var buildStr2 = ""
    //Final strings
    var currNumStr = ""
    var nextNumStr = ""
    var operationSymbol = ""

    //operandCheck
    var isOperandPressed = false

    var activityCallback : ToolbarFragment.ToolbarListener? = null

    interface ToolbarListener {
        fun onButtonClick(text : String)
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)

        try {
            activityCallback = context as ToolbarListener
        }
        catch (e : ClassCastException) {
            throw ClassCastException(context.toString() + " must implement ToolbarListener")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentToolbarBinding.inflate(inflater, container, false)

       // binding.seekBar1.setOnSeekBarChangeListener(this)
        binding.btnEquals.setOnClickListener{
            val currNumInt = currNumStr.toDouble()
            //val currNumDbl = currNumStr.toDouble()
            val nextNumInt = nextNumStr.toDouble()
            var answerStr: String
            //var answer = 0


            var answerDbl: Double = when (operationSymbol) {
                "+" -> (currNumInt+nextNumInt)
                "-" -> (currNumInt-nextNumInt)
                "/" -> (currNumInt/nextNumInt)
                "X" -> (currNumInt*nextNumInt)
                "SQRT" -> (sqrt(currNumInt))
                "%" -> (currNumInt % nextNumInt)
                else ->{
                    0.0
                }
            }

            //operationSymbol = ""
            answerStr = answerDbl.toString()
            binding.tVCalc.text = answerStr

            buttonClicked(it)
            binding.tVCalc.text = ""

            isOperandPressed=false


        }
        //FIRST OF THE NUMBERS
        binding.btn0.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "0"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "0"
                binding.tVCalc.text = currNumStr
            }




            buttonClicked(it)
        }
        binding.btn1.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "1"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "1"
                binding.tVCalc.text = currNumStr
            }




            buttonClicked(it)
        }
        binding.btn2.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "2"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "2"
                binding.tVCalc.text = currNumStr
            }




            buttonClicked(it)
        }
        binding.btn3.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "3"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "3"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn4.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "4"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "4"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn5.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "5"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "5"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn6.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "6"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "6"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn7.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "7"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "7"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn8.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "8"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "8"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btn9.setOnClickListener{
            if(isOperandPressed){
                nextNumStr += "9"
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr += "9"
                binding.tVCalc.text = currNumStr
            }


            buttonClicked(it)
        }
        binding.btnModulus.setOnClickListener{
            var newStr = ""
            val currStr = binding.tVCalc.text.toString()
            newStr = if (currStr.isEmpty()) {
                ""
            } else {
                "%"
            }
            binding.tVCalc.text = newStr
            operationSymbol = "%"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed = true
        }
        binding.btnSqrt.setOnClickListener{
            var newStr = ""
            newStr = "SQRT"
            binding.tVCalc.text = newStr
            operationSymbol = "SQRT"
            nextNumStr = "0"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed=true
        }
        binding.btnDivide.setOnClickListener{
            var newStr = ""
            val currStr = binding.tVCalc.text.toString()
            newStr = if (currStr.isEmpty()) {
                ""
            } else {
                "/"
            }
            binding.tVCalc.text = newStr
            operationSymbol = "/"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed = true
        }
        binding.btnMultiply.setOnClickListener{
            var newStr = ""
            val currStr = binding.tVCalc.text.toString()
            newStr = if (currStr.isEmpty()) {
                ""
            } else {
                "X"
            }
            binding.tVCalc.text = newStr
            operationSymbol = "X"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed = true
        }
        binding.btnMinus.setOnClickListener{
            var newStr = ""
            val currStr = binding.tVCalc.text.toString()
            newStr = if (currStr.isEmpty()) {
                ""
            } else {
                "-"
            }
            binding.tVCalc.text = newStr
            operationSymbol = "-"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed = true
        }
        binding.btnAdd.setOnClickListener{
            var newStr = ""
            val currStr = binding.tVCalc.text.toString()
            newStr = if (currStr.isEmpty()) {
                ""
            } else {
                "+"
            }
            binding.tVCalc.text = newStr
            operationSymbol = "+"
            buttonClicked(it)
            binding.tVCalc.text = ""
            isOperandPressed = true
        }
        binding.btnCE.setOnClickListener{
            if(isOperandPressed) {
                nextNumStr = nextNumStr.substring(0, nextNumStr.length - 1)
                binding.tVCalc.text = nextNumStr
            }
            else{
                currNumStr = currNumStr.substring(0, currNumStr.length -1)
                binding.tVCalc.text = currNumStr
            }

            //var newStr = ""
            //val currStr = binding.tVCalc.text.toString()

            //newStr = if (currStr.isEmpty()) {
             //   ""
            //} else {
            //    currStr.substring(0, currStr.length - 1)
            //}

            buttonClicked(it)
        }
        binding.btnOnC.setOnClickListener{

            currNumStr = ""
            nextNumStr = ""
            binding.tVCalc.text = ""
            buttonClicked(it)
        }
        binding.btnPosNeg.setOnClickListener{
            if (isOperandPressed){
                if(nextNumStr[0] == '-'){
                    nextNumStr = nextNumStr.drop(1)

                }
                else{
                    val negChar = '-'
                    nextNumStr ="$negChar$nextNumStr"
                }

            }
            else{
                if(currNumStr[0] == '-'){
                    currNumStr = currNumStr.drop(1)

                }
                else{
                    val negChar = '-'
                    currNumStr ="$negChar$currNumStr"
                }
            }
        }
        return binding.root
    }


    //button clicked
    private fun buttonClicked(view : View) {
        activityCallback?.onButtonClick(binding.tVCalc.text.toString())
    }

    //------------------ Seek bar event handler methods -------------------------------//
    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        Log.i("ToolbarFragment", "Progress is " + progress)
        //seekvalue = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }

}