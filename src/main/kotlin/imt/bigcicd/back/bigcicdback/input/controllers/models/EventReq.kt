package imt.bigcicd.back.bigcicdback.input.controllers.models

data class EventReq(
    val ref: String = "", // commit id
    val repository: Repository = Repository(),
    val sender: Sender = Sender(),
)

data class Repository(
    val name: String = "",
    val url: String = "",
)

data class Sender(
    val id: Int = 0,
)