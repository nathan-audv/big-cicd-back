package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.input.controllers.models.LightPipeline
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/v1/pipelines")
interface PipelineResource {
    @PostMapping("/repository/{repository}/tag/{tag}")
    fun startDeployment(@PathVariable repository: String, @PathVariable tag: String): ResponseEntity<Unit>

    @GetMapping
    fun getPipelines(
        @RequestParam page: Int = 0,
        @RequestParam size: Int = 25,
    ): ResponseEntity<List<LightPipeline>>

    @GetMapping("/{id}")
    fun getPipeline(@PathVariable id: String): ResponseEntity<Pipeline>

    @PostMapping("/{id}/finish")
    fun finishPipeline(@PathVariable id: String): ResponseEntity<Unit>
}