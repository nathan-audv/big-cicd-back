package imt.bigcicd.back.bigcicdback.input.controllers.models

data class JobDTOReq(
    val step: String,
    val logs: String,
    val status: String,
    val date: String,
)
