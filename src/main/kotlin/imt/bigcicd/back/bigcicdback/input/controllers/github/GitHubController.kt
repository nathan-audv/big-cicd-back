package imt.bigcicd.back.bigcicdback.input.controllers.github

import imt.bigcicd.back.bigcicdback.domain.usecases.GetUserDataUseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.UserData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class GitHubController(
    private val getUserDataUseCase: GetUserDataUseCase
) : GitHubResource {
    override fun userLogin(code: String): ResponseEntity<UserData> {
        return ResponseEntity.ok(getUserDataUseCase.command(code))
    }
}