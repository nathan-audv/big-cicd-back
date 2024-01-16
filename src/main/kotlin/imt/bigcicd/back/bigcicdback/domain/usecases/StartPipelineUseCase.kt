package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.Pipeline
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.EventReq
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import imt.bigcicd.back.bigcicdback.output.webservices.PipelineWebService
import org.springframework.stereotype.Component

@Component
class StartPipelineUseCase(
    val pipelineService: PipelineService,
    val pipelineWebService: PipelineWebService
) : UseCase<EventReq, Unit> {
    override fun command(request: EventReq) {
        pipelineService.savePipeline(
            Pipeline(
                ref = request.ref,
                user = request.sender.id.toString(),
                repository = request.repository.url,
                jobs = listOf()
            )
        ).let {
            pipelineWebService.startCicd(
                it.id,
                it.ref,
                it.repository
            )
        }
    }
}