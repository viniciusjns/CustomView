package br.com.zup.components.ui

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import br.com.zup.components.R
import kotlinx.android.synthetic.main.zup_edit_text.view.*

class ZupEditText : ConstraintLayout {

    private var isRequired = false
    private var isBlocked = false

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet?) {
        LayoutInflater.from(context)
            .inflate(R.layout.zup_edit_text, this, true)
        var typedArray: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.ZupEditText, 0, 0)

        zetTitle.text = typedArray.getString(R.styleable.ZupEditText_zet_title)
        zetError.text = typedArray.getString(R.styleable.ZupEditText_zet_error)

        isRequired = typedArray.getBoolean(R.styleable.ZupEditText_zet_is_required, false)
        if (isRequired)
            zetTitle.text = zetTitle.text as String? + "*"

        isBlocked = typedArray.getBoolean(R.styleable.ZupEditText_zet_is_blocked, false)
        if (isBlocked)
            zetIcon.setImageResource(R.drawable.comp_ic_lock)
    }

    fun setErrorMessage(errorMsg: String) {
        zetError.text = errorMsg
    }

    fun setIsBlocked(isBlocked: Boolean) {
        val drawable: Drawable? = ContextCompat.getDrawable(context, R.drawable.comp_ic_lock)
        if (isBlocked)
            zetIcon.setImageDrawable(drawable)
        else
            zetIcon.setImageDrawable(null)
        zetText.isEnabled = !isBlocked
        zetText.isClickable = !isBlocked
        invalidate()
//        requestLayout()
    }

    fun setIsRequired(isRequired: Boolean) {
        if (isRequired)
            zetTitle.text = zetTitle.text as String? + "*"
        else
            zetTitle.text = zetTitle.text.substring(0, zetTitle.text.length - 1)
        invalidate()
//        requestLayout()
    }
}