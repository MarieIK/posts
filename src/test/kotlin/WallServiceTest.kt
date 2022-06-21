import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val postOne = service.add(Post())
        assertTrue(postOne.id != 0)
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
}