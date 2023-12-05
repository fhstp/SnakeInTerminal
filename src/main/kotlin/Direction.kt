import kotlin.math.abs

enum class Direction(val angle: Int) {
    UP(90), RIGHT(0), DOWN(270), LEFT(180)
}

fun is90DegreeAngle(
    direction1: Direction,
    direction2: Direction
): Boolean {
    val diff = abs(direction1.angle - direction2.angle)
    return diff == 90 || diff == 270
}