package imt.bigcicd.back.bigcicdback.output.webservices

import imt.bigcicd.back.bigcicdback.output.webservices.models.AccessTokenReq
import imt.bigcicd.back.bigcicdback.output.webservices.models.AccessTokenRes
import imt.bigcicd.back.bigcicdback.output.webservices.models.UserIdRes
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestClient

@Service
class GitHubWebService(
    val restClient: RestClient
) : WebService() {
    private val getAccessTokenPath = "github.get.access_token"
    private val getUserIdPath = "github-api.get.user.id"

    @Value("\${app.api.github.url}")
    val githubUrl: String = ""

    @Value("\${app.api.github.id}")
    val githubClientId: String = ""

    @Value("\${app.api.github.secret}")
    val githubClientSecret: String = ""

    @Value("\${app.api.github-api.url}")
    val githubApiUrl: String = ""


    fun getAccessToken(code: String): AccessTokenRes? {
        return restClient.post()
            .uri(getUrl(githubUrl, getAccessTokenPath))
            .header("Accept", "application/json")
            .header("Content-Type", "application/json")
            .body(AccessTokenReq(code, githubClientId, githubClientSecret))
            .retrieve()
            .body(AccessTokenRes::class.java)
    }

    fun getUserId(accessToken: String): UserIdRes? {
        return restClient.get()
            .uri(getUrl(githubApiUrl, getUserIdPath))
            .header("Accept", "application/json")
            .header("Authorization", "Bearer $accessToken")
            .retrieve()
            .body(UserIdRes::class.java)
    }
}