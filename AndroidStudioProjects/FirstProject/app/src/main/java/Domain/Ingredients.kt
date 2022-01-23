package Domain

enum class Ingredients(private val ingredient: Ingredient) {
    Ail(Ingredient("Ail")),
    Oignon(Ingredient("Oignon")),
    Pates(Ingredient("Pates"));

    companion object {
        fun getAll(): List<String> {
            return Ingredients.values().map { it -> it.ingredient.nom }
        }
    }
}