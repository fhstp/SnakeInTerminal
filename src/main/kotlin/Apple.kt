import com.googlecode.lanterna.TerminalPosition
import kotlin.random.Random

typealias Apple = TerminalPosition

fun generateApple(rng: Random, gameSize: Int): Apple {
    // TODO: Make sure position is not on snake
    return TerminalPosition(
        rng.nextInt(0, gameSize),
        rng.nextInt(0, gameSize)
    )
}
