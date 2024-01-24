package imt.bigcicd.back.bigcicdback.output.webservices.models

import com.fasterxml.jackson.annotation.JsonProperty

data class UserIdRes (
    @JsonProperty("id")
    val id: Long,
)