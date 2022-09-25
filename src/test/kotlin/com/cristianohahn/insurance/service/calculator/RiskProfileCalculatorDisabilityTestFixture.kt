package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileCalculatorDisabilityTestFixture {

    fun aRiskProfileCalculateCommandWithAge(age: Int) = aDefaultRiskProfileCalculateCommand().copy(
        age = age
    )

    fun aRiskProfileCalculateCommandWithIncome(income: Int) = aDefaultRiskProfileCalculateCommand().copy(
        income = income
    )

    fun aRiskProfileCalculateCommandWithDependents() = aDefaultRiskProfileCalculateCommand().copy(
        dependents = 2
    )

    fun aRiskProfileCalculateCommandMarriedWithRisk() = aDefaultRiskProfileCalculateCommand().copy(
        maritalStatus = "married",
        riskQuestions = listOf(0, 0, 1)
    )


    fun aRiskProfileCalculateCommandWithDependentsMortgagedAndRisk() = aDefaultRiskProfileCalculateCommand().copy(
        dependents = 1,
        riskQuestions = listOf(0, 0, 1),
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "mortgaged"
        )
    )

    fun aRiskProfileCalculateCommandMortgaged() = aDefaultRiskProfileCalculateCommand().copy(
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "mortgaged"
        )
    )

    fun aDefaultRiskProfileCalculateCommand() = RiskProfileCalculateCommand(
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