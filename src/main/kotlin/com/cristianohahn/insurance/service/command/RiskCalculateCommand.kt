package com.cristianohahn.insurance.service.command

import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.Pattern
import javax.validation.constraints.PositiveOrZero

data class RiskCalculateCommand(
    @get:Min(1)
    val age: Int,
    @get:PositiveOrZero
    val dependents: Int,
    @get:PositiveOrZero
    val income: Int,
    @get:Pattern(regexp = "single|married")
    val maritalStatus: String,
    val riskQuestions: List<Int>,
    @get:Valid
    val house: RiskCalculateRequestHouse?,
    @get:Valid
    val vehicle: RiskCalculateRequestVehicle?
) {
    data class RiskCalculateRequestHouse(
        @get:Pattern(regexp = "owned|mortgaged")
        val ownershipStatus: String
    )

    data class RiskCalculateRequestVehicle(
        @get:PositiveOrZero
        val year: Int
    )
}

