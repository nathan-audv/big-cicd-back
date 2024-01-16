package imt.bigcicd.back.bigcicdback.output.database.repositories

import imt.bigcicd.back.bigcicdback.output.database.models.PipelineModel
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface PipelineRepository : MongoRepository<PipelineModel, String>