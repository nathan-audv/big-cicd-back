package imt.bigcicd.back.bigcicdback.input.controllers.job

import imt.bigcicd.back.bigcicdback.domain.models.JobReq
import imt.bigcicd.back.bigcicdback.domain.usecases.AddJobUseCase
import imt.bigcicd.back.bigcicdback.input.controllers.models.JobDTOReq
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class JobController(
    val addJobUseCase: AddJobUseCase
) : JobResource {

    override fun addJob(id: String, job: JobDTOReq): ResponseEntity<Unit> {
        addJobUseCase.command(
            job.run {
                JobReq(
                    id = id,
                    step = step,
                    logs = logs,
                    status = status,
                    date = date
                )

            }
        )
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}