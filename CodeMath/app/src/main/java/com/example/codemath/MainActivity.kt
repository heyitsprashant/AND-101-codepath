package com.example.codemath

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.codemath.databinding.ActivityMainBinding
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.seekBarTip.setOnSeekBarChangeListener(object :
            android.widget.SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: android.widget.SeekBar?,
                progress: Int,
                fromUser: Boolean
            ) {
                binding.tvPercentLabel.text = "$progress%"
                computeTip()
            }

            override fun onStartTrackingTouch(seekBar: android.widget.SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: android.widget.SeekBar?) {}
        })

        binding.etBaseAmount.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                computeTip()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun computeTip() {
        val baseAmount = binding.etBaseAmount.text.toString().toDoubleOrNull()
        val numPeople = binding.etNumPeople.text.toString().toIntOrNull() ?: 1

        if (baseAmount == null || baseAmount == 0.0 || numPeople <= 0) {
            binding.tvTipAmount.text = "Tip"
            binding.tvTotalAmount.text = "Total"
            return
        }

        val tipPercent = binding.seekBarTip.progress
        val tip = round(baseAmount * tipPercent) / 100
        val total = baseAmount + tip
        val totalPerPerson = total / numPeople

        binding.tvTipAmount.text = "Tip: $%.2f".format(tip)
        binding.tvTotalAmount.text = "Total per person: $%.2f".format(totalPerPerson)
    }
}

