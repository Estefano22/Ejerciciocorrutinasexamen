fun main(){
    val profesor = Profesor()
    profesor.darExamen()

    val alumno = Alumno()
    alumno.hellegado()
    alumno.hacerExamen()

    val examen = Examen()
    examen.escribirExamen()

    val lista = listOf(profesor, alumno, examen)
    lista.forEach {

    }
}

class Profesor() {

     fun darExamen(): Examen {

    }
}
class Examen(){

    fun escribirExamen() {

    }
}

class Alumno(){
     fun hellegado() {
        println("")
    }
    fun hacerExamen(){
        println("")
    }
}