package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.PipelineNotFoundException
import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component

@Component
class GetPipelineUseCase(
    private val pipelineService: PipelineService
) : UseCase<String, Pipeline> {
    override fun command(request: String): Pipeline {
        return pipelineService.findById(request) ?: throw PipelineNotFoundException("Pipeline not found")
    }
}