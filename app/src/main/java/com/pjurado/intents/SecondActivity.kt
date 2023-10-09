package com.pjurado.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pjurado.intents.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_TEXT = "texto"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater).apply {
            setContentView(root)
            textView.text = intent.getStringExtra(EXTRA_TEXT)

            intent.extras?.let {
                textView.text = it.getString(Intent.EXTRA_TEXT)
            }


            //textView.text = intent.getStringExtra("identificador_del_bundle")
            volver.setOnClickListener {
                setResult(RESULT_OK, intent.putExtra(EXTRA_TEXT, "Vuelta"))
                finish()
            }

        }

    }
}