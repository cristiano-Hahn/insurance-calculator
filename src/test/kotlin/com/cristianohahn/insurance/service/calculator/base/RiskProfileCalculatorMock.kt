package com.cristianohahn.insurance.service.calculator.base

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

class RiskProfileCalculatorMock : RiskProfileCalculator() {

    override fun calculate(command: RiskProfileCalculateCommand): String {
        throw RuntimeException("Not implemented! Please use other methods of this class to build the tests...")
    }

    fun calculatePoints(command: RiskProfileCalculateCommand) = super.calculateDefaultPoints(command)

    fun getProfileDescription(points: Int) = points.toProfileDescription()
}