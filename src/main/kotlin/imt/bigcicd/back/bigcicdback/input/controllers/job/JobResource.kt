package imt.bigcicd.back.bigcicdback.input.controllers.job

import imt.bigcicd.back.bigcicdback.input.controllers.models.JobDTOReq
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/jobs")
interface JobResource {
    @PostMapping("/{id}")
    fun addJob(@PathVariable id: String, @RequestBody job: JobDTOReq): ResponseEntity<Unit>
}