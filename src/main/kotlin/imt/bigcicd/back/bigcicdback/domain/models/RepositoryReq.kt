package imt.bigcicd.back.bigcicdback.domain.models

data class RepositoryReq(
    val userId: Long,
    val repository: String,
    val tag: String
)