import com.googlecode.lanterna.TerminalPosition

data class Snake(val positions: List<TerminalPosition>, val heading: Direction)

fun makeSnake(
    initialPosition: TerminalPosition,
    initialLength: Int,
    initialHeading: Direction
): Snake {
    val positions = List(initialLength) { initialPosition }
    return Snake(positions, initialHeading)
}

fun tryChangeHeading(snake: Snake, heading: Direction): Snake {
    val shouldChangeHeading = is90DegreeAngle(heading, snake.heading)

    if (!shouldChangeHeading)
        return snake
    return snake.copy(heading = heading)
}