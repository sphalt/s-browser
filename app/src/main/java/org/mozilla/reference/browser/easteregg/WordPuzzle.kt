package org.mozilla.reference.browser.easteregg

class WordPuzzle(val question:String, val answer: String) {

    fun verifyAnswer(givenAnswer: String) : Boolean {
        return givenAnswer.lowercase().trim().equals(answer)
    }
}