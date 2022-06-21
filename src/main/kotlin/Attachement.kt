import java.time.LocalDateTime

data class Audio(
    val id: Long,
    val ownerId: Long,
    val artist: String,
    val title: String,
    val duration: Long,
    val url: String,
    val lyricsId: Int? = null,
    val albumId: Int,
    val genreId: Int? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val noSearch: Boolean,
    val isHq: Boolean
)

data class Document(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val size: Long,
    val ext: String? = null,
    val url: String,
    val date: LocalDateTime = LocalDateTime.now(),
    var type: Int,
    val preview: Preview? = null
) {
    fun typeDocument(type: Int): String {
        val types = arrayOf(
            "текстовые документы",
            "архивы",
            "gif",
            "изображения",
            "аудио",
            "видео",
            "электронные книги",
            "неизвестно"
        )
        return when (type) {
            in 0..types.size -> types[type - 1]
            else -> {
                "Oops, try again"
            }
        }
    }
}

data class Preview(
    val photo: PhotoPreview,
    val graffiti: GraffitiPreview,
    val audioMessage: AudioMessagePreview
)

data class PhotoPreview(
    var sizes: Array<PhotoPreview> = emptyArray()
)

data class GraffitiPreview(
    val src: String,
    val width: Int,
    val height: Int
)

data class AudioMessagePreview(
    val duration: Long,
    var waveform: Array<Int> = emptyArray(),
    val linkOgg: String,
    val linkMp3: String
)

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val photo: Photo,
    val previewPage: String,
    val previewUrl: String
)

data class Note(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val comments: Long?,
    val readComments: Long,
    val viewUrl: String
)

data class Page(
    val id: Long,
    val groupId: Long,
    val creatorId: Long,
    val title: String,
    val currentUserCanEdit: Boolean,
    val currentUserCanEditAccess: Boolean,
    var whoCanView: Array<String> = emptyArray(),
    val whoCanEdit: Array<String> = emptyArray(),
    val edited: Int,
    val created: LocalDateTime = LocalDateTime.now(),
    val editorId: Long,
    val views: Long? = null,
    val parent: String,
    val parent2: String,
    val source: String?,
    val html: String,
    val viewUrl: String
)

data class Photo(
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val userId: Long,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val sizes: Array<Any>? = null,
    val width: Int?,
    val height: Int
)

data class Poll(
    val id: Long,
    val ownerId: Long,
    val created: LocalDateTime = LocalDateTime.now(),
    val question: String,
    val votes: Long,
    val answers: Array<Any>? = null,
    val anonymous: Boolean,
    val multiple: Boolean,
    val answerIds: Array<Any>? = null,
    val endDate: LocalDateTime = LocalDateTime.now().plusDays(1),
    val closed: Boolean,
    val isBoard: Boolean,
    val canEdit: Boolean,
    val canVote: Boolean,
    val canReport: Boolean,
    val canShare: Boolean,
    val authorId: Long,
    val photo: Photo,
    val background: Background
)

data class Background(
    val id: Long = 0,
    val type: Array<Any>? = null,
    val angle: Int,
    val color: String,
    val width: Int,
    val height: Int,
    val images: Array<Any>? = null,
    val points: Array<Any>? = null

)
data class PostSource(
    val type: String,
    val platform: String,
    val data: LocalDateTime = LocalDateTime.now().minusDays(5),
    val url: String
)

data class Sticker(
    val productId: Long,
    val stickerId: Long,
    val images: Array<Any>? = null,
    val imagesWithBackground: Array<Any>? = null
)

data class Video(
    val id: Long,
    val ownerId: Long,
    val title: String,
    val description: String,
    val duration: Long,
    val photo130: String,
    val photo320: String,
    val photo640: String,
    val photo800: String,
    val photo1280: String,
    val firstFrame130: String,
    val firstFrame320: String,
    val firstFrame640: String? = null,
    val firstFrame800: String,
    val firstFrame1280: String,
    val date: LocalDateTime = LocalDateTime.now().minusMonths(1),
    val addingDate: LocalDateTime = LocalDateTime.now().minusHours(1),
    val views: Long,
    val comments: Long,
    val player: String,
    val platform: String? = null,
    val canEdit: Boolean,
    val canAdd: Boolean,
    val isPrivate: Boolean,
    val accessKey: String,
    val processing: Boolean,
    val live: Boolean,
    val upcoming: Boolean? = null,
    val isFavourite: Boolean
)