package br.com.albertlopes.pokempow.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit



class ClientApi<T> {

    fun getClient(c: Class<T>): T {
        val retrofit = Retrofit.Builder()
                .client(getOkhttpClientAuth().build())

                .baseUrl("https://gamestjd.herokuapp.com/jokenpokemon/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(c)
    }

}

fun getOkhttpClientAuth(): OkHttpClient.Builder {
    return OkHttpClient.Builder()
            //.addInterceptor(AuthInterceptor())
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
}


fun getJokenPokemonAPI(): JokenPokemonAPI {
    return ClientApi<JokenPokemonAPI>().getClient(JokenPokemonAPI::class.java)
}

