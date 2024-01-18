package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.domain.Pipeline
import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import imt.bigcicd.back.bigcicdback.output.database.repositories.PipelineRepository
import imt.bigcicd.back.bigcicdback.output.webservices.PipelineWebService
import org.springframework.stereotype.Service

@Service
class PipelineService(
    val pipelineRepository: PipelineRepository,
    val pipelineWebService: PipelineWebService,
) {
    fun savePipeline(pipeline: Pipeline): PipelineModel = pipelineRepository.save(PipelineModel.fromDomain(pipeline))

    fun startCicd(id: String, ref: String, repository: String) = pipelineWebService.startCicd(id, ref, repository)

    fun startCd(id: String, repository: String, tag: String) = pipelineWebService.startCd(id, repository, tag)
}