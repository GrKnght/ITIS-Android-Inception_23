package com.kpfu.itis.android_inception_23.utils

import android.content.Context
import com.kpfu.itis.android_inception_23.R
import kotlin.random.Random

object QuestionGenerator {

    fun getQuestions(ctx: Context, questionCount: Int): List<String> {
        val array = ctx.resources.getStringArray(R.array.questions)

        val resultList = mutableListOf<String>()
        repeat(questionCount) {
            val newIndex = Random.nextInt(0, array.size)
            resultList.add(array[newIndex])
        }
        return resultList
    }
}