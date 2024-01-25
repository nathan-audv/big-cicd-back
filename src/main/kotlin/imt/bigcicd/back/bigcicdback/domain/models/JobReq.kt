package imt.bigcicd.back.bigcicdback.domain.models

data class JobReq(
    val id: String, // pipeline id
    val name: String,
    val logs: String,
    val status: String
)