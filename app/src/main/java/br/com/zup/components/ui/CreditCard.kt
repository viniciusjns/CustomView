package br.com.zup.components.ui

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import br.com.zup.components.R
import kotlinx.android.synthetic.main.view_credit_card.view.*
import kotlinx.android.synthetic.main.view_credit_card.view.iv_logo
import kotlinx.android.synthetic.main.view_credit_card.view.tv_balance
import kotlinx.android.synthetic.main.view_credit_card.view.tv_credit_card_number
import kotlinx.android.synthetic.main.view_credit_card.view.tv_expiration_date
import kotlinx.android.synthetic.main.view_credit_card.view.tv_name
import kotlinx.android.synthetic.main.view_credit_card.view.tv_title_expiration_date
import kotlinx.android.synthetic.main.view_credit_card.view.tv_title_name

class CreditCard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {

    companion object{
        const val HORIZONTAL = 0
        const val VERTICAL = 1
    }

    val view: ConstraintLayout = LayoutInflater.from(context)
        .inflate(R.layout.view_credit_card, this, true) as ConstraintLayout

    private val guidelineStart = view.guideline_start.id
    private val guidelineEnd = view.guideline_end.id

    private val tvCreditCardNumber = view.tv_credit_card_number
    private val tvTitleName = view.tv_title_name
    private val tvName = view.tv_name
    private val tvTitleExpireDate = view.tv_title_expiration_date
    private val tvExpirationDate = view.tv_expiration_date
    private val tvBalance = view.tv_balance

    init {
        attrs?.apply {

            val typeArray = context.obtainStyledAttributes(this, R.styleable.CreditCard)

            setOrientation(typeArray.getInt(R.styleable.CreditCard_crc_type, HORIZONTAL))

            setTextColor(
                typeArray.getColor(
                    R.styleable.CreditCard_crc_textColor,
                    context.getCompatColor(R.color.white)
                )
            )

            setCreditCardBackground(
                typeArray.getDrawable(
                    R.styleable.CreditCard_crc_background
                ) ?: context.getCompatDrawable(R.drawable.bg_gradient_blue)
            )

            typeArray.getDrawable(R.styleable.CreditCard_crc_icon)?.let {
                setLogo(it)
            }

            typeArray.getString(R.styleable.CreditCard_crc_card_number)?.let {
                setCreditCardNumber(it)
            }

            typeArray.getString(R.styleable.CreditCard_crc_name)?.let {
                setName(it)
            }

            typeArray.getString(R.styleable.CreditCard_crc_expiration_date)?.let {
                setExpirationDate(it)
            }

            typeArray.getString(R.styleable.CreditCard_crc_balance)?.let {
                setBalance(it)
            }
            typeArray.recycle()
        }

    }

    fun setCreditCardBackground(drawable: Drawable?) {
        this.view.background = drawable
    }

    fun setOrientation(orientation: Int){
        when(orientation){
            0 -> setHorizontalOrientation()

            1 -> setVerticalOrientation()
        }
    }

    fun setTextColor(textColor: Int) {
        tvCreditCardNumber.setTextColor(textColor)
        tvTitleName.setTextColor(textColor)
        tvName.setTextColor(textColor)
        tvTitleExpireDate.setTextColor(textColor)
        tvExpirationDate.setTextColor(textColor)
        tvBalance.setTextColor(textColor)
    }

    fun setLogo(drawable: Drawable) {
        this.view.iv_logo.setImageDrawable(drawable)
    }

    fun setCreditCardNumber(creditCardNumber: String) {
        this.view.tv_credit_card_number.text = creditCardNumber
    }

    fun setName(name: String) {
        this.view.tv_name.text = name
    }

    fun setBalance(balance: String) {
        this.view.tv_balance.text = balance
    }

    fun setExpirationDate(expirationDate: String) {
        this.view.tv_expiration_date.text = expirationDate
    }

    private fun setHorizontalOrientation(){
        tvTitleName.layoutParams = tvTitleName.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            topToBottom = tvCreditCardNumber.id
            endToStart = tvTitleExpireDate.id
            bottomToTop = tvName.id
        }

        tvName.layoutParams = tvName.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            endToStart = tvExpirationDate.id
            bottomToTop = -1
            bottomToBottom = 0
        }

        tvTitleExpireDate.layoutParams = tvTitleExpireDate.getConstraintLayoutParams().apply {
            startToStart = -1
            endToEnd = guidelineEnd
            startToEnd = tvTitleName.id
            topToTop = tvTitleName.id
            topToBottom = tvCreditCardNumber.id
        }

        tvExpirationDate.layoutParams = tvExpirationDate.getConstraintLayoutParams().apply {
            startToStart = tvTitleExpireDate.id
            endToEnd = guidelineEnd
            topToBottom = tvTitleExpireDate.id
            topToTop = tvName.id
            bottomToTop = -1
        }

        tvBalance.layoutParams = tvBalance.getConstraintLayoutParams().apply {
            startToStart = -1
            endToEnd = guidelineEnd
            topToTop = 0
            bottomToBottom = -1

            setMargins(
                0,
                context.getDimen(R.dimen.default_margin).toInt(),
                0,
                0
            )
        }

    }

    private fun setVerticalOrientation(){
        tvTitleName.layoutParams =  tvTitleName.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            topToBottom = tvCreditCardNumber.id
            endToStart = -1
            bottomToTop = tvName.id
        }

        tvName.layoutParams = tvName.getConstraintLayoutParams().apply {
            endToStart = -1
            bottomToTop = tvTitleExpireDate.id
        }

        tvTitleExpireDate.layoutParams = tvTitleExpireDate.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            endToEnd = -1
            topToBottom = tvName.id
            bottomToTop = tvExpirationDate.id
        }

        tvExpirationDate.layoutParams = tvExpirationDate.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            endToEnd = -1
            topToTop = -1
            bottomToTop = tvBalance.id
        }

        tvBalance.layoutParams = tvBalance.getConstraintLayoutParams().apply {
            startToStart = guidelineStart
            endToEnd = -1
            topToTop = -1
            topToBottom = tvExpirationDate.id
            bottomToBottom = 0

            setMargins(
                0,
                context.getDimen(R.dimen.default_margin).toInt(),
                0,
                context.getDimen(R.dimen.default_margin).toInt()
            )
        }

    }

}

fun View.getConstraintLayoutParams() = this.layoutParams as ConstraintLayout.LayoutParams

fun Context.getCompatDrawable(drawable: Int) = ContextCompat.getDrawable(this, drawable)

fun Context.getCompatColor(color: Int) = ContextCompat.getColor(this, color)

fun Context.getDimen(dimen: Int) = resources.getDimension(dimen)
