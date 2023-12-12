package imt.bigcicd.back.bigcicdback.input.controller.github

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/v1/github")
interface GithubResource {
    @PostMapping("/push")
    fun push()
}