package com.cristianohahn.insurance.core.risk.calculator

import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskLifeCalculator : RiskCalculator() {

    override fun calculateRiskProfile(command: RiskCalculateCommand): String {
        if (command.age > 60) {
            return "ineligible"
        }

        val points = calculateDefaultPoints(command) +
                calculateDependentPoints(command.dependents) +
                calculateMarriedPoints(command.maritalStatus)

        return points.toProfileDescription()
    }

    private fun calculateDependentPoints(dependents: Int) =
        if (dependents > 0)
            1
        else
            0

    private fun calculateMarriedPoints(martialStatus: String) =
        if (martialStatus == "married")
            1
        else
            0

}