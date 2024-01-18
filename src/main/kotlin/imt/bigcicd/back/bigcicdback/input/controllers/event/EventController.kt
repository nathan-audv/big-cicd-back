package imt.bigcicd.back.bigcicdback.input.controllers.event

import imt.bigcicd.back.bigcicdback.domain.usecases.StartCicdUseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.EventReq
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(
    val startCicdUseCase: StartCicdUseCase
) : EventResource {
    override fun push(event: EventReq): ResponseEntity<Unit> {
        startCicdUseCase.command(event)
        return ResponseEntity.ok().build()
    }
}