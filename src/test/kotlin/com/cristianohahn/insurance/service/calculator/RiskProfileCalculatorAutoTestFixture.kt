package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import java.util.*

object RiskProfileCalculatorAutoTestFixture {

    fun aRiskProfileCalculateCommandWithoutAuto() = aDefaultRiskProfileCalculateCommand().copy(
        vehicle = null
    )

    fun aRiskProfileCalculateCommandWithVehicleWithMoreThan5Years() = aDefaultRiskProfileCalculateCommand().copy(
        vehicle = RiskProfileCalculateCommand.RiskProfileCalculateVehicle(
            year = Calendar.getInstance().get(Calendar.YEAR) - 6
        )
    )

    fun aRiskProfileCalculateCommandWithVehicleWithLessThan5Years() = aDefaultRiskProfileCalculateCommand().copy(
        vehicle = RiskProfileCalculateCommand.RiskProfileCalculateVehicle(
            year = Calendar.getInstance().get(Calendar.YEAR) - 2
        )
    )

    fun aRiskProfileCalculateCommandWithVehicleWithLessThan5YearsAndRisk() = aDefaultRiskProfileCalculateCommand().copy(
        riskQuestions = listOf(0, 1, 1),
        vehicle = RiskProfileCalculateCommand.RiskProfileCalculateVehicle(
            year = Calendar.getInstance().get(Calendar.YEAR) - 2
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