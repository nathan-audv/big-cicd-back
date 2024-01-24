package imt.bigcicd.back.bigcicdback.input.controllers.user

import imt.bigcicd.back.bigcicdback.domain.usecases.GetUserDataUseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.UserData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val getUserDataUseCase: GetUserDataUseCase
) : UserResource {
    override fun userLogin(code: String): ResponseEntity<UserData> {
        return ResponseEntity.ok(getUserDataUseCase.command(code))
    }
}