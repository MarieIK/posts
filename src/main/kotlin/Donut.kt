data class Donut(
    val isDonut: Boolean = true,
    var paidDuration: Long = 10,
    val placeholder: Placeholder = Placeholder(),
    val canPublishFreeCopy: Boolean = true,
    var editMode: DonutEditMode
)