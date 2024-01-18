package imt.bigcicd.back.bigcicdback.output.webservices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import java.text.MessageFormat

abstract class WebService {
    @Autowired
    private lateinit var environement: Environment

    fun getUrl(baseUrl: String, path: String, vararg args: String): String {
        return environement.getProperty(path).let {
            MessageFormat.format("$baseUrl$it", *args)
        }
    }
}