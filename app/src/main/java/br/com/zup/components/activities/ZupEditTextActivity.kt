package br.com.zup.components.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.components.R
import kotlinx.android.synthetic.main.activity_zup_edit_text.*
import kotlinx.android.synthetic.main.zup_edit_text.view.*

class ZupEditTextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zup_edit_text)

        swError.setOnCheckedChangeListener { _, isChecked ->
            zet.setErrorMessage(if (isChecked) "Campo obrigatório" else "")
        }

        swBlocked.setOnCheckedChangeListener { _, isChecked ->
            zet.setIsBlocked(isChecked)
        }

        swRequired.setOnCheckedChangeListener { _, isChecked ->
            zet.setIsRequired(isChecked)
        }

        btGetText.setOnClickListener {
            tvGetText.text = zet.zetText.text
        }
    }
}
