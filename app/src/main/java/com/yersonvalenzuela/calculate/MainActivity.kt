package com.yersonvalenzuela.calculate

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var numero1:Double = 0.0;
    var oper:Int=0
    lateinit var tv_num1:TextView
    lateinit var tv_num2:TextView


    // 0->nada 1 ->suma 2 ->resta
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tv_num1=findViewById(R.id.tv_num1)
        tv_num2=findViewById(R.id.tv_num2)
         val buttonsalir: Button=findViewById(R.id.buttonsalir)
         val button: Button = findViewById(R.id.buttonreset)
        val button14: Button = findViewById(R.id.button14)

        button14.setOnClickListener{
            //presionado el igual

            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp:Double = 0.0
            when(oper){
                1-> resp = numero1 + numero2
                2-> resp = numero1 - numero2
                3-> resp = numero1 * numero2
                4-> resp = numero1 / numero2
            }
           tv_num2.setText(resp.toString())
            tv_num1.setText("")


        }
        button.setOnClickListener{
            //reseteando

            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }
        // referenciamos la variable
       buttonsalir.setOnClickListener{
           //saliendo de app
           finishAffinity();
       }


    }
 fun salir(view: View){
     finishAffinity();
 }

  fun presionarDigito(view:View){
      val tv_num2:TextView=findViewById(R.id.tv_num2)
      var num2: String = tv_num2.text.toString()

      when(view.id){
          R.id.button0 ->tv_num2.setText(num2 +"0")
          R.id.button1 ->tv_num2.setText(num2 +"1")
          R.id.button2 ->tv_num2.setText(num2 +"2")
          R.id.button3 ->tv_num2.setText(num2 +"3")
          R.id.button4 ->tv_num2.setText(num2 +"4")
          R.id.button5 ->tv_num2.setText(num2 +"5")
          R.id.button6 ->tv_num2.setText(num2 +"6")
          R.id.button7 ->tv_num2.setText(num2 +"7")
          R.id.button8 ->tv_num2.setText(num2 +"8")
          R.id.button9 ->tv_num2.setText(num2 +"9")
         // R.id.button10 ->tv_num2.setText(num2 +"+")
         // R.id.button11 ->tv_num2.setText(num2 +"-")
         // R.id.button12 ->tv_num2.setText(num2 +"*")
          R.id.button13 ->tv_num2.setText(num2 +".")
        //  R.id.button14 ->tv_num2.setText(num2 +"=")
          // R.id.button15 ->tv_num2.setText(num2 +"/")

      }
  }

    fun clickOperacion(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text:String= tv_num2.text.toString()
        tv_num2.setText("")
        when(view.id){
            R.id.button10 ->{
                tv_num1.setText(num2_text+"+")
                oper = 1
            }
            R.id.button11 ->{
                tv_num1.setText(num2_text+"-")
                oper = 2
            }
            R.id.button12 ->{
                tv_num1.setText(num2_text+"*")
                oper = 3
            }
            R.id.button15 ->{
                tv_num1.setText(num2_text+"/")
                oper = 4
            }

        }

    }



}