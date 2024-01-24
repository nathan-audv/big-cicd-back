package imt.bigcicd.back.bigcicdback.input.controllers.models

import com.fasterxml.jackson.annotation.JsonProperty

data class UserData(
    val id: Int,
    @JsonProperty("access_token")
    val accessToken: String,
)
