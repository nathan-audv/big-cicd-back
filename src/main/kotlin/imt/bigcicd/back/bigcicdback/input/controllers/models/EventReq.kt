package imt.bigcicd.back.bigcicdback.input.controllers.models

import com.fasterxml.jackson.annotation.JsonProperty

data class EventReq(
    val ref: String,
    val after: String,
    val repository: Repository
)

data class Repository(
    @JsonProperty("full_name")
    val fullName: String
)