package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.PipelineNotFoundException
import imt.bigcicd.back.bigcicdback.domain.models.Job
import imt.bigcicd.back.bigcicdback.domain.models.JobReq
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component

@Component
class AddJobUseCase(
    val pipelineService: PipelineService
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
        } ?: throw PipelineNotFoundException(request.id)
    }
}