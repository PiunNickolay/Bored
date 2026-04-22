package ru.nickolay.bored.presentation.viewModel


import android.util.Log.e
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.nickolay.bored.domain.ActivityType
import ru.nickolay.bored.domain.model.Activity
import ru.nickolay.bored.domain.usecases.GetActivityByCategoryUseCase
import ru.nickolay.bored.domain.usecases.GetFavoritesUseCase
import ru.nickolay.bored.domain.usecases.GetRandomActivityUseCase
import ru.nickolay.bored.domain.usecases.SetFavoriteUseCase
import ru.nickolay.bored.presentation.state.MainState

class MainActivityViewModel(
    private val getRandomActivityUseCase: GetRandomActivityUseCase,
    private val getActivityByCategoryUseCase: GetActivityByCategoryUseCase,
    private val setFavoritesUseCase: SetFavoriteUseCase
): ViewModel() {

    private val _state = MutableStateFlow(MainState(activity = null))
    val state: StateFlow<MainState> = _state

    fun getRandomActivity() {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                error = null
            )
            try {
                val activity = getRandomActivityUseCase()

                _state.value = _state.value.copy(
                    activity = activity,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun getRandomActivityByCategory(type: ActivityType) {
        viewModelScope.launch {
            _state.value = _state.value.copy(
                isLoading = true,
                error = null,
                selectedType = type
            )

            try {
                val list = getActivityByCategoryUseCase(type)

                val activity = list.randomOrNull()

                _state.value = _state.value.copy(
                    activity = activity,
                    isLoading = false
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }

    fun toggleFavorite(activity: Activity) {
        val currentActivity = _state.value.activity ?: return

        viewModelScope.launch {
            try {
                setFavoritesUseCase(currentActivity)

                val updated = currentActivity.copy(
                    isFavorite = !currentActivity.isFavorite
                )

                _state.value = _state.value.copy(
                    activity = updated
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    error = e.message
                )
            }
        }
    }
}