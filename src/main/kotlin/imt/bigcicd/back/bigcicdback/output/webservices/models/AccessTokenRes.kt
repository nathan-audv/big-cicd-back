package imt.bigcicd.back.bigcicdback.output.webservices.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AccessTokenRes(
    @JsonProperty("access_token")
    val accessToken: String,
)
