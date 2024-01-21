package imt.bigcicd.back.bigcicdback.input.controllers.models

import imt.bigcicd.back.bigcicdback.domain.models.Pipeline
import org.bson.types.ObjectId
import java.time.ZonedDateTime

data class LightPipeline (
    val id: String = ObjectId().toHexString(),
    val repository: String = "",
    val ref: String = "",
    val pushDate: ZonedDateTime = ZonedDateTime.now(),
    val time: Long = 0, //TODO add time (BC-11)
    ) {
    companion object {
        fun fromPipeline(pipeline: Pipeline): LightPipeline {
            return LightPipeline(
                id = pipeline.id,
                repository = pipeline.repository,
                ref = pipeline.ref,
                pushDate = pipeline.pushDate,
                time = 0, // TODO change here too
            )
        }
    }
}