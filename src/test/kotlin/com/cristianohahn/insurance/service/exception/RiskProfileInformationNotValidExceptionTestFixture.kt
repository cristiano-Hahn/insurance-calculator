package com.cristianohahn.insurance.service.exception

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileInformationNotValidExceptionTestFixture {

    fun aRiskProfileCalculateCommandWithInvalidAge() = RiskProfileCalculateCommand(
        age = -10,
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