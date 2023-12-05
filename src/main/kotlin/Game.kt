import com.googlecode.lanterna.TerminalPosition

data class Game(val size: Int, val snake: Snake)

fun makeNewGame(size: Int, snakeLength: Int): Game {
    val center = TerminalPosition(size / 2, size / 2)
    val snake = makeSnake(center, snakeLength, Direction.RIGHT)
    return Game(size, snake)
}

fun nextFrame(input: Direction?, game: Game): Game {
    if (input != null)
        return game.copy(snake = tryChangeHeading(game.snake, input))
    return game
}