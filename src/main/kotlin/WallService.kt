class WallService {
    private var posts = emptyArray<Post>()
    private var idCount: Long = 0
    private var comments = emptyArray<NewComment>()

    private fun getId(): Long {
        return ++idCount
    }

    fun add(post: Post): Post {
        posts += post.copy(id = getId())
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index) in posts.withIndex()) {
            if (post.id == posts[index].id) {
                posts[index] = post.copy(ownerId = posts[index].ownerId, date = posts[index].date)
                return true
            }
        }
        return false
    }

    fun printWallService() {
        for (wallService in posts) {
            println(wallService)
        }
    }

    fun createComment(postId: Long, newComment: NewComment): NewComment {
        for (post in posts) {
            if (post.id == postId) {
                comments += newComment
            }
        }
        return if (comments.contains(newComment)) {
            comments.last()
        } else throw PostNotFoundException("Невозможно оставить комментарий. Поста с ID: $postId не существует")
    }
}