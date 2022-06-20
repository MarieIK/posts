import java.time.LocalDateTime

val firstPost = Post(
    id = 1,
    ownerId = 47,
    fromId = 90,
    date = LocalDateTime.now(),
    text = "Some text Post 1",
    comments = Comments(count = 5, canClose = false, canOpen = false),
    copyright = Copyright(id = 86, "Author link", "Author name", "for post 1"),
    likes = Likes(count = 34, userLikes = false),
    reposts = Reposts(count = 130),
    views = Views(count = 900),
    postType = PostType.COPY,
    canPin = false,
    canDelete = false,
    donut = Donut(isDonut = false, editMode = DonutEditMode.ALL)
)

val secondPost = Post(
    id = 2,
    ownerId = 901,
    fromId = 478,
    date = LocalDateTime.now(),
    text = "Some text Post 2",
    comments = Comments(count = 3, canOpen = false),
    copyright = Copyright(id = 19087, "Author2 link", "Author2 name", "for post 2"),
    likes = Likes(count = 900, canLike = false),
    reposts = Reposts(count = 400),
    views = Views(count = 1200),
    postType = PostType.POSTPONE,
    canDelete = false,
    canEdit = false,
    donut = Donut(editMode = DonutEditMode.DURATION)
)

val thirdPost = secondPost.copy(id = 3)
fun main() {

    val wallService = WallService()
    wallService.add(firstPost)
    wallService.add(secondPost)

    wallService.posts.forEach { println(it) }

    println(wallService.update(secondPost))
    println(wallService.update(thirdPost))

}