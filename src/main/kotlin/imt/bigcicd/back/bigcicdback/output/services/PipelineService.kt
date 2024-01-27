package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import imt.bigcicd.back.bigcicdback.output.database.repositories.PipelineRepository
import imt.bigcicd.back.bigcicdback.output.webservices.RunnerWebService
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PipelineService(
    val pipelineRepository: PipelineRepository,
    val runnerWebService: RunnerWebService,
) {
    fun savePipeline(pipeline: Pipeline): Pipeline =
        Pipeline.fromModel(pipelineRepository.save(PipelineModel.fromDomain(pipeline)))

    fun startCicd(id: String, ref: String, repository: String) = runnerWebService.startCicd(id, ref, repository)

    fun startCd(id: String, repository: String, tag: String) = runnerWebService.startCd(id, repository, tag)

    fun findAllPaginated(pageable: Pageable): List<Pipeline> {
        return pipelineRepository.findAll(pageable)
            .toList()
            .map { Pipeline.fromModel(it) }
    }

    fun findById(id: String): Pipeline? {
        return pipelineRepository.findByIdOrNull(id)?.let { Pipeline.fromModel(it) }
    }
}