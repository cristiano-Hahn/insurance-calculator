package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskProfileCalculatorDisability : RiskProfileCalculator() {

    override fun calculate(command: RiskProfileCalculateCommand): String {
        if (command.income == 0 || command.age >= 60) {
            return "ineligible"
        }

        val points = calculateDefaultPoints(command) +
                calculateHousePoints(command.house?.ownershipStatus) +
                calculateMarriedPoints(command.maritalStatus) +
                calculateDependentPoints(command.dependents)

        return points.toProfileDescription()
    }

    private fun calculateDependentPoints(dependents: Int) =
        if (dependents > 0)
            1
        else
            0

    private fun calculateHousePoints(ownershipStatus: String?) =
        if (ownershipStatus != null && ownershipStatus =="mortgaged")
            1
        else
            0

    private fun calculateMarriedPoints(martialStatus: String) =
        if (martialStatus == "married")
            -1
        else
            0

}