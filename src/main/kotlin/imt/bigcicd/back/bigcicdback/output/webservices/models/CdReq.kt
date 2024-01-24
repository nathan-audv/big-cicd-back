package imt.bigcicd.back.bigcicdback.output.webservices.models

import kotlinx.serialization.Serializable

@Serializable
data class CdReq(
    val id: String = "",
    val image: String = "",
    val tag: String = "",
)