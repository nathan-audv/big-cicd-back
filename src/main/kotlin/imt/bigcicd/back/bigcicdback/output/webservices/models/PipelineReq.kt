package imt.bigcicd.back.bigcicdback.output.webservices.models

import kotlinx.serialization.Serializable

@Serializable
data class PipelineReq(
    val id: String = "",
    val ref: String = "",
    val repository: String = "",
)