import kotlinx.coroutines.*
import kotlin.random.Random

fun main(){



    val listaAlumnos = mutableListOf<Alumno>()
    val listaExamenes = mutableListOf<Examen>()


    println("Los alumnos salen de su casa")

    runBlocking {
        repeat (30){
            val alumno = Alumno(nombre=it+1,Random.nextLong(1,6)*1000)
            listaAlumnos.add(alumno)
            alumno.haLlegado(this)

        }

    }

    println("Ya estan todos en clase")

    Thread.sleep(2000)

    println("\nEl profesor empieza a repartir los examenes")

    runBlocking {
        repeat(30){
            val examen = Examen(it+1)
            listaExamenes.add(examen)
            examen.hacer(Random.nextLong(1,4)*1000, this)
        }
    }

    Thread.sleep(5000)

    println("Ya tengo los ${listaExamenes.size} exámenes, hemos terminado")

    Thread.sleep(3000)

    println("\nVoy a corregir los examenes")

    Thread.sleep(2000)

    runBlocking {
        this.launch {
            repeat(30){
                val profesor = Profesor("Profesor", nombreAlumno = it+1)
                profesor.corregirExamen()
            }
        }
    }

}


class Alumno(var nombre : Int, var tiempoLlegada : Long){

    //SOLUCION 1
    fun haLlegado(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            delay(tiempoLlegada)
            println("Alumno $nombre ha llegado")
        }
    }

    //SOLUCION 2
    /*
    suspend fun haLlegado2() { //suspend significa que la funcion es llamada desde una corrutina
            delay(tiempoLlegada)
            println("Alumno $nombre ha llegado")
    }

     */

    fun hacerExamen(){
        println(" Soy $nombre voy a hacer el examen")
    }
}

class Profesor(var Nombre: String, var nombreAlumno: Int){

    fun corregirExamen(){
        val listaNotas = ArrayList<Int>()
        val nota = (0..10).random()
        listaNotas.add(nota)


            println("El Alumno $nombreAlumno ha sacado $listaNotas")
        }
    }



class Examen(var nombreAlumno : Int){

    fun hacer( tiempoTardado : Long, coroutineScope: CoroutineScope){
        coroutineScope.launch {
            delay(tiempoTardado)
            println("El Alumno $nombreAlumno ha terminado el examen")
        }
    }
}

