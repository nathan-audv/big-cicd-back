package imt.bigcicd.back.bigcicdback.output.database.models

import imt.bigcicd.back.bigcicdback.domain.models.Job
import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.getStringDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "pipelines")
data class PipelineModel(
    @Id
    val id: String = "",
    val ref: String = "",
    val user: Long = 0,
    val repository: String = "",
    val date: String = "",
    val time: Long? = null,
    val jobs: List<JobModel> = listOf()
) {
    companion object {
        fun fromDomain(domain: Pipeline) = PipelineModel(
            id = domain.id,
            ref = domain.ref,
            user = domain.user,
            repository = domain.repository,
            date = domain.date.getStringDate(),
            time = domain.time,
            jobs = domain.jobs.map { JobModel.fromDomain(it) }
        )
    }

}

data class JobModel(
    val name: String = "",
    val logs: String = "",
    val status: String = "",
    val date: String = ""
) {
    companion object {
        fun fromDomain(domain: Job) = JobModel(
            name = domain.name,
            logs = domain.logs,
            status = domain.status,
            date = domain.date.getStringDate()
        )
    }
}