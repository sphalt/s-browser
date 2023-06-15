package org.mozilla.reference.browser.easteregg

class Puzzles {
    val puzzles : MutableMap<DifficultyLevel, WordPuzzle> = mutableMapOf(
        Pair(DifficultyLevel.EASY, WordPuzzle("What has a head and a tail, but no body?", "coin")),
        Pair(DifficultyLevel.MEDIUM, WordPuzzle("What begins with T, finishes with T, and has T in it?", "teapot")),
        Pair(DifficultyLevel.HARD, WordPuzzle("First, think of the color of the clouds. Next, think of the color of snow. Now, think of the color of a bright full moon. Now answer quickly what do cows drink?", "water"))
    )

}