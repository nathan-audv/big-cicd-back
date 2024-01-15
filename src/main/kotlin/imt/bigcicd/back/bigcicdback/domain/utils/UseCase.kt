package imt.bigcicd.back.bigcicdback.domain.utils

interface UseCase<in Request, out Response> {
    fun command(request: Request): Response
}