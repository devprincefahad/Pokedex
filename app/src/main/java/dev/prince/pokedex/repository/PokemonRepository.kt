package dev.prince.pokedex.repository

import dagger.hilt.android.scopes.ActivityScoped
import dev.prince.pokedex.data.remote.PokeAPI
import dev.prince.pokedex.data.remote.responses.Pokemon
import dev.prince.pokedex.data.remote.responses.PokemonList
import dev.prince.pokedex.util.Resource
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName:String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

}