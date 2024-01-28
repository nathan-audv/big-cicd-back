package imt.bigcicd.back.bigcicdback.input.controllers.pipeline

import imt.bigcicd.back.bigcicdback.domain.models.FinishReq
import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.domain.models.RepositoryReq
import imt.bigcicd.back.bigcicdback.domain.usecases.FinishPipelineUseCase
import imt.bigcicd.back.bigcicdback.domain.usecases.GetPipelineUseCase
import imt.bigcicd.back.bigcicdback.domain.usecases.GetPipelinesUseCase
import imt.bigcicd.back.bigcicdback.domain.usecases.StartCdUseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.LightPipeline
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class PipelineController(
    val startCdUseCase: StartCdUseCase,
    val getPipelinesUseCase: GetPipelinesUseCase,
    val getPipelineUseCase: GetPipelineUseCase,
    val finishPipelineUseCase: FinishPipelineUseCase
) : PipelineResource {
    override fun startDeployment(repository: String, tag: String, userId: Long): ResponseEntity<String> {
        return ResponseEntity.ok(startCdUseCase.command(RepositoryReq(userId, repository, tag)))
    }

    override fun getPipelines(page: Int, size: Int): ResponseEntity<List<LightPipeline>> {
        return ResponseEntity.ok(
            getPipelinesUseCase.command(PageRequest.of(page, size))
                .map { LightPipeline.fromPipeline(it) }
        )
    }

    override fun getPipeline(id: String): ResponseEntity<Pipeline> {
        return ResponseEntity.ok(getPipelineUseCase.command(id))
    }

    override fun finishPipeline(id: String, status: String): ResponseEntity<Unit> {
        finishPipelineUseCase.command(FinishReq(id, status))
        return ResponseEntity.ok().build()
    }
}