package imt.bigcicd.back.bigcicdback.output.database.models

import imt.bigcicd.back.bigcicdback.domain.models.Audit
import imt.bigcicd.back.bigcicdback.domain.utils.getStringDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
@Document(collection = "audits")
data class AuditModel(
        @Id
    val id: String = "",
        val idUser: Long = 0,
        val idPipeline: String = "",
        val jobStep: String = "",
        val jobLogs: String = "",
        val jobDate: String = ""
) {
    companion object {
        fun fromDomain(domain: Audit) = AuditModel(
            id = domain.id,
            idUser = domain.idUser,
            idPipeline = domain.idPipeline,
            jobStep = domain.jobStep,
            jobLogs = domain.jobLogs,
            jobDate = domain.jobDate.getStringDate()
        )
    }

}