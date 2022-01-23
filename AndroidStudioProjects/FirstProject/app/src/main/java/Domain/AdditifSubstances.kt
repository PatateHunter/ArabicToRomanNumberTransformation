package Domain

enum class AdditifSubstances( private val additifSubstance: AdditifSubstance) {
    E153(AdditifSubstance("E153")),
    E155(AdditifSubstance("E155")),
    E162(AdditifSubstance("E162"));

    companion object {
        fun getAll(): List<String> {
            return AdditifSubstances.values().map { it -> it.additifSubstance.nom }
        }
    }

}