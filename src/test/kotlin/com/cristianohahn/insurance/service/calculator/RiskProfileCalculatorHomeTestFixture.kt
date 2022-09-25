package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileCalculatorHomeTestFixture {

    fun aRiskProfileCalculateCommandWithoutHouse() = aDefaultRiskProfileCalculateCommand().copy(
        house = null
    )

    fun aRiskProfileCalculateCommandWithMortgagedHouse() = aDefaultRiskProfileCalculateCommand().copy(
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "mortgaged"
        )
    )

    fun aRiskProfileCalculateCommandWithOwnedHouse() = aDefaultRiskProfileCalculateCommand().copy(
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "owned"
        )
    )

    fun aRiskProfileCalculateCommandWithMortgagedAndRisk() = aDefaultRiskProfileCalculateCommand().copy(
        riskQuestions = listOf(0, 1, 1),
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "mortgaged"
        )
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