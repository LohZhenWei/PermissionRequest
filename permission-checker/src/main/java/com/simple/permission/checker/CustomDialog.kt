package com.simple.permission.checker

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.simple.permission.checker.databinding.DialogCustomBinding

class CustomDialog(context: Context) : Dialog(context, R.style.DefaultDialog) {

    private val binding = DialogCustomBinding.inflate(LayoutInflater.from(context))

    init {
        setContentView(binding.root)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        positiveButton()
    }

    fun title(text: String?): CustomDialog {
        binding.tvTitle.text = text
        binding.tvTitle.show()
        return this
    }

    fun message(text: String?): CustomDialog {
        binding.tvMessage.text = text
        return this
    }

    fun cancelable(boolean: Boolean): CustomDialog {
        setCancelable(boolean)
        return this
    }

    fun positiveButton(
        text: String? = null,
        shouldDismiss: Boolean = true,
        click: (CustomDialog) -> Unit = { dismiss() },
    ): CustomDialog {
        binding.btnPositive.apply {
            if (!text.isNullOrBlank()) this.text = text
            setOnClickListener {
                click.invoke(this@CustomDialog)
                if (shouldDismiss) dismiss()
            }
        }
        return this
    }

    fun negativeButton(
        text: String? = null,
        click: (CustomDialog) -> Unit = { dismiss() },
    ): CustomDialog {
        binding.btnNegative.apply {
            this.show()
            if (!text.isNullOrBlank()) this.text = text
            setOnClickListener {
                click.invoke(this@CustomDialog)
                dismiss()
            }
        }
        return this
    }

    inline fun show(func: CustomDialog.() -> Unit): CustomDialog = apply {
        this.func()
        this.show()
    }

    private fun View.show() {
        this.visibility = View.VISIBLE
    }
}