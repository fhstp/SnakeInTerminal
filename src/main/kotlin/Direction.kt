import com.googlecode.lanterna.TerminalPosition

// TerminalPosition is here interpreted as a vector
enum class Direction(val vector: TerminalPosition) {
    UP(TerminalPosition(0, -1)),
    RIGHT(TerminalPosition(1, 0)),
    DOWN(TerminalPosition(0, 1)),
    LEFT(TerminalPosition(-1, 0))
}

fun is90DegreeAngle(
    direction1: Direction,
    direction2: Direction
): Boolean {
    return direction1.vector.row != direction2.vector.row &&
            direction1.vector.column != direction2.vector.column
}

fun neighborOf(
    position: TerminalPosition,
    direction: Direction
): TerminalPosition {
    return position + direction.vector
}