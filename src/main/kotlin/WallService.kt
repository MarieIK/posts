class WallService {
    var posts = emptyArray<Post>()

    private var idCount: Int = 0
    private fun getId(): Int {
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

}