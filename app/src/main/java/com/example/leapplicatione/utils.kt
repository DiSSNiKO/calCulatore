package com.example.leapplicatione

import android.text.TextUtils.lastIndexOf
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton


class utils {
    fun executoOperation (num1: Double, num2: Double, oper: String): Double {
        when (oper) {
            "-" -> {
                return num1 - num2
            }
            "+" -> {
                return num2 + num1
            }
            "x" -> {
                return num2 * num1
            }
            "/" -> {
                return num1 / num2
            }
            "%" -> {
                return num2/(num1/100)
            }
        }
        return 0.0
    }
    fun removeDotZero(str:String):String {
        var newstr = ""
        val lastIndex = str.length - 1
        if(str!=null && str.length>=3){
            if (str[lastIndex]=='0'&&str[lastIndex-1]=='.') {
                for(i in str){
                    if(i=='.'){
                        break
                    }
                    newstr+=i.toString()
                }
                return newstr

            } else {
                return str
            }
        }
        return str
    }
    fun scuffedRoundToTwoDecimals (dubl:Double):String {
        var str = ""
        var count = 0
        var pointEncounter = false
        for(i in dubl.toString()){
            str+=i
            if(i=='.'){
                pointEncounter = true
            }
            if(pointEncounter){
                count++
            }
            if(count == 3){
                break
            }
        }
        return str
    }
    fun AddToMainNumStr(str:String?, addStr:String, mainNum:TextView) : String {
        if (str != null) {
            if(str.contains(".") && addStr == ".") {
                return ""
            }
        }
        var newValue = ""
        if(str=="0"&&(addStr!="."&&addStr!="0")){
            newValue = addStr
            mainNum.setText(newValue)
            return newValue
        } else {
            newValue = str+addStr
            mainNum.setText(newValue)
            return newValue
        }
    }
    fun mainNumToDouble(mainNumStr:String): Double {
        var duble : Double = 0.0
        try {
            duble = java.lang.Double.valueOf(mainNumStr)
        } catch (e:java.lang.NumberFormatException) {

        }
        return duble
    }
    fun clearAll ( mainNum:TextView): String {
        mainNum.setText("0")
        return "0"
    }

}
