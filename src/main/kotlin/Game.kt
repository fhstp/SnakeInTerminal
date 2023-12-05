import com.googlecode.lanterna.TerminalPosition
import java.time.Instant
import kotlin.random.Random

data class Game(
    val size: Int,
    val snake: Snake,
    val apple: TerminalPosition,
    val score: Int,
    val rng: Random
)



fun makeNewGame(size: Int, snakeLength: Int): Game {
    val center = TerminalPosition(size / 2, size / 2)
    val snake = makeSnake(center, snakeLength, Direction.RIGHT)
    val rng = Random(Instant.now().epochSecond)
    val apple = generateApple(rng, size)
    return Game(size, snake, apple, 0, rng)
}

fun nextFrame(input: Direction?, game: Game): Game {
    var newGame = game
    if (input != null)
        newGame = newGame.copy(snake = tryChangeHeading(newGame.snake, input))
    newGame = newGame.copy(snake = move(newGame.snake))

    return newGame
}