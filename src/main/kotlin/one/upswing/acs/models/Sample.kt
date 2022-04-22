package one.upswing.acs.models

import com.fasterxml.jackson.databind.ObjectMapper





enum class PersonType (val role: String, val roleText: String, val permissions: List<Int>) {
    EMPLOYEE("EMP", "Employee", listOf(10, 20, 40)),
    CUSTOMER("CST", "Customer", listOf(10, 30, 50)),
    PARTNER("PTN", "Partner", listOf(10, 50)),
    UNKNOWN("UKN", "Unknown", listOf());

}

var objectMapper = ObjectMapper()
var result = objectMapper.writeValueAsString(PersonType.CUSTOMER)
