package com.kpfu.itis.android_inception_23.utils

import com.kpfu.itis.android_inception_23.R
import com.kpfu.itis.android_inception_23.model.NewsDataModel

object NewsDataRepository {

    private val newsList = mutableListOf<NewsDataModel>()

    init {
        val list = listOf(
            NewsDataModel(
                newsId = "nf_1",
                newsTitle = "Заседание общественной палаты",
                newsDetails = "Вчера прошло мальдивское заседание общественной палаты на берегу какого-то там залива",
                newsImage = R.drawable.first_image,
            ),
            NewsDataModel(
                newsId = "nf_2",
                newsTitle = "В России готовятся к празднованию Хэллоуина",
                newsDetails = "Хэллоуин - cовременный международный праздник, восходящий к традициям древних кельтов " +
                        "Ирландии и Шотландии, история которого началась на территории современных Великобритании " +
                        "и Северной Ирландии",
                newsImage = R.drawable.halloween_image,
            ),
            NewsDataModel(
                newsId = "nf_3",
                newsTitle = "Дополнительный выходной в Татарстане",
                newsDetails = "6 ноября мы отмечаем знаменательный праздник для нашей республики – День принятия " +
                        "Конституции Республики Татарстан",
                newsImage = R.drawable.kazan_image,
            ),
            NewsDataModel(
                newsId = "nf_4",
                newsTitle = "Рассматривается вопрос открытия центра русского языка в Китае при поддержке КФУ",
                newsDetails = "Сегодня представители КФУ во главе с проректором по внешним связям Тимирханом Алишевым " +
                        "посетили два университета в провинции Гуандун. В состав делегации вошли также директор " +
                        "Института информационных технологий и интеллектуальных систем Михаил Абрамский, " +
                        "директор Института дизайна и пространственных искусств Карина Набиуллина, заместитель " +
                        "директора по международной деятельности Института международных отношений Альбина Имамутдинова, " +
                        "представители подготовительного факультета КФУ.",
                newsImage = R.drawable.kfu_image,
            ),
        )
        newsList.addAll(list)
    }

    fun addItem() {
        this.newsList.add(
            2, NewsDataModel(
                newsId = "nf_${this.newsList.size + 1}",
                newsTitle = "Заседание общественной палаты",
                newsDetails = "Вчера прошло мальдивское заседание общественной палаты на берегу какого-то там залива",
                newsImage = R.drawable.first_image,
            )
        )
    }

    fun getNewsList(): List<NewsDataModel> = newsList
}