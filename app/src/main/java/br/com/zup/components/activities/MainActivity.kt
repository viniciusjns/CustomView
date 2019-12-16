package br.com.zup.components.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.components.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_zup_edit_text.setOnClickListener {
            startActivity(Intent(this, ZupEditTextActivity::class.java))
        }

       bt_credit_card.setOnClickListener {
           startActivity(Intent(this, CreditCardActivity::class.java))
       }
    }
}
