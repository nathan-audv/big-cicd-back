package imt.bigcicd.back.bigcicdback.domain.models

import imt.bigcicd.back.bigcicdback.domain.utils.getZonedDate
import imt.bigcicd.back.bigcicdback.output.database.models.JobModel
import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import org.bson.types.ObjectId
import java.time.ZonedDateTime

data class Pipeline(
    val id: String = ObjectId().toHexString(),
    val ref: String = "",
    val user: Long = 0,
    val repository: String = "",
    val date: ZonedDateTime = ZonedDateTime.now(),
    val time: Long? = null,
    val jobs: MutableList<Job> = mutableListOf()
) {
    companion object {
        fun fromModel(model: PipelineModel) = Pipeline(
            id = model.id,
            ref = model.ref,
            user = model.user,
            repository = model.repository,
            date = model.date.getZonedDate(),
            time = model.time,
            jobs = model.jobs.map { Job.fromModel(it) }.toMutableList()
        )
    }
}

data class Job(
    val name: String = "",
    val logs: String = "",
    val status: String = "",
    val date: ZonedDateTime = ZonedDateTime.now()
) {
    companion object {
        fun fromModel(model: JobModel) = Job(
            name = model.name,
            logs = model.logs,
            status = model.status,
            date = model.date.getZonedDate()
        )
    }
}