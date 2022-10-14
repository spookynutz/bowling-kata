package org.example

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BowlingGameTest {

    @Test
    fun should_score_0_when_all_gutter_balls() {
        // Given
        val playerRolls = "-- -- -- -- -- -- -- -- -- --"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 0
        assertEquals(expected, actual)
    }

    @Test
    fun should_score_20_when_all_ones() {
        // Given
        val playerRolls = "11 11 11 11 11 11 11 11 11 11"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 20
        assertEquals(expected, actual)
    }

    @Test
    fun should_count_bonus_score_for_a_spare() {
        // Given
        val playerRolls = "1/ 9- -- -- -- -- -- -- -- --"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 28
        assertEquals(expected, actual)
    }

    @Test
    fun should_count_bonus_score_for_a_strike() {
        // Given
        val playerRolls = "X 72 -- -- -- -- -- -- -- --"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 28
        assertEquals(expected, actual)
    }

    @Test
    fun should_score_300_when_all_strikes() {
        // Given
        val playerRolls = "X X X X X X X X X XXX"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 300
        assertEquals(expected, actual)
    }

    @Test
    fun should_score_90() {
        // Given
        val playerRolls = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 90
        assertEquals(expected, actual)
    }

    @Test
    fun should_score_150() {
        // Given
        val playerRolls = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5"
        val bowlingGame = BowlingGame(playerRolls)

        // When
        val actual = bowlingGame.score()

        // Then
        val expected = 150
        assertEquals(expected, actual)
    }


}