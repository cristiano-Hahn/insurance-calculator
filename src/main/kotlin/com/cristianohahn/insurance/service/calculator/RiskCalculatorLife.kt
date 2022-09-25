package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskCalculatorLife : RiskCalculator() {

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