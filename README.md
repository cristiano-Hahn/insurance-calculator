# Insurance risk calculator
The project consists of creating, in the REST standard, an API to calculate risks of insurances based on user information. This project just have one feature that receive the user information, calculate the insurance, and returns the risk profile.

## About The API

The API consist just with one endpoint, that will receive a JSON with user information and calculate the risk profile.

### The request
The request is a POST on /risk/calculate endpoint

Name | Type | Required
--- | --- |---
age | Integer | true
dependents | Integer | true
house.ownership_status | String | false
income | Float | true
marital_status | String | true
risk_questions | Array of Integer | true
vehicle.year | Integer | false
