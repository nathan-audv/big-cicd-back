package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.output.webservices.RegistryWebService
import org.springframework.stereotype.Service

@Service
class RegistryService(
    val registryWebService: RegistryWebService
) {
    fun getTags(registry: String): List<String> = registryWebService.getTags(registry)
}