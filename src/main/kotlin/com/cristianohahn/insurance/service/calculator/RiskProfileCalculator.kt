package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

abstract class RiskProfileCalculator {

    abstract fun calculate(command: RiskProfileCalculateCommand): String

    protected fun calculateDefaultPoints(command: RiskProfileCalculateCommand): Int {
        val riskQuestionsPoints = command.riskQuestions.sum()
        val agePoints = when {
            command.age < 30 -> -2
            command.age < 40 -> -1
            else -> 0
        }
        val incomePoints = when {
            command.income < 200000 -> 0
            else -> -1
        }

        return agePoints + incomePoints + riskQuestionsPoints
    }

    protected fun Int.toProfileDescription(): String = when {
        this < 1 -> "economic"
        this < 3 -> "regular"
        else -> "responsible"
    }
}