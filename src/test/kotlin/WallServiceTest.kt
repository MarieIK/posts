import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(
            Post(
                ownerId = 901,
                fromId = 478,
                date = LocalDateTime.now(),
                text = "Some text Post Test",
                comments = Comments(count = 3, canOpen = false),
                copyright = Copyright(id = 19087, "Author0 link", "Author0 name", "for post 0"),
                likes = Likes(count = 900, canLike = false),
                reposts = Reposts(count = 400),
                views = Views(count = 1200),
                postType = PostType.POSTPONE,
                canPin = false,
                canEdit = false,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )
        assertTrue(postOne.id != 0)

    }

    @Test
    fun updateTrue() {
        val service = WallService()
        service.add(
            Post(
                id = 1,
                ownerId = 901,
                fromId = 478,
                date = LocalDateTime.now(),
                text = "Some text Post Test",
                comments = Comments(count = 3, canOpen = false),
                copyright = Copyright(id = 19087, "Author0 link", "Author0 name", "for post 0"),
                likes = Likes(count = 900, canLike = false),
                reposts = Reposts(count = 400),
                views = Views(count = 1200),
                postType = PostType.POSTPONE,
                canPin = false,
                canEdit = false,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        service.add(
            Post(
                date = LocalDateTime.now(),
                comments = Comments(count = 45, canOpen = false),
                copyright = Copyright(id = 100000, "Author5 link", "Author5 name", "for post 5"),
                likes = Likes(count = 6, canLike = false),
                reposts = Reposts(count = 100),
                views = Views(count = 78),
                postType = PostType.COPY,
                donut = Donut(editMode = DonutEditMode.ALL)
            )
        )

        service.add(
            Post(
                date = LocalDateTime.now(),
                comments = Comments(count = 1, canClose = false),
                copyright = Copyright(id = 123, "Author98 link", "Author98 name", "for post 98"),
                likes = Likes(count = 134, canPublish = false),
                reposts = Reposts(count = 50),
                views = Views(count = 459),
                postType = PostType.SUGGEST,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        val update = Post(
            id = 1,
            ownerId = 901,
            fromId = 478,
            date = LocalDateTime.now(),
            text = "Some text Post Test",
            comments = Comments(count = 3, canOpen = false),
            copyright = Copyright(id = 19087, "Author0 link", "Author0 name", "for post 0"),
            likes = Likes(count = 900, canLike = false),
            reposts = Reposts(count = 400),
            views = Views(count = 1200),
            postType = PostType.POSTPONE,
            canPin = false,
            canEdit = false,
            donut = Donut(editMode = DonutEditMode.DURATION)
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService()
        service.add(
            Post(
                id = 1,
                ownerId = 901,
                fromId = 478,
                date = LocalDateTime.now(),
                text = "Some text Post Test",
                comments = Comments(count = 3, canOpen = false),
                copyright = Copyright(id = 19087, "Author0 link", "Author0 name", "for post 0"),
                likes = Likes(count = 900, canLike = false),
                reposts = Reposts(count = 400),
                views = Views(count = 1200),
                postType = PostType.POSTPONE,
                canPin = false,
                canEdit = false,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        service.add(
            Post(
                date = LocalDateTime.now(),
                comments = Comments(count = 45, canOpen = false),
                copyright = Copyright(id = 100000, "Author5 link", "Author5 name", "for post 5"),
                likes = Likes(count = 6, canLike = false),
                reposts = Reposts(count = 100),
                views = Views(count = 78),
                postType = PostType.COPY,
                donut = Donut(editMode = DonutEditMode.ALL)
            )
        )

        service.add(
            Post(
                date = LocalDateTime.now(),
                comments = Comments(count = 1, canClose = false),
                copyright = Copyright(id = 123, "Author98 link", "Author98 name", "for post 98"),
                likes = Likes(count = 134, canPublish = false),
                reposts = Reposts(count = 50),
                views = Views(count = 459),
                postType = PostType.SUGGEST,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        val update = Post(
            id = 8,
            ownerId = 901,
            fromId = 478,
            date = LocalDateTime.now(),
            text = "Some text Post Test",
            comments = Comments(count = 3, canOpen = false),
            copyright = Copyright(id = 19087, "Author0 link", "Author0 name", "for post 0"),
            likes = Likes(count = 900, canLike = false),
            reposts = Reposts(count = 400),
            views = Views(count = 1200),
            postType = PostType.POSTPONE,
            canPin = false,
            canEdit = false,
            donut = Donut(editMode = DonutEditMode.DURATION)
        )

        val result = service.update(update)

        assertFalse(result)
    }
}