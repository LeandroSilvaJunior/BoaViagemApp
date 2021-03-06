package org.senac.boaviagem.domain

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "viagem")
data class Viagem(
    val destino : String?,
    val tipo : Int?,
    val dataChegada : LocalDate?,
    val dataPartida : LocalDate?,
    val qtdePessoas : Int?) {

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}