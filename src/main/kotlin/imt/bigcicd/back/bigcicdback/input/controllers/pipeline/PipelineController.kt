package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import imt.bigcicd.back.bigcicdback.domain.usecases.StartCdUseCase
import imt.bigcicd.back.bigcicdback.domain.models.RepositoryReq
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PipelineController(
    val startCdUseCase: StartCdUseCase
) : PipelineResource {
    override fun startDeployment(repository: String, tag: String): ResponseEntity<Unit> {
        startCdUseCase.command(RepositoryReq(repository, tag))
        return ResponseEntity.ok().build()
    }
}