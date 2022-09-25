package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.calculator.base.RiskProfileCalculator
import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import org.springframework.stereotype.Service

@Service
class RiskProfileCalculatorHome : RiskProfileCalculator() {

    override fun calculate(command: RiskProfileCalculateCommand): String {
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