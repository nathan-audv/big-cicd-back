package imt.bigcicd.back.bigcicdback.input.controller.github

import org.springframework.web.bind.annotation.RestController

@RestController
class GithubController : GithubResource {
    override fun push(body: String) {
        println(body)
    }
}