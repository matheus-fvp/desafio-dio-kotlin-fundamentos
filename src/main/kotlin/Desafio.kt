enum class Nivel {INICIANTE, INTERMEDIARIO, AVANCADO}

data class Usuario(var nome: String) {
    private var quantidadeXp = 0
    override fun toString() = "(Nome: ${this.nome}, quantidade de xp: ${this.quantidadeXp})";
}
data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>, val nivel: Nivel) {
    val inscritos = mutableListOf<Usuario>()
    fun matricular(vararg alunos: Usuario) {
        inscritos.addAll(alunos)
    }
}

fun main() {

    val aluno1 = Usuario("Matheus")
    val aluno2 = Usuario("Pedro")
    val aluno3 = Usuario("Pricila")
    val aluno4 = Usuario("Joana")
    val aluno5 = Usuario("Alice")

    val conteudos = listOf<ConteudoEducacional>(
        ConteudoEducacional(nome = "Introducao", duracao = 90),
        ConteudoEducacional(nome = "Tipos básicos", duracao = 120),
        ConteudoEducacional(nome = "Estruturas condicionais", duracao = 240)
    )

    val formacao1 = Formacao("Dev Python", conteudos = conteudos, Nivel.INICIANTE)
    formacao1.matricular(aluno1, aluno2, aluno3, aluno4, aluno5)
    println(formacao1)
    println(formacao1.inscritos)

}