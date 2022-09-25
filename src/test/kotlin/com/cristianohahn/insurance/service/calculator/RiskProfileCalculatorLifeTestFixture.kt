package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileCalculatorLifeTestFixture {

    fun aRiskProfileCalculateCommandWithAge(age: Int) = aDefaultRiskProfileCalculateCommand().copy(
        age = age
    )

    fun aRiskProfileCalculateCommandWithDependents() = aDefaultRiskProfileCalculateCommand().copy(
        dependents = 2
    )

    fun aRiskProfileCalculateCommandMarried() = aDefaultRiskProfileCalculateCommand().copy(
        maritalStatus = "married"
    )

    fun aRiskProfileCalculateCommandWithDependentsMarriedAndRisk() = aDefaultRiskProfileCalculateCommand().copy(
        maritalStatus = "married",
        dependents = 1,
        riskQuestions = listOf(0, 0, 1)
    )

    fun aDefaultRiskProfileCalculateCommand() = RiskProfileCalculateCommand(
        age = 50,
        dependents = 0,
        income = 0,
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