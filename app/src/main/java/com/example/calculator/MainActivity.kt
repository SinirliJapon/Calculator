package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etResult: TextView
    private lateinit var operation: TextView
    private var num1 = 0.0
    private var num2 = 0.0
    private var operator: Char = ' '

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        operation = findViewById(R.id.Operation)
        etResult = findViewById(R.id.Result)
    }

    @SuppressLint("SetTextI18n")
    fun buttonClick(view: View) {
        val button = view as Button
        when (button.id) {
            R.id.btn0 -> etResult.append("0")
            R.id.btn1 -> etResult.append("1")
            R.id.btn2 -> etResult.append("2")
            R.id.btn3 -> etResult.append("3")
            R.id.btn4 -> etResult.append("4")
            R.id.btn5 -> etResult.append("5")
            R.id.btn6 -> etResult.append("6")
            R.id.btn7 -> etResult.append("7")
            R.id.btn8 -> etResult.append("8")
            R.id.btn9 -> etResult.append("9")
            R.id.btnDot -> etResult.append(".")
            R.id.btnPlus -> {
                num1 = etResult.text.toString().toDouble()
                operator = '+'
                operation.text = "$num1 +"
                etResult.text = ""
            }
            R.id.btnMinus -> {
                num1 = etResult.text.toString().toDouble()
                operator = '-'
                operation.text = "$num1 -"
                etResult.text = ""
            }
            R.id.btnMultiply -> {
                num1 = etResult.text.toString().toDouble()
                operator = '*'
                operation.text = "$num1 x"
                etResult.text = ""
            }
            R.id.btnDivide -> {
                num1 = etResult.text.toString().toDouble()
                operator = '/'
                operation.text = "$num1 /"
                etResult.text = ""
            }
            R.id.btnReset -> {
                etResult.text = ""
                operation.text = ""
                num1 = 0.0
                num2 = 0.0
                operator = ' '
            }
            R.id.btnClear -> {
                val currentText = etResult.text.toString()
                if (currentText.isNotEmpty()) {
                    etResult.text = currentText.substring(0, currentText.length - 1)
                }
            }
            R.id.btnEquals -> {
                num2 = etResult.text.toString().toDouble()

                when (operator) {
                    '+' -> etResult.text = (num1 + num2).toString()
                    '-' -> etResult.text = (num1 - num2).toString()
                    '*' -> etResult.text = (num1 * num2).toString()
                    '/' -> {
                        if (num2 != 0.0) {
                            etResult.text = (num1 / num2).toString()
                        } else {
                            etResult.text = "Error"
                            operation.text = "Cannot divide by 0"
                        }
                    }
                    else -> {
                        // Handle other cases if needed
                    }
                }

                // Reset the operator and operands after calculation
                operator = ' '
                num1 = 0.0
                num2 = 0.0
                operation.text = ""
            }
        }
    }
}
