import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import java.lang.Exception

fun tryDirectionFromKeyStroke(keyStroke: KeyStroke): Direction? {
    return when (keyStroke.character) {
        'w' -> Direction.UP
        'd' -> Direction.RIGHT
        's' -> Direction.DOWN
        'a' -> Direction.LEFT
        else -> null
    }
}

fun main(args: Array<String>) {
    val gameSizeInput = args.getOrNull(0)
        ?: throw Exception("Program is missing game-size argument")
    val gameSize = gameSizeInput.toIntOrNull()
        ?: throw Exception("Game-size argument is not an integer")

    val terminal = DefaultTerminalFactory()
        .setInitialTerminalSize(TerminalSize(gameSize + 2, gameSize + 2))
        .createTerminal()
    terminal.enterPrivateMode()
    terminal.setCursorVisible(false)

    println("Starting snake\n\tGame-size: $gameSize")
    val game = Game(gameSize)

    while (true) {
        val input = terminal.pollInput()
        // Close when pressing ESC or when closing the game-window
        // (Lanterna emits EOF when closing the window)
        if (input?.keyType == KeyType.Escape || input?.keyType == KeyType.EOF) break

        val inputDirection =
            if (input != null) tryDirectionFromKeyStroke(input) else null

        printTo(terminal, game)
        terminal.flush()
    }

    terminal.exitPrivateMode()
    terminal.close()
}
