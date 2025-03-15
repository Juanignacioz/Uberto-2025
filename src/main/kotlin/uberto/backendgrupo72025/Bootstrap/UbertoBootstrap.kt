package uberto.backendgrupo72025.Bootstrap
//
//
import Ejecutivo
import Moto
import Simple
import uberto.backendgrupo72025.Domain.Viajero
import org.springframework.beans.factory.InitializingBean
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import uberto.backendgrupo72025.Domain.Conductor
import uberto.backendgrupo72025.Domain.Vehiculo
import uberto.backendgrupo72025.Repository.UsuarioRepository
import uberto.backendgrupo72025.Repository.VehiculoRepository

import uberto.backendgrupo72025.Service.UsuarioService

//
@Component
class UbertoBootstrap(
    val usuarioRepository: UsuarioRepository,
    val vehiculoRepository : VehiculoRepository
): InitializingBean {

    override fun afterPropertiesSet() {
        crearUsuarios()
    }

    val viajero1 = Viajero(
        nombreYApellido = "Juan Pérez",
        username = "juanp",
        contrasenia = "pass123",
        edad = 28,
        viajesRealizados = mutableListOf(),
        telefono = 123456789,
        comentarios = mutableListOf(), // Lista vacía por ahora
        saldo = 1500.50,
        amigos = mutableListOf(), // Lista vacía por ahora
    )

    val viajero2 = Viajero(
        nombreYApellido = "María González",
        edad = 34,
        username = "mariag",
        contrasenia = "secure456",
        viajesRealizados = mutableListOf(),
        telefono = 987654321,
        comentarios = mutableListOf(), // Lista vacía por ahora
        saldo = 2300.75,
        amigos = mutableListOf(), // Lista vacía por ahora
    )

    val viajero3 = Viajero(
        nombreYApellido = "Carlos López",
        edad = 23,
        username = "carlosl",
        contrasenia = "mypwd789",
        viajesRealizados = mutableListOf(),
        telefono = 456789123,
        comentarios = mutableListOf(), // Lista vacía por ahora
        saldo = 800.25,
        amigos = mutableListOf(), // Lista vacía por ahora
    )

    val viajero4 = Viajero(
        nombreYApellido = "Ana Martínez",
        edad = 41,
        username = "anam",
        contrasenia = "password1",
        viajesRealizados = mutableListOf(),
        telefono = 321654987,
        comentarios = mutableListOf(), // Lista vacía por ahora
        saldo = 3500.00,
        amigos = mutableListOf(), // Lista vacía por ahora
    )

    fun crearUsuarios() {
        usuarioRepository.save(viajero1)
        usuarioRepository.save(viajero2)
        usuarioRepository.save(viajero3)
        usuarioRepository.save(viajero4)
    }

    // Vehiculos
    val autoSimple = Vehiculo("Toyota", "Corolla", "ABC123", 2018, Simple)
    val autoEjecutivo = Vehiculo("Ford", "Focus", "DEF456", 2020, Ejecutivo)
    val autoSimple2 = Vehiculo("Honda", "Civic", "GHI789", 2016, Simple)
    val autoEjecutivo2 = Vehiculo("Chevrolet", "Cruze", "JKL012", 2019, Ejecutivo)
    val moto = Vehiculo("Yamaha", "FZ25", "MNO345", 2022, Moto)

    fun crearVehiculos() {
        vehiculoRepository.save(autoSimple)
        vehiculoRepository.save(autoSimple2)
        vehiculoRepository.save(autoEjecutivo)
        vehiculoRepository.save(autoEjecutivo2)
        vehiculoRepository.save(moto)
    }

    // conductores

    val conductor1 = Conductor(
        nombreYApellido = "Juan Pérez",
        edad = 35,
        username = "juanp123",
        contrasenia = "pass1234",
        viajesRealizados = mutableListOf(), // Lista vacía por ahora
        telefono = 123456789,
        comentarios = mutableListOf(), // Lista vacía por ahora
        autoEjecutivo,
        precioBaseDelViaje = 500
    )

    val conductor2 = Conductor(
        nombreYApellido = "María Gómez",
        edad = 28,
        username = "mariagomez",
        contrasenia = "secure5678",
        viajesRealizados = mutableListOf(), // Lista vacía por ahora
        telefono = 987654321,
        comentarios = mutableListOf(), // Lista vacía por ahora
        autoSimple,
        precioBaseDelViaje = 450
    )

    fun crearChoferes(){
        usuarioRepository.save(conductor1)
        usuarioRepository.save(conductor2)
    }






}
