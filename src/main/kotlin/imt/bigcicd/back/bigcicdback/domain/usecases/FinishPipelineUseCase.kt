package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.PipelineNotFoundException
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
data class FinishPipelineUseCase(
    val pipelineService: PipelineService
) : UseCase<String, Unit> {
    override fun command(request: String) {
        pipelineService.findById(request)?.let {
            pipelineService.savePipeline(
                it.copy(time = ZonedDateTime.now().toEpochSecond() - it.date.toEpochSecond())
            )
        } ?: throw PipelineNotFoundException(request)
    }
}