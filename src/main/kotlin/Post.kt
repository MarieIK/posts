import java.time.LocalDateTime

data class Post(
    val id: Int = 0,
    val ownerId: Long = 0,
    val fromId: Long = 0,
    val createdBy: Int = 0,
    val date: LocalDateTime = LocalDateTime.now(),
    val text: String? = null,
    val replyOwnerId: Long = 1,
    val replyPostId: Long = 1,
    val friendsOnly: Boolean = true,
    val comments: Comments? = null,
    val copyright: Copyright? = null,
    val likes: Likes = Likes(),
    val reposts: Reposts? = null,
    val views: Views = Views(),
    val postType: PostType,
    val signerId: Long = 0,
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned: Boolean = true,
    val markedAsAds: Boolean = true,
    val isFavourite: Boolean = true,
    val donut: Donut,
    val postponedId: Int = 1
)

data class Comments(
    var count: Long = 5,
    val canEdit: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id: Long = 0,
    val link: String = "",
    val name: String = "",
    val type: String = ""
)

data class Likes(
    var count: Long = 90,
    val userLikes: Boolean = true,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(
    var count: Long = 100,
    val userReposted: Boolean = true
)

data class Views(var count: Long = 150)

enum class PostType {
    POST,
    COPY,
    REPLY,
    POSTPONE,
    SUGGEST
}

data class Donut(
    val isDonut: Boolean = true,
    var paidDuration: Long = 10,
    val placeholder: Placeholder = Placeholder(),
    val canPublishFreeCopy: Boolean = true,
    var editMode: DonutEditMode
)

data class Placeholder(val someText: String = "Some placeholder")

enum class DonutEditMode {
    ALL,
    DURATION
}