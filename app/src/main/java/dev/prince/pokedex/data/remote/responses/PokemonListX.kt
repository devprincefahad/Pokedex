package dev.prince.pokedex.data.remote.responses

data class PokemonListX(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultX>
)