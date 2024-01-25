package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.PipelineNotFoundException
import imt.bigcicd.back.bigcicdback.domain.models.Audit
import imt.bigcicd.back.bigcicdback.domain.models.Job
import imt.bigcicd.back.bigcicdback.domain.models.JobReq
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.AuditService
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component

@Component
class AddJobUseCase(
    val pipelineService: PipelineService,
    val auditService: AuditService
) : UseCase<JobReq, Unit> {
    override fun command(request: JobReq) {
        pipelineService.findById(request.id)?.let { pipeline ->
            pipeline.jobs.add(
                Job(
                    step = request.step,
                    logs = request.logs,
                    status = request.status
                )
            )
            pipelineService.savePipeline(pipeline)
            auditService.saveAudit(
                Audit(
                    idUser = pipeline.user,
                    idPipeline = request.id,
                    jobStep = pipeline.jobs.last().step,
                    jobLogs = pipeline.jobs.last().logs,
                    jobDate = pipeline.jobs.last().date
                )
            )
        } ?: throw PipelineNotFoundException(request.id)
    }
}