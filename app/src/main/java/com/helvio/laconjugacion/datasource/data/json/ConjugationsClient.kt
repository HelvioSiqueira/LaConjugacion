package com.helvio.laconjugacion.datasource.data.json

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.helvio.laconjugacion.datasource.model.conjugation.ConjugationsDto
import com.helvio.laconjugacion.datasource.model.conjugation.VerbDto

class ConjugationsClient : IConjugationsClient {
    override fun getConjugations(context: Context, files: List<String>): ConjugationsDto {

        val verbs = mutableListOf<VerbDto>()
        var conjugationsDto = ConjugationsDto()

        files.forEach { file ->
            conjugationsDto = Gson().fromJson(
                readJsonFromAsset(context, file),
                ConjugationsDto::class.java
            )

            verbs.addAll(conjugationsDto.verbs)
        }

        Log.d("HSV", conjugationsDto.toString())

        return conjugationsDto.copy(verbs = verbs)
    }

    private fun readJsonFromAsset(context: Context, fileName: String): String? {
        return try {
            context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: Exception) {
            ioException.printStackTrace()
            null
        }
    }
}