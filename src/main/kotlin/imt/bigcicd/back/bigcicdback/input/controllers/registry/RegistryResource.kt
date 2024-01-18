package imt.bigcicd.back.bigcicdback.input.controllers.registry

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/registries")
interface RegistryResource {
    @GetMapping("/{repository}")
    fun getTags(@PathVariable repository: String): ResponseEntity<List<String>>
}