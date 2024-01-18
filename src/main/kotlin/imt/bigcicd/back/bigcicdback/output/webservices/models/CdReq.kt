package imt.bigcicd.back.bigcicdback.output.webservices.models

import kotlinx.serialization.Serializable

@Serializable
data class CdReq(
    val id: String = "",
    val repository: String = "",
    val tag: String = "",
)