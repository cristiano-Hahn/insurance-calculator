package com.cristianohahn.insurance.service.calculator

import com.cristianohahn.insurance.service.command.RiskProfileCalculateCommand
import org.springframework.stereotype.Service
import java.util.*

@Service
class RiskProfileCalculatorAuto : RiskProfileCalculator() {

    override fun calculate(command: RiskProfileCalculateCommand): String {
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