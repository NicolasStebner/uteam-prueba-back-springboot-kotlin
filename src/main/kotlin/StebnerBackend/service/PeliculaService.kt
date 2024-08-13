package StebnerBackend.service

import StebnerBackend.domain.Pelicula
import StebnerBackend.exceptions.Exception
import org.springframework.stereotype.Service

@Service
class PeliculaService {
    private val peliculas = mutableListOf(
        Pelicula(1,"Volver al futuro", "Ciencia Ficcion"),
        Pelicula(2,"Inception", "Ciencia Ficcion"),
        Pelicula(3,"The Godfather", "Crimen"),
        Pelicula(4,"The Shawshank Redemption", "Drama"),
        Pelicula(5,"Pulp Fiction", "Crimen"),
        Pelicula(6,"Forrest Gump", "Drama"),
        Pelicula(7,"The Matrix ", "Ciencia Ficcion"),
    )
    fun getPeliculaById(id:Int): Pelicula = peliculas.find {it.id === id} ?: throw Exception("La pelicula con id ${id} no existe")
}