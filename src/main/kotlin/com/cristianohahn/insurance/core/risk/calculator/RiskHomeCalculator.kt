package com.cristianohahn.insurance.core.risk.calculator

import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskHomeCalculator : RiskCalculator() {

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