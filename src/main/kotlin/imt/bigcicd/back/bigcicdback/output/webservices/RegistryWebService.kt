package imt.bigcicd.back.bigcicdback.output.webservices

import imt.bigcicd.back.bigcicdback.output.webservices.models.TagsRes
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class RegistryWebService(
    val restClient: RestClient
) : WebService() {
    private val getTagsPath = "registry.get.repository.tags.v2"

    @Value("\${app.api.registry.url}")
    val registryUrl: String = ""

    fun getTags(repository: String): List<String> {
        return restClient.get()
            .uri(getUrl(registryUrl, repository))
            .retrieve()
            .body(TagsRes::class.java).let {
                it?.tags ?: listOf()
            }
    }
}