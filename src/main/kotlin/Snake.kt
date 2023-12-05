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

fun headOf(snake: Snake): TerminalPosition {
    return snake.positions.last()
}

fun move(snake: Snake): Snake {
    val nextHead = neighborOf(headOf(snake), snake.heading)
    val newPositions = snake.positions.drop(1) + nextHead
    return snake.copy(positions = newPositions)
}

fun grow(snake: Snake): Snake {
    return snake.copy(positions = snake.positions.take(1) + snake.positions)
}