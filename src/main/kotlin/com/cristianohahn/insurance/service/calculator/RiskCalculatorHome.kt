package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskCalculatorHome : RiskCalculator() {

    override fun calculateRiskProfile(command: RiskCalculateCommand): String {
        if (command.house == null) {
            return "ineligible"
        }

        val points = calculateDefaultPoints(command) + calculateHousePoints(command.house.ownershipStatus)

        return points.toProfileDescription()
    }

    private fun calculateHousePoints(ownershipStatus: String?) =
        if (ownershipStatus != null && ownershipStatus == "mortgaged")
            1
        else
            0
}