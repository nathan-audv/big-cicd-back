package imt.bigcicd.back.bigcicdback.domain.exceptions

class RepositoryNotFoundException(repository: String) : Exception("Repository $repository not found")
class RepositoryException : Exception("Registry as raised an exception")
class RunnerException : Exception("Runner as raised an exception")
class InternalException : Exception("Internal exception")