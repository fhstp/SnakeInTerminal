import com.googlecode.lanterna.graphics.TextGraphics

private const val wallCharacter = '#'
private const val snakeCharacter = 'o'

private fun printWallsTo(gfx: TextGraphics, gameSize: Int) {
    val maxIndex = gameSize + 1

    gfx.drawLine(0, 0, maxIndex, 0, wallCharacter) // Top
    gfx.drawLine(maxIndex, 0, maxIndex, maxIndex, wallCharacter) // Right
    gfx.drawLine(0, maxIndex, maxIndex, maxIndex, wallCharacter) // Bottom
    gfx.drawLine(0, 0, 0, maxIndex, wallCharacter) // Left
}

private fun printSnakeTo(gfx: TextGraphics, snake: Snake) {
    snake.positions.forEach {
        gfx.setCharacter(it, snakeCharacter)
    }
}

fun printTo(gfx: TextGraphics, game: Game) {
    printSnakeTo(gfx, game.snake)
    printWallsTo(gfx, game.size)
}
