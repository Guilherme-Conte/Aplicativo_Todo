package com.generation.todo.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.time.LocalDate
import java.time.ZoneId
import java.util.*

class DatePickerFragment (
    private val timePickerListener: TimePickerListener
    ): DialogFragment(), DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val cale = Calendar.getInstance()
        val year = cale.get(Calendar.YEAR)
        val month = cale.get(Calendar.MONTH)
        val day = cale.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(requireContext(), this, year, month, day)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, p1)
        calendar.set(Calendar.MONTH, p2)
        calendar.set(Calendar.DAY_OF_MONTH, p3)
        timePickerListener.onTimeSelected(calendar.time.toInstant().atZone(
            ZoneId.systemDefault()).toLocalDate())

    }
}

interface TimePickerListener {

    fun onTimeSelected(date: LocalDate)

}