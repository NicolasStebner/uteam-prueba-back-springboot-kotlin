package StebnerBackend.dto

import StebnerBackend.domain.Pelicula
import StebnerBackend.domain.Persona

data class PersonaByNameDTO (
    var name: String
)

data class PersonaToPostDTO (
    var firstName: String,
    var lastName: String,
    var birthdate: String, //yyyy,MM,dd
    var hasInsurance: Boolean,
)

data class PersonaToPatchDTO (
    var firstName: String,
    var lastName: String,
    var birthdate: String, //yyyy,MM,dd
    var hasInsurance: Boolean,
)

class PersonaDTO(
    var id:Int,
    var firstName:String,
    var lastName:String,
    var birthdate: String,
    var hasInsurance: Boolean,
    var favouriteMovies: List<PeliculaDTO>
)

fun Persona.toDto(): PersonaDTO {
    return PersonaDTO(
        id,
        firstName,
        lastName,
        birthdate.toString(),
        hasInsurance,
        favouriteMovies.map {it.toDto()}
    )
}

