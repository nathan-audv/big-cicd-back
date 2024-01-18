package imt.bigcicd.back.bigcicdback.output.webservices

import imt.bigcicd.back.bigcicdback.output.webservices.models.CdReq
import imt.bigcicd.back.bigcicdback.output.webservices.models.CicdReq
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
            .body(CicdReq(id, ref, repository))
            .retrieve()
            .toBodilessEntity()
    }

    fun startCd(id: String, repository: String, tag: String) {
        restClient.post()
            .uri(getUrl(pipelineUrl, startCdPath))
            .contentType(MediaType.APPLICATION_JSON)
            .body (CdReq(id, repository, tag))
            .retrieve()
            .toBodilessEntity()
    }
}