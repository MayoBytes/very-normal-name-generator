package com.thirdgallon.namegenerator.database

import co.touchlab.kermit.Logger
import kotbase.Database
import kotbase.Dictionary
import kotbase.IndexBuilder
import kotbase.MutableDocument
import kotbase.Result
import kotbase.ValueIndexItem

class SavedNameDatabase {

    private var db: Database = Database(DB_NAME)
    private var collection = db.getCollection(COLLECTION_NAME) ?: db.createCollection(COLLECTION_NAME)

    init {
        Logger.d("Initializing...", tag = TAG)
        if (!collection.indexes.contains(INDEX_NAME)) {
            Logger.d("Creating name index...", tag = TAG)
            collection.createIndex(
                name = INDEX_NAME,
                index = IndexBuilder.valueIndex(ValueIndexItem.property(SavedName.NAME))
            )
        }
        if (!collection.indexes.contains(INDEX_ID)) {
            Logger.d("Creating id index...", tag = TAG)
            collection.createIndex(
                name = INDEX_ID,
                index = IndexBuilder.valueIndex(ValueIndexItem.property(SavedName.ID))
            )
        }
    }

    fun selectAll(): List<SavedName> {
        Logger.d("selectAll ->", tag = TAG)
        val names = mutableListOf<SavedName>()
        val query = collection.database.createQuery("SELECT * FROM $COLLECTION_NAME")

        query.execute().allResults().forEach { result: Result ->
            val obj = result.getValue(COLLECTION_NAME) as? Dictionary

            obj?.let {
                val saved = SavedName(
                    id = obj.getString(SavedName.ID) ?: "",
                    name = obj.getString(SavedName.NAME) ?: "",
                    description = obj.getString(SavedName.DESCRIPTION) ?: ""
                )
                names.add(saved)
                Logger.d("selectAll -> $saved", tag = TAG)
            }
        }

        return names
    }

    fun writeName(name: SavedName) {
        Logger.d("writeName -> $name", tag = TAG)
        val doc = MutableDocument(name.id)
        doc.setString(SavedName.ID, name.id)
        doc.setString(SavedName.NAME, name.name)
        doc.setString(SavedName.DESCRIPTION, name.description)
        collection.save(doc)
    }

    fun deleteName(id: String) {
        Logger.d("deleteName -> $id", tag = TAG)
        collection.getDocument(id)?.let { doc ->
            Logger.d("deleteName -> found document for $id, deleting...", tag = TAG)
            collection.delete(doc)
        }
    }


    companion object {
        private const val TAG = "SavedNameDatabase"
        private const val DB_NAME = "save-names"
        private const val COLLECTION_NAME = "saved_names"
        private const val INDEX_NAME = "saved_name_index"
        private const val INDEX_ID = "saved_name_id_index"
        val shared = SavedNameDatabase()
    }
}