package imt.bigcicd.back.bigcicdback.domain

import imt.bigcicd.back.bigcicdback.domain.utils.getZonedDate
import imt.bigcicd.back.bigcicdback.output.database.models.JobModel
import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import java.time.ZonedDateTime

data class Pipeline(
    val id: String = "",
    val ref: String = "",
    val user: String = "",
    val repository: String = "",
    val pushDate: ZonedDateTime = ZonedDateTime.now(),
    val jobs: List<Job> = listOf()
) {
    companion object {
        fun fromModel(model: PipelineModel) = Pipeline(
            id = model.id,
            ref = model.ref,
            user = model.user,
            repository = model.repository,
            pushDate = model.pushDate.getZonedDate(),
            jobs = model.jobs.map { Job.fromModel(it) }
        )
    }
}

data class Job(
    val jobName: String = "",
    val logs: String = "",
    val status: String = "",
    val date: ZonedDateTime = ZonedDateTime.now()
) {
    companion object {
        fun fromModel(model: JobModel) = Job(
            jobName = model.jobName,
            logs = model.logs,
            status = model.status,
            date = model.date.getZonedDate()
        )
    }
}