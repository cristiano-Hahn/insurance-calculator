package com.cristianohahn.insurance.service.calculator.base

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileCalculatorTestFixture {

    fun aRiskProfileCalculateCommandWith3Risks() = aDefaultRiskProfileCalculateCommand().copy(
        riskQuestions = listOf(1, 1, 1)
    )

    fun aRiskProfileCalculateCommandWithIncomeMoreThan200000() = aDefaultRiskProfileCalculateCommand().copy(
        income = 200001
    )

    fun aRiskProfileCalculateCommandWithAge(age: Int) = aDefaultRiskProfileCalculateCommand().copy(
        age = age
    )

    private fun aDefaultRiskProfileCalculateCommand() = RiskProfileCalculateCommand(
        age = 50,
        dependents = 0,
        income = 10000,
        maritalStatus = "single",
        riskQuestions = listOf(0, 0, 0),
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "owned"
        ),
        vehicle = RiskProfileCalculateCommand.RiskProfileCalculateVehicle(
            year = 2010
        )
    )
}