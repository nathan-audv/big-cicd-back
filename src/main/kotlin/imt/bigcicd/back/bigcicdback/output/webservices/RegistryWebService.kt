package imt.bigcicd.back.bigcicdback.output.webservices

import imt.bigcicd.back.bigcicdback.domain.exceptions.InternalException
import imt.bigcicd.back.bigcicdback.domain.exceptions.RepositoryException
import imt.bigcicd.back.bigcicdback.domain.exceptions.RepositoryNotFoundException
import imt.bigcicd.back.bigcicdback.output.webservices.models.TagsRes
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
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
            .uri(getUrl(registryUrl, getTagsPath, repository))
            .retrieve()
            .onStatus({ status -> status.isSameCodeAs(HttpStatus.NOT_FOUND)}, { _, _ -> throw RepositoryNotFoundException(repository)})
            .onStatus({ status -> status.is4xxClientError }, { _, _ -> throw RepositoryException()})
            .onStatus({ status -> status.is5xxServerError }, { _, _ -> throw InternalException()})
            .body(TagsRes::class.java).let {
                it?.tags ?: listOf()
            }
    }
}