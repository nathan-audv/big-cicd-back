package imt.bigcicd.back.bigcicdback.domain.models

data class JobReq(
    val id: String,
    val step: String,
    val logs: String,
    val status: String,
    val date: String,
)