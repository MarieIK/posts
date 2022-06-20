import java.time.LocalDateTime

data class Post(
    val id: Int = 0,
    val ownerId: Long = 0,
    val fromId: Long = 0,
    val createdBy: Int = 0,
    val date: LocalDateTime,
    val text: String = String(),
    val replyOwnerId: Long = 1,
    val replyPostId: Long = 1,
    val friendsOnly: Boolean = true,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
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