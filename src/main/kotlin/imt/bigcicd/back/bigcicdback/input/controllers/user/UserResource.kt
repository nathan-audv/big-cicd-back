package imt.bigcicd.back.bigcicdback.input.controllers.user

import imt.bigcicd.back.bigcicdback.input.controllers.models.UserData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/users")
interface UserResource {
    @PostMapping
    fun userLogin(@RequestBody code: String): ResponseEntity<UserData>
}