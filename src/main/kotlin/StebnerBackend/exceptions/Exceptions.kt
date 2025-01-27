package StebnerBackend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class Exception(message:String): RuntimeException(message)

@ResponseStatus(HttpStatus.BAD_REQUEST)
class BadRequest(message: String): RuntimeException(message)
