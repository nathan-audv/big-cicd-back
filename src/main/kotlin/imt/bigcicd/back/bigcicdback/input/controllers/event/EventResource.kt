package imt.bigcicd.back.bigcicdback.input.controllers.event

import imt.bigcicd.back.bigcicdback.input.controllers.models.EventReq
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/events")
interface EventResource {
    @PostMapping
    fun push(@RequestBody event: EventReq): ResponseEntity<Unit>
}