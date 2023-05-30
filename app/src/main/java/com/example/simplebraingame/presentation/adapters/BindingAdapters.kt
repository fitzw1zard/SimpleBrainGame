package com.example.simplebraingame.presentation.adapters

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.simplebraingame.R
import com.example.simplebraingame.databinding.FragmentGameBinding

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

@BindingAdapter("minCountOfRightAnswers")
fun bindMinCountOfRightAnswers(textView: TextView, count: Int) {

    textView.text = String.format(
        textView.context.getString(R.string.required_score),
        count
    )
}

@BindingAdapter("countOfRightAnswers")
fun bindCountOfRightAnswers(textView: TextView, countRight: Int) {

    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        countRight
    )
}

@BindingAdapter("minPercentOfRightAnswers")
fun bindMinPercentOfRightAnswers(textView: TextView, percent: Int) {

    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        percent
    )
}

@BindingAdapter("percentOfRightAnswers")
fun bindPercentOfRightAnswers(textView: TextView, percentRight: Int) {

    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        percentRight
    )
}

@BindingAdapter("emojiResult")
fun bindEmojiResult(imageView: ImageView, winner: Boolean) {
    imageView.setImageResource(getSmileResId(winner))
}

private fun getSmileResId(winner: Boolean): Int {
    return if (winner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}

@BindingAdapter("enoughRightAnswers")
fun bindEnoughRightAnswers(textView: TextView, enough: Boolean) {
    textView.setTextColor(getColorByState(textView.context, enough))
}

@BindingAdapter("enoughPercentRightAnswers")
fun bindEnoughPercentRightAnswers(progressBar: ProgressBar, enough: Boolean) {
    val color = getColorByState(progressBar.context, enough)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener { clickListener.onOptionClick(textView.text.toString().toInt()) }
}













