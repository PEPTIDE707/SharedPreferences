package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data Saved.", Toast.LENGTH_SHORT).show()
        }
        loadData()
    }
    private fun saveData(){
        val pref = getSharedPreferences("pref", 0)
        val edit = pref.edit()//수정모드
        //1번째 인자는 키, 2번째 인자는 실제 담아둘 값
        edit.putString("name", binding.etHello.text.toString())
        edit.apply()//저장완료
    }

    private fun loadData(){
        val pref = getSharedPreferences("pref", 0)
        //1번째 인자는 키, 2번째 인자는 실제 담아둘 값
        binding.etHello.setText(pref.getString("name", ""))
    }
}