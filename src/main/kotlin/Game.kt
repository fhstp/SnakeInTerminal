import com.googlecode.lanterna.TerminalPosition

data class Game(val size: Int, val snake: Snake, val score: Int)

fun makeNewGame(size: Int, snakeLength: Int): Game {
    val center = TerminalPosition(size / 2, size / 2)
    val snake = makeSnake(center, snakeLength, Direction.RIGHT)
    return Game(size, snake, 0)
}

fun nextFrame(input: Direction?, game: Game): Game {
    var newGame = game
    if (input != null)
        newGame = newGame.copy(snake = tryChangeHeading(newGame.snake, input))
    newGame = newGame.copy(snake = move(newGame.snake))

    return newGame
}