package StebnerBackend.service

import StebnerBackend.domain.Pelicula
import StebnerBackend.domain.Persona
import StebnerBackend.dto.*
import StebnerBackend.exceptions.Exception
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PersonaService(val peliculaService: PeliculaService) {
    private val personas = mutableListOf(
        Persona(1, "Juan","Rodriguez",LocalDate.now(),true, mutableSetOf()),
        Persona(2, "Ana","Rodriguez",LocalDate.now(),false, mutableSetOf()),
        Persona(3, "Luis","Juarez",LocalDate.now(),true, mutableSetOf())
    )

    fun getAllPersonas(): List<Persona> = personas.sortedWith(compareBy({it.lastName},{it.firstName}))

    fun getPersonaById(id:Int): Persona = personas.find {it.id === id} ?: throw Exception("La Persona con id ${id} no existe")

    fun getPeliculasByPersonaId(id:Int): Set<Pelicula> {
        val persona = getPersonaById(id)
        return persona.getMovies()
    }

    fun addPelicula(idPersona:Int,idPelicula: Int): MutableSet<Pelicula> {
        val persona = getPersonaById(idPersona)
        val pelicula = peliculaService.getPeliculaById(idPelicula)
        persona.addPelicula(pelicula)
        return persona.getMovies()
    }

    fun deletePelicula(idPersona:Int, idPelicula:Int): MutableSet<Pelicula> {
        val persona = getPersonaById(idPersona)
        val pelicula =  peliculaService.getPeliculaById(idPelicula)
        persona.removePelicula(pelicula)
        return persona.getMovies()
    }

    fun getPersonaByName(name: String):List<Persona> = personas.filter{it.firstName.equals(name,ignoreCase = true)}

    fun postPersona(persona: PersonaToPostDTO): Persona{
        val newId = personas.last()
        val personaToAdd = Persona(newId.id+1,persona.firstName,
            persona.lastName,
            LocalDate.parse(persona.birthdate),
            persona.hasInsurance,
            mutableSetOf()
        )
        personas.add(personaToAdd)
        return personaToAdd
    }

    fun patchPersona(id:Int, dataToPatch: PersonaToPatchDTO): Persona{
        val persona = getPersonaById(id)
        dataToPatch.firstName.let { persona.firstName = it }
        dataToPatch.lastName.let { persona.lastName = it }
        dataToPatch.birthdate.let { persona.birthdate = LocalDate.parse(it) }
        dataToPatch.hasInsurance.let { persona.hasInsurance = it }

        return persona
    }

    fun deletePersonaById(id:Int): List<Persona> {
        val personaToRemove = getPersonaById(id)
        personas.remove(personaToRemove)
        return personas
    }
}

