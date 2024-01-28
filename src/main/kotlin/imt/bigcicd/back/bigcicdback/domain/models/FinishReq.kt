package imt.bigcicd.back.bigcicdback.domain.models

data class FinishReq (
    val id: String, // pipeline id
    val status: String
)