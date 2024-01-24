package imt.bigcicd.back.bigcicdback.input.controllers.github

import imt.bigcicd.back.bigcicdback.input.controllers.models.UserData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/users")
interface GitHubResource {
    @PostMapping
    fun userLogin(@RequestBody code: String): ResponseEntity<UserData>
}