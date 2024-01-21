package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Component

@Component
class GetPipelinesUseCase(
    private val pipelineService: PipelineService
) : UseCase<Pageable, List<Pipeline>> {
    override fun command(request: Pageable): List<Pipeline> {
        return pipelineService.findAllPaginated(request)
    }
}