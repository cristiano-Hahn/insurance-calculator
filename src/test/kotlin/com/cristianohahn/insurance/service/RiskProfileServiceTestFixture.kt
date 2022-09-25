package com.cristianohahn.insurance.service

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileServiceTestFixture {

    fun aRiskProfileCalculateCommandWithInvalidAge() = aDefaultRiskProfileCalculateCommand().copy(
        age = -10
    )

    fun aRiskProfileCalculateCommandWithInvalidDependents() = aDefaultRiskProfileCalculateCommand().copy(
        dependents = -1
    )

    fun aRiskProfileCalculateCommandWithInvalidIncome() = aDefaultRiskProfileCalculateCommand().copy(
        income = -1
    )

    fun aRiskProfileCalculateCommandWithInvalidMaritalStatus() = aDefaultRiskProfileCalculateCommand().copy(
        maritalStatus = "other"
    )

    fun aRiskProfileCalculateCommandWithInvalidOwnershipStatus() = aDefaultRiskProfileCalculateCommand().copy(
        house = RiskProfileCalculateCommand.RiskProfileCalculateHouse(
            ownershipStatus = "other"
        )
    )

    fun aRiskProfileCalculateCommandWithInvalidVehicleYear() = aDefaultRiskProfileCalculateCommand().copy(
        vehicle = RiskProfileCalculateCommand.RiskProfileCalculateVehicle(
            year = -10
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