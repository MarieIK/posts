import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(
            Post(
                //ownerId = 901,
                //fromId = 478,
                //date = LocalDateTime.now(),
                //text = "Some text Post Test",
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.POSTPONE,
                //canPin = false,
                //canEdit = false,
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
                //id = 1,
                //ownerId = 901,
                //fromId = 478,
                //date = LocalDateTime.now(),
                //text = "Some text Post Test",
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.POSTPONE,
                //canPin = false,
                //canEdit = false,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        service.add(
            Post(
                //date = LocalDateTime.now(),
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.COPY,
                donut = Donut(editMode = DonutEditMode.ALL)
            )
        )

        service.add(
            Post(
                //date = LocalDateTime.now(),
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.SUGGEST,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        val update = Post(
            id = 1,
            //ownerId = 901,
            //fromId = 478,
            //date = LocalDateTime.now(),
            //text = "Some text Post Test",
            //comments = Comments(),
            //copyright = Copyright(),
            //likes = Likes(),
            //reposts = Reposts(),
            //views = Views(),
            postType = PostType.POSTPONE,
            //canPin = false,
            //canEdit = false,
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
                //id = 1,
                //ownerId = 901,
                //fromId = 478,
                //date = LocalDateTime.now(),
                //text = "Some text Post Test",
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.POSTPONE,
                //canPin = false,
                //canEdit = false,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        service.add(
            Post(
                //date = LocalDateTime.now(),
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.COPY,
                donut = Donut(editMode = DonutEditMode.ALL)
            )
        )

        service.add(
            Post(
                //date = LocalDateTime.now(),
                //comments = Comments(),
                //copyright = Copyright(),
                //likes = Likes(),
                //reposts = Reposts(),
                //views = Views(),
                postType = PostType.SUGGEST,
                donut = Donut(editMode = DonutEditMode.DURATION)
            )
        )

        val update = Post(
            id = 8,
            //ownerId = 901,
            //fromId = 478,
            //date = LocalDateTime.now(),
            //text = "Some text Post Test",
            //comments = Comments(),
            //copyright = Copyright(),
            //likes = Likes(),
            //reposts = Reposts(),
            //views = Views(),
            postType = PostType.POSTPONE,
            //canPin = false,
            //canEdit = false,
            donut = Donut(editMode = DonutEditMode.DURATION)
        )

        val result = service.update(update)

        assertFalse(result)
    }
}