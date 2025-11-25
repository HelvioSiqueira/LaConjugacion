package com.helvio.laconjugacion.datasource.data

import android.content.Context
import com.google.gson.Gson
import com.helvio.laconjugacion.datasource.model.ConjugationsModel
import com.helvio.laconjugacion.datasource.model.Verb

class ConjugationsClient : IConjugationsClient {
    override fun getConjugations(context: Context, files: List<String>): ConjugationsModel {

        val verbs = mutableListOf<Verb>()
        var conjugationsModel = ConjugationsModel()

        files.forEach { file ->
            conjugationsModel = Gson().fromJson(
                readJsonFromAsset(context, file),
                ConjugationsModel::class.java
            )

            verbs.addAll(conjugationsModel.verbs)
        }

        return conjugationsModel.copy(verbs = verbs)
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