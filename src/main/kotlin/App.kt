import com.googlecode.lanterna.terminal.DefaultTerminalFactory

fun main() {
    val terminal = DefaultTerminalFactory().createTerminal()
    terminal.enterPrivateMode()
    terminal.putString("Hello world")
}
