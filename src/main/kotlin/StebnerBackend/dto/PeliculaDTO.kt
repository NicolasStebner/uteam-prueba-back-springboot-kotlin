package StebnerBackend.dto

import StebnerBackend.domain.Pelicula

data class PeliculaToAddDTO (
    var id: Int
)

class PeliculaDTO(
    val id: Int,
    val title: String,
    val genre: String,
)

fun Pelicula.toDto(): PeliculaDTO{
    return PeliculaDTO(
        id,
        title,
        genre
    )
}
