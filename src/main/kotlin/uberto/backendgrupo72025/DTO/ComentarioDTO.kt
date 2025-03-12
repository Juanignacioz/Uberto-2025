package uberto.backendgrupo72025.DTO

import uberto.backendgrupo72025.Domain.Comentario

class ComentarioDTO(
    val id: Int,
    val viajeId: Int,
    val autor: String,
    val puntaje: Int,
    val mensaje: String
) {
    fun Comentario.toDTO() = ComentarioDTO(
        id = this.id,
        viajeId = viajeId,//falta crear el id del viaje para vincularlo
        autor = autor.nombreYApellido,
        puntaje = puntaje,
        mensaje = mensaje,
    )
}