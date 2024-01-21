package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.EventReq
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component

@Component
class StartCicdUseCase(
    val pipelineService: PipelineService,
) : UseCase<EventReq, Unit> {
    override fun command(request: EventReq) {
        val (ref, repository, sender) = request
        pipelineService.savePipeline(
            Pipeline(
                ref = ref,
                user = sender.id.toString(),
                repository = repository.url,
            )
        ).let {
            pipelineService.startCicd(
                it.id,
                it.ref,
                it.repository
            )
        }
    }
}