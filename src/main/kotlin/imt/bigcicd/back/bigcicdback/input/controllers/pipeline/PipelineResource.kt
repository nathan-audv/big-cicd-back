package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@RequestMapping("/v1/pipelines")
interface PipelineResource {
    @PostMapping("/repository/{repository}/tag/{tag}")
    fun startDeployment(@PathVariable repository: String, @PathVariable tag: String): ResponseEntity<Unit>

    @GetMapping
    fun getPipelines(
        @RequestParam page: Int = 0,
        @RequestParam size: Int = 25,
    ): ResponseEntity<List<Pipeline>>
}