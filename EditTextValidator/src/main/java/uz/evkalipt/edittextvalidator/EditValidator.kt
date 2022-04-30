package uz.evkalipt.edittextvalidator

import android.widget.EditText
import android.widget.Spinner
import androidx.core.widget.addTextChangedListener

object EditValidator {

    fun passwordValidator(password:EditText, rePassword:EditText):Boolean{
        var boolean = false
        rePassword.addTextChangedListener {
            if (password.text.toString()
                    .trim() != "" && password.text.toString() == rePassword.text.toString()
            ) {
                rePassword.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_check_24,
                    0
                )
                boolean = true
            } else {
                rePassword.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_info_24,
                    0
                )
                boolean = false
            }
        }

        password.addTextChangedListener {
            if (password.text.toString()
                    .trim() != "" && password.text.toString() == rePassword.text.toString()
            ) {
                if (rePassword.text.toString().trim()!="") {
                    rePassword.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_check_24,
                        0
                    )
                    boolean = true
                }
            } else {
                if (rePassword.text.toString().trim()!="") {
                    rePassword.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_info_24,
                        0
                    )
                    boolean = false
                }
            }
        }

        return boolean
    }

    fun emailAddress(emailAddress:EditText):Boolean{
        var emailAddress1 = false
        emailAddress.addTextChangedListener {
            if (emailAddress.text.toString().trim() != "" && emailAddress.text.toString()
                    .substring(0, 1) != "@" && emailAddress.text.toString().contains("@")
            ) {
                emailAddress.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_check_24,
                    0
                )
                emailAddress1 = true
            } else {
                emailAddress.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_info_24,
                    0
                )
                emailAddress1 = false
            }
        }
        return emailAddress1
    }

    fun ipAddress(iPAddress: EditText):Boolean{

        var iPAddress1 = false

        iPAddress.addTextChangedListener {
            try {
                var ip1 = -1
                var ip2 = -1
                var ip3 = -1
                var ip4 = -1

                var count = 0

                var str = iPAddress.text.toString()
                var length = iPAddress.text.toString().length
                var index = -1
                for (i in 0 until length){
                    if (str[i].toString() == "."){
                        ip1 = str.substring(0, i).toInt()
                        count++
                        index = i
                        break
                    }
                }

                for (i in index+1 until length){
                    if (str[i].toString() == "."){
                        ip2 = str.substring(index+1, i).toInt()
                        index = i
                        count++
                        break
                    }
                }

                for (i in index+1 until length){
                    if (str[i].toString() == "."){
                        ip3 = str.substring(index+1, i).toInt()
                        index = i
                        count++
                        break
                    }
                }

                for (i in index+1 until length) {
                    if (count==3) {
                        ip4 = str.substring(index + 1, length).toInt()
                    }
                }


                if (ip1 in 0..255 && ip2 in 0..255 && ip3 in 0..255 && ip4 in 0..255){
                    iPAddress.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0)
                    iPAddress1 = true
                }else{
                    iPAddress.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
                    iPAddress1 = false
                }
            }catch (e:NumberFormatException){
                iPAddress.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
                iPAddress1 = false
            }

        }
        return iPAddress1
    }

    fun telephoneNumber(telephoneNumber: EditText):Boolean{
        var telephoneNumber1 = false
        telephoneNumber.addTextChangedListener {
            if (telephoneNumber.text.toString().trim() != "") {
                if (telephoneNumber.text.toString().substring(
                        0,
                        1
                    ) == "+" && telephoneNumber.text.toString().length >= 10 && telephoneNumber.text.toString().length <= 15 && telephoneNumber.text.toString()
                        .trim() != ""
                ) {
                    telephoneNumber.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_check_24,
                        0
                    )
                    telephoneNumber1 = true
                } else {
                    telephoneNumber.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_info_24,
                        0
                    )
                    telephoneNumber1 = false
                }
            }
        }
        return telephoneNumber1
    }

    fun zipCode(zipCode: EditText):Boolean{
        var zipCode1 = false
        zipCode.addTextChangedListener {
            if (zipCode.text.toString().trim()!="" && zipCode.text.toString().length<=10 && zipCode.text.toString().length>=5){
                zipCode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0)
                zipCode1 = true
            }else{
                zipCode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
                zipCode1 = false
            }
        }
        return zipCode1
    }

    fun year(year: EditText):Boolean{
        var year1 = false

        year.addTextChangedListener {
            if (year.text.toString().trim()!="" && year.text.toString().toInt()<=2004 && year.text.toString().toInt()>=1910){
                year.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0)
                year1 = true
            }else{
                year.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
                year1 = false
            }
        }
        return year1
    }

}