import java.time.LocalDateTime

data class Post(
    val id: Long = 0,
    val ownerId: Long = 0,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String? = null,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes = Likes(),
    val reposts: Reposts? = null,
    val views: Views = Views(),
    val postType: PostType = PostType.SUGGEST,
    val attachment: Array<Attachment> = emptyArray()
)

data class Comments(
    var count: Long = 5,
    val canEdit: Boolean = true,
)

data class Copyright(
    val id: Long = 0,
    val link: String = "",
)

data class Likes(
    var count: Long = 90,
    val userLikes: Boolean = true,
)

data class Reposts(
    var count: Long = 100,
    val userReposted: Boolean = true
)

data class Views(var count: Long = 150)

enum class PostType {
    COPY,
    POSTPONE,
    SUGGEST
}