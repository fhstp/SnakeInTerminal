import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import java.lang.Exception

fun main(args: Array<String>) {
    val gameSizeInput = args.getOrNull(0)
        ?: throw Exception("Program is missing game-size argument")
    val gameSize = gameSizeInput.toIntOrNull()
        ?: throw Exception("Game-size argument is not an integer")

    println("Starting snake\n\tGame-size: $gameSize")

    val terminal = DefaultTerminalFactory().createTerminal()
    terminal.enterPrivateMode()
    terminal.putString("Hello world")
}
