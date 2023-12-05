import com.googlecode.lanterna.terminal.Terminal

private const val wallCharacter = '#'

private fun printWallsTo(terminal: Terminal, gameSize: Int) {
    val sizeWithWall = gameSize + 2

    for (index in 0..<sizeWithWall) {
        // Top
        terminal.setCursorPosition(index, 0)
        terminal.putCharacter(wallCharacter)

        // Right
        terminal.setCursorPosition(sizeWithWall - 1, index)
        terminal.putCharacter(wallCharacter)

        // Bottom
        terminal.setCursorPosition(index, sizeWithWall - 1)
        terminal.putCharacter(wallCharacter)

        // Left
        terminal.setCursorPosition(0, index)
        terminal.putCharacter(wallCharacter)
    }
}

fun printTo(terminal: Terminal, game: Game) {
    printWallsTo(terminal, game.size)
}
