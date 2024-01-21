package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.usecases.StartCdUseCase
import imt.bigcicd.back.bigcicdback.domain.models.RepositoryReq
import imt.bigcicd.back.bigcicdback.domain.usecases.GetPipelinesUseCase
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PipelineController(
    val startCdUseCase: StartCdUseCase,
    val getPipelinesUseCase: GetPipelinesUseCase
) : PipelineResource {
    override fun startDeployment(repository: String, tag: String): ResponseEntity<Unit> {
        startCdUseCase.command(RepositoryReq(repository, tag))
        return ResponseEntity.ok().build()
    }

    override fun getPipelines(page: Int, size: Int): ResponseEntity<List<Pipeline>> {
        return getPipelinesUseCase.command(PageRequest.of(page, size)).let { ResponseEntity.ok(it) }
    }
}