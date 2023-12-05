import com.googlecode.lanterna.graphics.TextGraphics

private const val wallCharacter = '#'

private fun printWallsTo(gfx: TextGraphics, gameSize: Int) {
    val maxIndex = gameSize + 1

    gfx.drawLine(0, 0, maxIndex, 0, wallCharacter) // Top
    gfx.drawLine(maxIndex, 0, maxIndex, maxIndex, wallCharacter) // Right
    gfx.drawLine(0, maxIndex, maxIndex, maxIndex, wallCharacter) // Bottom
    gfx.drawLine(0, 0, 0, maxIndex, wallCharacter) // Left
}

fun printTo(gfx: TextGraphics, game: Game) {
    printWallsTo(gfx, game.size)
}
