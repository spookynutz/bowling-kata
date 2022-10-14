package org.example

class BowlingGame(private val playerRolls: String) {

    private val rolls = playerRolls
        .replace(" ", "")
        .split("")
        .filter { it.isNotEmpty() }
        .toTypedArray()

    fun score(): Int {
        var score = 0
        var frameIndex = 0
        (0..9).forEach { _ ->
            when {
                isStrike(frameIndex) -> {
                    score += 10 + strikeBonus(frameIndex)
                    frameIndex++
                }
                isSpare(frameIndex) -> {
                    score += 10 + spareBonus(frameIndex)
                    frameIndex += 2
                }
                else -> {
                    score += sumOfBallsInFrame(frameIndex)
                    frameIndex += 2
                }
            }
        }
        return score
    }

    private fun isSpare(frameIndex: Int): Boolean = rolls[frameIndex + 1] == "/"

    private fun spareBonus(frameIndex: Int): Int = rolls[frameIndex + 2].evaluate()

    private fun isStrike(frameIndex: Int): Boolean = rolls[frameIndex] == "X"

    private fun strikeBonus(frameIndex: Int): Int {
        return if (isSpare(frameIndex + 1)) 10
        else rolls[frameIndex + 1].evaluate() + rolls[frameIndex + 2].evaluate()
    }

    private fun sumOfBallsInFrame(frameIndex: Int): Int =
        rolls[frameIndex].evaluate() + rolls[frameIndex + 1].evaluate()

    private fun String.evaluate(): Int = when(this) {
        "X" -> 10
        "-" -> 0
        else -> this.toInt()
    }
}