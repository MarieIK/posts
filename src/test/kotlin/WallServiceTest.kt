import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(
            Post(
                postType = PostType.POSTPONE
            )
        )
        assertTrue(postOne.id != 0)

    }

    @Test
    fun updateTrue() {
        val service = WallService()
        service.add(
            Post(
                postType = PostType.POSTPONE
            )
        )

        service.add(
            Post(
                postType = PostType.COPY
            )
        )

        service.add(
            Post(
                postType = PostType.SUGGEST
            )
        )

        val update = Post(
            id = 1, postType = PostType.COPY
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService()
        service.add(
            Post(
                postType = PostType.POSTPONE
            )
        )

        service.add(
            Post(
                postType = PostType.COPY
            )
        )

        service.add(
            Post(
                postType = PostType.SUGGEST
            )
        )

        val update = Post(
            id = 8, postType = PostType.SUGGEST
        )

        val result = service.update(update)

        assertFalse(result)
    }
}