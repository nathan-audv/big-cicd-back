package imt.bigcicd.back.bigcicdback.output.webservices.models

import com.fasterxml.jackson.annotation.JsonProperty

data class AccessTokenReq (
    val code: String,
    @JsonProperty("client_id")
    val clientId: String,
    @JsonProperty("client_secret")
    val clientSecret: String,
)