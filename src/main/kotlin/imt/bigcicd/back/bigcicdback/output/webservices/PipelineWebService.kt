package imt.bigcicd.back.bigcicdback.output.webservices

import imt.bigcicd.back.bigcicdback.output.webservices.models.PipelineReq
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class PipelineWebService(
    val restClient: RestClient
) : WebService() {
    private val startCicdPath = "pipeline.post.start.cicd.v1"
    private val startCdPath = "pipeline.post.start.cd.v1"

    @Value("\${app.api.pipeline.url}")
    val pipelineUrl: String = ""

    fun startCicd(id: String, ref: String, repository: String) {
        restClient.post()
            .uri(getUrl(pipelineUrl, startCicdPath))
            .contentType(MediaType.APPLICATION_JSON)
            .body(PipelineReq(id, ref, repository))
            .retrieve()
            .toBodilessEntity()
    }

    fun startCd() {
        restClient.post()
            .uri(getUrl(pipelineUrl, startCdPath))
            .contentType(MediaType.APPLICATION_JSON)
            .retrieve()
            .toBodilessEntity()
    }
}