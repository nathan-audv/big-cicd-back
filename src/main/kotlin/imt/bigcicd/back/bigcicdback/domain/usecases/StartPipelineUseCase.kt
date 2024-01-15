package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.EventReq
import org.springframework.stereotype.Component

@Component
class StartPipelineUseCase : UseCase<EventReq, Unit> {
    override fun command(request: EventReq) {
        println(request) //TODO call pipeline
    }
}