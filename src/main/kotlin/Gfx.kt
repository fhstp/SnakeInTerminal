import com.googlecode.lanterna.graphics.TextGraphics

private const val wallCharacter = '#'
private const val snakeCharacter = 'o'
private const val appleCharacter = 'a'

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

private fun printAppleTo(gfx: TextGraphics, apple: Apple) {
    gfx.setCharacter(apple, appleCharacter)
}

fun printTo(gfx: TextGraphics, game: Game) {
    if (game.gameOver) {
        gfx.putString(0, 0, "GAME OVER")
        gfx.putString(0, 1, "Final score:")
        gfx.putString(0, 2, game.score.toString())
        return
    }

    printAppleTo(gfx, game.apple)
    printSnakeTo(gfx, game.snake)
    printWallsTo(gfx, game.size)
    gfx.putString(0, game.size + 2, game.score.toString())
}
