import com.googlecode.lanterna.TerminalPosition
import java.time.Instant
import kotlin.random.Random

data class Game(
    val size: Int,
    val snake: Snake,
    val apple: TerminalPosition,
    val score: Int,
    val gameOver: Boolean,
    val rng: Random
)


fun makeNewGame(size: Int, snakeLength: Int): Game {
    val center = TerminalPosition(size / 2, size / 2)
    val snake = makeSnake(center, snakeLength, Direction.RIGHT)
    val rng = Random(Instant.now().epochSecond)
    val apple = generateApple(rng, size)
    return Game(size, snake, apple, 0, false, rng)
}

private fun gameOver(game: Game): Game {
    return game.copy(gameOver = true)
}

fun nextFrame(input: Direction?, game: Game): Game {
    @Suppress("NAME_SHADOWING") var game = game

    if (game.gameOver) return game

    if (input != null)
        game = game.copy(snake = tryChangeHeading(game.snake, input))

    game = game.copy(snake = move(game.snake))

    val snakeHead = headOf(game.snake)
    val snakeIsEatingApple = snakeHead == game.apple
    if (snakeIsEatingApple)
        game = game.copy(
            snake = grow(game.snake),
            apple = generateApple(game.rng, game.size),
            score = game.score + appleScoreValue
        )

    val snakeIsInWall = snakeHead.row <= 0 ||
            snakeHead.column <= 0 ||
            snakeHead.row > game.size ||
            snakeHead.column > game.size
    if (snakeIsInWall || isBitingSelf(game.snake)) return gameOver(game)

    return game
}