package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.GitHubException
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.UserData
import imt.bigcicd.back.bigcicdback.output.services.GitHubService
import imt.bigcicd.back.bigcicdback.output.webservices.models.UserIdRes
import org.springframework.stereotype.Component

@Component
class GetUserDataUseCase(
    val gitHubService: GitHubService
) : UseCase<String, UserData> {
    override fun command(request: String): UserData {
        return gitHubService.getAccessToken(request)?.let {
            val id = gitHubService.getUserId(it) ?: throw GitHubException()
            UserData(id, it)
        } ?: throw GitHubException()
    }
}