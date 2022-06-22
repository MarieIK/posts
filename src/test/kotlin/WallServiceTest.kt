import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(Post())
        assertTrue(postOne.id != 0L)
    }

    @Test
    fun updateTrue() {
        val service = WallService()
        service.add(Post())
        service.add(Post())
        service.add(Post())

        val update = Post(
            id = 1
        )

        val result = service.update(update)

        assertTrue(result)
    }

    @Test
    fun updateFalse() {
        val service = WallService()
        service.add(Post())
        service.add(Post())
        service.add(Post())

        val update = Post(
            id = 8
        )

        val result = service.update(update)

        assertFalse(result)
    }

    @Test
    fun createComment() {
        val service = WallService()
        val newComment = NewComment(1)
        service.add(Post())
        val result = service.createComment(1, newComment)
        assertEquals(newComment, result)

    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val service = WallService()
        val newComment = NewComment()
        service.add(Post())
        service.createComment(0, newComment)
    }
}
