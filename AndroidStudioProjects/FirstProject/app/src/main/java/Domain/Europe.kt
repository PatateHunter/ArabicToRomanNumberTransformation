package Domain

enum class Europe(private val pays: Pays) {
    France(Pays("France")),
    Italie(Pays("Italie")),
    Allemagne(Pays("Allemagne"));

    companion object {
        fun getAll(): List<Pays> {
            return Europe.values().map { it -> it.pays }
        }
    }
}