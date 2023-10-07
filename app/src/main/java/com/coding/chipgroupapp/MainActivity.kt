package com.coding.chipgroupapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val topicChipGroup = findViewById<ChipGroup>(R.id.topicChipGroup)
        val submitBtn = findViewById<Button>(R.id.submitBtn)
        val topicTxt = findViewById<TextView>(R.id.topicTxt)


        val checkedTopicList = arrayListOf<String>()

        topicChipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            checkedTopicList.clear()
            if (checkedIds.isEmpty()){
                topicTxt.text = "No Topic Selected"
            }else{
                checkedIds.forEach { idx ->
                    val chip = findViewById<Chip>(idx)
                    checkedTopicList.add(chip.text.toString())
                }

                topicTxt.text = "Selected Topic: $checkedTopicList"
            }
        }


        submitBtn.setOnClickListener {
            if (checkedTopicList.isEmpty()){
                Toast.makeText(this,"No Topic Selected",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Selected Topic: $checkedTopicList",Toast.LENGTH_LONG).show()
            }
        }
    }
}