package com.cristianohahn.insurance.core.risk.calculator

import com.cristianohahn.insurance.core.risk.command.RiskCalculateCommand
import org.springframework.stereotype.Service
import java.util.*

@Service
class RiskAutoCalculator : RiskCalculator() {

    override fun calculateRiskProfile(command: RiskCalculateCommand): String {
        if (command.vehicle == null) {
            return "ineligible"
        }

        val points = calculateDefaultPoints(command) + calculateVehicleAgePoints(command.vehicle.year)

        return points.toProfileDescription()
    }

    private fun calculateVehicleAgePoints(vehicleYear: Int): Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        return if (currentYear - vehicleYear <= 5)
            1
        else
            0
    }
}