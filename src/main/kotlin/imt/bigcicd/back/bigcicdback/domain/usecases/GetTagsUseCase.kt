package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.RegistryService
import org.springframework.stereotype.Component

@Component
class GetTagsUseCase(
    val registryService: RegistryService
) : UseCase<String, List<String>> {
    override fun command(request: String): List<String> {
        return registryService.getTags(request)
    }
}