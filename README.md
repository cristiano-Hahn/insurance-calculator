# Insurance risk calculator
The project consists of creating, in the REST standard, an API to calculate risks of insurances based on user information. This project just have one feature that receive the user information, calculate the insurance, and returns the risk profile.

## About The API

The API consist just with one endpoint, that will receive a JSON with user information and calculate the risk profile.

### The request
Request is a POST on  `/risk_profile/calculate`  endpoint. The fields are:

Name | Type | Required
--- | --- |---
age | Integer | true
dependents | Integer | true
house.ownership_status | String | false
income | Float | true
marital_status | String | true
risk_questions | Array of Integer | true
vehicle.year | Integer | false

Example of request:

```bash
curl --location --request POST 'http://localhost:8080/risk_profile/calculate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "age": -1,
    "dependents": "1",
    "income": 6000,
    "marital_status": "single",
    "risk_questions": [0,0,0],
    "vehicle": {
        "year": 2020
    },
    "house": {
        "ownership_status": "mortgaged"
    }
}'
```

### Response
The request is a JSON with the following fields: 

Name | Type | Nullable | Values
--- | --- |--- |---
auto | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
disability | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
home | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`
life | String | false | `"economic"` , `"regular"` ,  `"responsible"` , `"ineligible"`

Example of response: 

```JSON
{
  "auto": "economic",
  "disability": "economic",
  "home": "economic",
  "life": "economic"
}
```

## Running it locally

This project was created with Kotlin and need JAVA JDK 17 to run it locally 
###Step by step
1. Download java JDK 17 ([Download Here](https://jdk.java.net/archive/))
2. Set the `JAVA_HOME` environment with the path of your downloaded java
3. Execute the command `./gradlew clean build`, it will build the project and run all the tests
4. Execute the command `./gradlew bootRun`, it will start the service

Optional: You can just run the tests with the `./gradlew test` command

Note: this service will start on port `8080`, if you want to change it, just change the property `server.port` on `application.properties` file.