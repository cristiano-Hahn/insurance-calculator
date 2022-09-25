package com.cristianohahn.insurance.controller

import com.cristianohahn.insurance.model.RiskProfile
import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand

object RiskProfileControllerTestFixture {

    fun aRiskProfileCalculateCommand() = RiskProfileCalculateCommand(
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

    fun aRiskProfile() = RiskProfile(
        auto = "economic",
        home = "economic",
        disability = "economic",
        life = "economic"
    )
}