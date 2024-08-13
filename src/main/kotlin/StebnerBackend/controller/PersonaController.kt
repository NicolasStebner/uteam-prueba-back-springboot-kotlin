package StebnerBackend.controller

import StebnerBackend.dto.*
import StebnerBackend.service.PersonaService
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persona")
@CrossOrigin("*")
class PersonaController(
    var personaService: PersonaService
) {
    @GetMapping("/all")
    fun getAll(): List<PersonaDTO> {
        return personaService.getAllPersonas().map {it.toDto()}
    }

    @GetMapping("/{id}")
    fun getPersonaById(@PathVariable id:Int): PersonaDTO {
        return personaService.getPersonaById(id).toDto()
    }

    @GetMapping("/{id}/peliculas")
    fun getPeliculasByPersonaId(@PathVariable id:Int): List<PeliculaDTO> {
        return personaService.getPeliculasByPersonaId(id).map {it.toDto()}
    }

    @PatchMapping("/{id}/peliculas")
    fun addPeliculaPersona(@PathVariable id: Int, @RequestBody dataPelicula:PeliculaToAddDTO): List<PeliculaDTO> {
        return personaService.addPelicula(id, dataPelicula.id).map {it.toDto()}
    }

    @DeleteMapping("/{id}/peliculas")
    fun deletePeliculaPersona(@PathVariable id: Int, @RequestBody dataPelicula:PeliculaToAddDTO): List<PeliculaDTO> {
        return personaService.deletePelicula(id, dataPelicula.id).map {it.toDto()}
    }

    @GetMapping("")
    fun getPersonaByNombre(@RequestBody data: PersonaByNameDTO): List<PersonaDTO>{
        return personaService.getPersonaByName(data.name).map {it.toDto()}
    }

    @PostMapping("")
    fun postPersona(@RequestBody data:PersonaToPostDTO): PersonaDTO {
        return personaService.postPersona(data).toDto()
    }

    @PatchMapping("/{id}")
    fun patchPersona(@PathVariable id:Int, @RequestBody data:PersonaToPatchDTO): PersonaDTO{
        return personaService.patchPersona(id,data).toDto()
    }

    @DeleteMapping("/{id}")
    fun deletePersona(@PathVariable id:Int): List<PersonaDTO> {
        return personaService.deletePersonaById(id).map {it.toDto()}
    }
}

