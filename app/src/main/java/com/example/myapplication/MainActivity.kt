package com.example.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val random = Random()
        val textFile = resources.getStringArray(R.array.array_popculture)

        //Escolher um índice aleatório da lista e exibir
        rollButton.setOnClickListener {
            textFile.forEach {
                fun rand(from: Int, to: Int) = random.nextInt(to - from + 1) + from
                randomWord.text = (textFile[rand(0, (textFile.size) - 1)])
            }


            //Abrir uma janela para adicionar novos termos
            addTermButton.setOnClickListener {
                val mDialogView = LayoutInflater.from(this).inflate(R.layout.activity_main2, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogView)
                    .setTitle("Add new entry")
                val mAlertDialog = mBuilder.show()
                //Fechar a janela
                mDialogView.cancelButton.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }
        }
    }
}