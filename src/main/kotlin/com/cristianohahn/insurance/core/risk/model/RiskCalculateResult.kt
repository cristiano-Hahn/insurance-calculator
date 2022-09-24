package com.cristianohahn.insurance.core.risk.model

data class RiskCalculateResult(
    val auto: String,
    val disability: String,
    val home: String,
    val life: String,
)