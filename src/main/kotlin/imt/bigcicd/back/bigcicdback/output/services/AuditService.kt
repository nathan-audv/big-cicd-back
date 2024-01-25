package imt.bigcicd.back.bigcicdback.output.services

import imt.bigcicd.back.bigcicdback.domain.models.Audit
import imt.bigcicd.back.bigcicdback.output.database.models.AuditModel
import imt.bigcicd.back.bigcicdback.output.database.repositories.AuditRepository
import org.springframework.stereotype.Service


@Service
class AuditService(
    val auditRepository: AuditRepository
) {
    fun saveAudit(audit: Audit): Audit =
        Audit.fromModel(auditRepository.save(AuditModel.fromDomain(audit)))
}