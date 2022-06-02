package com.cesc.core.model

data class HomeBanner(
    val id: Int,
    val desc: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String,
    val imagePath: String
) : java.io.Serializable

data class HomeArticleInfo(
    val datas: List<Article>,
    val curPage: Int = 0,
    val pageCount: Int = 0
)

data class SquareArticleInfo(
    val datas: List<Article>,
    val curPage: Int = 0,
    val pageCount: Int = 0
)

data class Article(
    val author: String? = "",
    val canEdit: Boolean = false,
    val chapterName: String? = "",
    val courseId: Int,
    val desc: String? = "",
    val id: Int,
    val link: String? = "",
    val niceDate: String? = "",
    val niceShareDate: String? = "",
    val publishTime: Long,
    val superChapterId: Int,
    val superChapterName: String? = "",
    val title: String? = "",
    val visible: Int,
    val userId: Int,
    val collect : Boolean = false,
    val tags: List<Tag>?,
    var top : String,
    val shareUser :String? = "",
    val fresh: Boolean,

    ) : java.io.Serializable {
    data class Tag(
        val name: String? = "",
        val url: String? = ""

    ) : java.io.Serializable
}
