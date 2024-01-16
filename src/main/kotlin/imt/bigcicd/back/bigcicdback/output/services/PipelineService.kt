package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.domain.Pipeline
import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import imt.bigcicd.back.bigcicdback.output.database.repositories.PipelineRepository
import org.springframework.stereotype.Service

@Service
class PipelineService(
    val pipelineRepository: PipelineRepository
) {
    fun savePipeline(pipeline: Pipeline): PipelineModel = pipelineRepository.save(PipelineModel.fromDomain(pipeline))
}