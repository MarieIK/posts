val firstPost = Post(
    id = 1,
    ownerId = 47,
    likes = Likes(count = 34, userLikes = false),
    reposts = Reposts(count = 130),
    views = Views(count = 900),
    postType = PostType.COPY,
)

val secondPost = Post(
    id = 2,
    ownerId = 901,
    text = "Some text Post 2",
    comments = Comments(count = 3),
    copyright = Copyright(id = 19087, "Author2 link"),
    likes = Likes(count = 900),
    reposts = Reposts(count = 400),
    views = Views(count = 1200),
    postType = PostType.POSTPONE,
)

val thirdPost = secondPost.copy(id = 3)
fun main() {

    val wallService = WallService()
    wallService.add(firstPost)
    wallService.add(secondPost)

    wallService.printWallService()

    println(wallService.update(secondPost))
    println(wallService.update(thirdPost))

}