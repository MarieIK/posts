import java.time.LocalDateTime

data class Audio(
    val id: Long,
    val artist: String,
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
            "текстовые документы", "архивы", "gif", "изображения", "аудио", "видео", "электронные книги", "неизвестно"
        )
        return types[type]
    }
}

data class Preview(
    val photo: PhotoPreview, val graffiti: GraffitiPreview, val audioMessage: AudioMessagePreview
)

data class PhotoPreview(
    var sizes: Array<PhotoPreview> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PhotoPreview

        if (!sizes.contentEquals(other.sizes)) return false

        return true
    }

    override fun hashCode(): Int {
        return sizes.contentHashCode()
    }
}

data class GraffitiPreview(
    val src: String, val width: Int, val height: Int
)

data class AudioMessagePreview(
    val duration: Long,
)

data class Photo(
    val id: Long,
    val albumId: Long,
    val ownerId: Long,
    val userId: Long,
    val text: String? = null,
    val date: LocalDateTime = LocalDateTime.now(),
    val width: Int?,
    val height: Int
)

data class Video(
    val id: Long,
    val description: String,
    val date: LocalDateTime = LocalDateTime.now().minusMonths(1),
    val addingDate: LocalDateTime = LocalDateTime.now().minusHours(1),
)