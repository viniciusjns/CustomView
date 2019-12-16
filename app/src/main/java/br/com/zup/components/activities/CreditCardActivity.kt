package br.com.zup.components.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.components.R
import br.com.zup.components.ui.CreditCard
import br.com.zup.components.ui.getCompatDrawable
import kotlinx.android.synthetic.main.activity_credit_card.*

class CreditCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit_card)

        bt_horizontal.setOnClickListener {
            credit_card.setOrientation(CreditCard.HORIZONTAL)
            getCompatDrawable(R.drawable.ic_visa)?.let {
                credit_card.setLogo(it)
            }
        }

        bt_vertical.setOnClickListener {
            credit_card.setOrientation(CreditCard.VERTICAL)
            getCompatDrawable(R.drawable.ic_mastercard)?.let {
                credit_card.setLogo(it)
            }
        }

    }
}
