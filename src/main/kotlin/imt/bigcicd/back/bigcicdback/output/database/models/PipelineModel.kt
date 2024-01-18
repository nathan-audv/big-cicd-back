package imt.bigcicd.back.bigcicdback.output.database.models

import imt.bigcicd.back.bigcicdback.domain.Job
import imt.bigcicd.back.bigcicdback.domain.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.getStringDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pipelines")
data class PipelineModel(
    @Id
    val id: String = "",
    val ref: String = "",
    val user: String = "",
    val repository: String = "",
    val pushDate: String = "",
    val jobs: List<JobModel> = listOf()
) {
    companion object {
        fun fromDomain(domain: Pipeline) = PipelineModel(
            id = domain.id,
            ref = domain.ref,
            user = domain.user,
            repository = domain.repository,
            pushDate = domain.pushDate.getStringDate(),
            jobs = domain.jobs.map { JobModel.fromDomain(it) }
        )
    }

}

data class JobModel(
    val jobName: String = "",
    val logs: String = "",
    val status: String = "",
    val date: String = ""
) {
    companion object {
        fun fromDomain(domain: Job) = JobModel(
            jobName = domain.jobName,
            logs = domain.logs,
            status = domain.status,
            date = domain.date.getStringDate()
        )
    }
}