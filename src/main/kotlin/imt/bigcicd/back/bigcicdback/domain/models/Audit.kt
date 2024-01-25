package imt.bigcicd.back.bigcicdback.domain.models

import java.time.ZonedDateTime
import imt.bigcicd.back.bigcicdback.domain.utils.getZonedDate
import imt.bigcicd.back.bigcicdback.output.database.models.AuditModel
import org.bson.types.ObjectId

data class Audit (
    val id: String = ObjectId().toHexString(),
    val idUser: Long = 0,
    val idPipeline: String = "",
    val jobName: String = "",
    val jobLogs: String = "",
    val jobDate: ZonedDateTime = ZonedDateTime.now()
) {
    companion object {
        fun fromModel(model: AuditModel) = Audit(
            id = model.id,
            idUser = model.idUser,
            idPipeline = model.idPipeline,
            jobName = model.jobName,
            jobLogs = model.jobLogs,
            jobDate = model.jobDate.getZonedDate()
        )
    }
}