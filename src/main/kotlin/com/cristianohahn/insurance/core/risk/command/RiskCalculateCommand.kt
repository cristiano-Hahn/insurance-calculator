package com.cristianohahn.insurance.core.risk.command

data class RiskCalculateCommand(
    val age: Int,
    val dependents: Int,
    val income: Int,
    val maritalStatus: String,
    val riskQuestions: List<Int>,
    val house: RiskCalculateRequestHouse?,
    val vehicle: RiskCalculateRequestVehicle?
) {
    data class RiskCalculateRequestHouse(
        val ownershipStatus: String
    )

    data class RiskCalculateRequestVehicle(
        val year: Int
    )
}

