package Domain

enum class AllergicSubstances(private val allergicSubstance: AllergicSubstance) {
    Noix(AllergicSubstance("Noix")),
    Lait(AllergicSubstance("Lait")),
    Gluten(AllergicSubstance("Glutten"));

    companion object {
        fun getAll(): List<String> {
            return AllergicSubstances.values().map { it -> it.allergicSubstance.nom }
        }
    }
}