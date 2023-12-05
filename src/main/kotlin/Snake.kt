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