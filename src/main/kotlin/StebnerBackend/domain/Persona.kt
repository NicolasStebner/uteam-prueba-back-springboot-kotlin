package StebnerBackend.domain

import StebnerBackend.exceptions.BadRequest
import java.time.LocalDate

class Persona(
    var id:Int,
    var firstName:String,
    var lastName: String,
    var birthdate: LocalDate,
    var hasInsurance: Boolean,
    var favouriteMovies : MutableSet<Pelicula>
){
    private var maxFavouriteMovies = 5

    fun getMovies(): MutableSet<Pelicula> = favouriteMovies

    fun addPelicula(pelicula:Pelicula){
        if(puedoAgregarOtraPelicula()){
            favouriteMovies.add(pelicula)
        }else{
            throw BadRequest("Superaste el limite de peliculas favoritas (${maxFavouriteMovies})")
        }
    }

    fun removePelicula(pelicula: Pelicula?){
        favouriteMovies.remove(pelicula)
    }

    private fun puedoAgregarOtraPelicula() = favouriteMovies.size < maxFavouriteMovies
}