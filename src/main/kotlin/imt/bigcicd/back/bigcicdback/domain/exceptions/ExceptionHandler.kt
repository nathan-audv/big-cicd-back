package imt.bigcicd.back.bigcicdback.domain.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(value = [RepositoryNotFoundException::class, PipelineNotFoundException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun notFoundException(exception: Exception): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [InternalException::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun internalException(exception: Exception): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [RepositoryException::class, RunnerException::class, GitHubException::class])
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    fun externalException(exception: Exception): ResponseEntity<String> {
        return ResponseEntity(exception.message, HttpStatus.SERVICE_UNAVAILABLE)
    }
}