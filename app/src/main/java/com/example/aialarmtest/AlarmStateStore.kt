package com.example.aialarmtest

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "alarm_state")

object AlarmStateStore {
    private val KEY_MAIN_VALUE = intPreferencesKey("main_value")

    fun mainValueFlow(context: Context): Flow<Int> =
        context.dataStore.data.map { prefs ->
            prefs[KEY_MAIN_VALUE] ?: 1
        }

    suspend fun setMainValue(context: Context, value: Int) {
        context.dataStore.edit { prefs ->
            prefs[KEY_MAIN_VALUE] = value
        }
    }
}
