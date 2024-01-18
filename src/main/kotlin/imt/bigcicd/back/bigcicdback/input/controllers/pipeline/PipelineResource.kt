package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/pipelines")
interface PipelineResource {
    @PostMapping("/repository/{repository}/tag/{tag}")
    fun startDeployment(@PathVariable repository: String, @PathVariable tag: String): ResponseEntity<Unit>
}