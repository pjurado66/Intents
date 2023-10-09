package com.pjurado.intents

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.pjurado.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)

            val startForResult =
                registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    result: ActivityResult ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val intent = result.data
                    Toast.makeText(this@MainActivity, intent?.getStringExtra(SecondActivity.EXTRA_TEXT), Toast.LENGTH_SHORT).show()
                }
            }

            button.setOnClickListener {
                val i = Intent(this@MainActivity, SecondActivity::class.java)
                i.putExtra(SecondActivity.EXTRA_TEXT, et.text.toString()) // BUNDLE
                //i.putExtra("identificado_del_bundle", et.text.toString())
                startForResult.launch(i)
                //startActivity(i)
            }

            button2.setOnClickListener {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, et.text.toString())
                sendIntent.type = "text/plain"

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(packageManager) != null) {
                    startActivity(sendIntent)
                }
            }

        }


    }
}