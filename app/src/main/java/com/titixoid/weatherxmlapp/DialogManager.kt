package com.titixoid.weatherxmlapp

import android.content.Context
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

object DialogManager {
    fun locationSettingsDialog(contex: Context, listener: Listener){
        val builder = AlertDialog.Builder(contex)
        val dialog = builder.create()
        dialog.setTitle("Enable location?")
        dialog.setMessage("Location disabled, do you want enable location?")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok") { _,_ ->
            listener.onClick(null)
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    fun searchByNameDialog(contex: Context, listener: Listener){
        val builder = AlertDialog.Builder(contex)
        val edName = EditText(contex)
        builder.setView(edName)

        val dialog = builder.create()


        dialog.setTitle("City name: ")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "Ok") { _,_ ->
            listener.onClick(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel") { _,_ ->
            dialog.dismiss()
        }
        dialog.show()
    }

    interface Listener{
        fun onClick(name: String?)
    }
}