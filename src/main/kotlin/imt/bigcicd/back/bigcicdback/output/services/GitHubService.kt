package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.output.webservices.GitHubWebService
import org.springframework.stereotype.Service

@Service
class GitHubService(
    val gitHubWebService: GitHubWebService
) {
    fun getAccessToken(code: String): String? = gitHubWebService.getAccessToken(code)?.accessToken

    fun getUserId(accessToken: String): Int? = gitHubWebService.getUserId(accessToken)?.id
}