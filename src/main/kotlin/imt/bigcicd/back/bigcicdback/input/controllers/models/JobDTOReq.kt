package imt.bigcicd.back.bigcicdback.input.controllers.models

data class JobDTOReq(
    val name: String,
    val logs: String,
    val status: String
)
