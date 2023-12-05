import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import java.lang.Exception

fun main(args: Array<String>) {
    val gameSizeInput = args.getOrNull(0)
        ?: throw Exception("Program is missing game-size argument")
    val gameSize = gameSizeInput.toIntOrNull()
        ?: throw Exception("Game-size argument is not an integer")

    val terminal = DefaultTerminalFactory().createTerminal()
    terminal.enterPrivateMode()

    println("Starting snake\n\tGame-size: $gameSize")

    while (true) {
        val input = terminal.pollInput()
        if (input?.keyType == KeyType.Escape) break;
    }

    terminal.exitPrivateMode()
    terminal.close()
}
