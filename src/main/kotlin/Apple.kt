import com.googlecode.lanterna.TerminalPosition
import kotlin.random.Random

typealias Apple = TerminalPosition

const val appleScoreValue = 100

fun generateApple(rng: Random, gameSize: Int): Apple {
    // TODO: Make sure position is not on snake
    return TerminalPosition(
        rng.nextInt(1, gameSize + 1),
        rng.nextInt(1, gameSize + 1)
    )
}
