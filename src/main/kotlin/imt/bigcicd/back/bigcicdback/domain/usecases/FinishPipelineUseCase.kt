package imt.bigcicd.back.bigcicdback.domain.usecases

import imt.bigcicd.back.bigcicdback.domain.exceptions.PipelineNotFoundException
import imt.bigcicd.back.bigcicdback.domain.models.FinishReq
import imt.bigcicd.back.bigcicdback.domain.utils.UseCase
import imt.bigcicd.back.bigcicdback.output.services.PipelineService
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
data class FinishPipelineUseCase(
        val pipelineService: PipelineService
) : UseCase<FinishReq, Unit> {
    override fun command(request: FinishReq) {
        pipelineService.findById(request.id)?.let {
            pipelineService.savePipeline(
                    it.copy(
                            status = request.status,
                            time = ZonedDateTime.now().toEpochSecond() - it.date.toEpochSecond()
                    )
            )
        } ?: throw PipelineNotFoundException(request.id)
    }
}