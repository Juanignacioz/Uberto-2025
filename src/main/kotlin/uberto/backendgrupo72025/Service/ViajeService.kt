package uberto.backendgrupo72025.Service

import org.springframework.stereotype.Service
import uberto.backendgrupo72025.DTO.ViajeDTO
import uberto.backendgrupo72025.DTO.toViaje
import uberto.backendgrupo72025.Domain.Viaje
import uberto.backendgrupo72025.Repository.ViajeRepository

@Service
class ViajeService(
    val viajeRepository: ViajeRepository
) {

    fun crearViaje(viajeDTO: ViajeDTO): Viaje {
        val viaje = viajeDTO.toViaje()
        viajeRepository.save(viaje)
        return viaje
    }

    fun buscar() = viajeRepository.findAll()

    fun getViajeById(idViaje: Long) = viajeRepository.findById(idViaje)

    fun updateViaje(viaje: Viaje) {
        viajeRepository.update(viaje)
    }


    fun getTotalFacturado(idConductor: Long): Double {
        return viajeRepository.findAll()
            .filter { it.viajeFinalizado() && it.idConductor == idConductor }
            .sumOf { it.importe }
    }


}