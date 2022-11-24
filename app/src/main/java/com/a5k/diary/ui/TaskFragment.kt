package com.a5k.diary.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a5k.diary.databinding.AddTaskLayoutBinding
import com.a5k.diary.databinding.FragmentTaskBinding
import com.a5k.diary.domain.entity.Task
import com.a5k.diary.ui.custom.CalendarView
import com.a5k.diary.ui.custom.TaskView
import com.a5k.diary.utill.Utill
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TaskFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = TaskFragment()
    }

    private var vb: FragmentTaskBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentTaskBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        vb?.currentDate?.text = LocalDate.now().format(DateTimeFormatter.ofPattern(Utill.DATE_PATTERN))
        val lin = vb?.containerMm
        for (i in 0..23) {
            lin?.addView(CalendarView(requireContext()).apply { setting(String.format("%02d:00", i)) })
        }
        val task = Task(id = 1, date_start = 1668768932000, date_finish = 1668969532000, "Name Task", "Description task more info task")
        val task1 = Task(
            id = 2,
            date_start = 1668981658000,
            date_finish = 1668984490000,
            "Name Task",
            "Description task more info task Description task more info task Description task more info task"
        )

        val viewTask = TaskView(requireContext()).apply {
            settingViewTask(task, 2400)
        }
        val viewTask1 = TaskView(requireContext()).apply {
            settingViewTask(task1, 2400)
        }
        lin?.addView(viewTask)
        lin?.addView(viewTask1)
    }

    private fun setListener() {
        vb?.addTask?.setOnClickListener {
            openDialogAddTask()
        }
    }

    private fun openDialogAddTask() {
        val view = AddTaskLayoutBinding.inflate(layoutInflater)
        val dialog = MaterialAlertDialogBuilder(requireContext())
            .setView(view.root)
            .setNegativeButton("Cancel") { d, _ -> d.cancel() }
            .setPositiveButton("Save") { d, _ ->
                val nameTask = view.nameTask.toString()
                val date = view.dateField.text.toString()
                val startTime = view.startTimeField.text.toString()
                val endTime = view.endTimeField.text.toString()
                val desc = view.descriptionField.text.toString()
                d.cancel() }
        dialog.show()
        openDateEditable(view)
        openTimeEditable(view)
    }

    private fun openDateEditable(view: AddTaskLayoutBinding) {
        view.dateField.setOnClickListener {
            val datePicker = DatePickerFragment { _, year, month, day ->
                val date = String.format("%02d.%02d.%d", day, month, year)
                view.dateField.setText(date)
            }
            datePicker.show(childFragmentManager, null)
        }
    }

    private fun openTimeEditable(view: AddTaskLayoutBinding) {
        view.startTimeField.setOnClickListener {
            val timeStartPicker = TimePickerFragment { _, hourOfDay, minute ->
                val time = Utill.getTime(hourOfDay, minute)
                view.startTimeField.setText(time)
            }
            timeStartPicker.show(childFragmentManager, null)
        }
        view.endTimeField.setOnClickListener {
            val timeStartPicker = TimePickerFragment { _, hourOfDay, minute ->
                val time = Utill.getTime(hourOfDay, minute)
                view.endTimeField.setText(time)
            }
            timeStartPicker.show(childFragmentManager, null)
        }
    }

}