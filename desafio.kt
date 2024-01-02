enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel)


class JaInscritoException : Exception {
    constructor() : super()
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}


data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        try {
            if(!inscritos.contains(usuario)) {
           		inscritos.add(usuario)
                println("Usuario inscrito com sucesso")
        	} else {
                throw JaInscritoException("Usuário já inscrito")
            }
        } catch(e: JaInscritoException) {
            println(e.message)
        }
    }
}

fun main() {
    val curso = ConteudoEducacional("react", 60, Nivel.BASICO)
    val jefferson = Usuario("Jefferson", "jeffersonoliveiradev@gmail.com")
    val DIO = Formacao("DIO", mutableListOf(curso))
    
    DIO.matricular(jefferson)
    DIO.matricular(jefferson)
}