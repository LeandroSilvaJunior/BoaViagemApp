package org.senac.boaviagem.model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.senac.boaviagem.db.DataBase
import org.senac.boaviagem.domain.Viagem
import org.senac.gabrielkraetzer.boaviagem.data.Dao.ViagemDao

class ViagemViewModel(application: Application) : AndroidViewModel(application) {

    private val viagemDao : ViagemDao = DataBase.getDataBase(application).viagemDao()
    val viagens : LiveData<List<Viagem>>

    val selected = MutableLiveData<Viagem>()

    init {
        viagens = viagemDao.getViagem()
    }

    fun select(viagem: Viagem) {
        this.selected.value = viagem
    }

    fun delete(viagem: Viagem) {
        viewModelScope.launch( Dispatchers.IO){
            viagemDao.delete(viagem)
        }
    }
}