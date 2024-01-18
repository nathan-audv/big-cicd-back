package imt.bigcicd.back.bigcicdback.input.controllers.registry

import imt.bigcicd.back.bigcicdback.domain.usecases.GetTagsUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class RegistryController(
    val getTagsUseCase: GetTagsUseCase
) : RegistryResource {
    override fun getTags(repository: String): ResponseEntity<List<String>> {
        return ResponseEntity.ok(getTagsUseCase.command(repository))
    }

}