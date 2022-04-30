package uz.evkalipt.edittextvalidator

import android.widget.EditText
import android.widget.Spinner
import androidx.core.widget.addTextChangedListener

object EditValidator {

    fun passwordValidator(password:EditText, rePassword:EditText):Boolean{
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
            } else {
                rePassword.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_info_24,
                    0
                )
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
                }
            } else {
                if (rePassword.text.toString().trim()!="") {
                    rePassword.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_info_24,
                        0
                    )
                }
            }
        }

        return password.text.toString()==rePassword.text.toString()
    }

    fun emailAddress(emailAddress:EditText):Boolean{
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
            } else {
                emailAddress.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.ic_baseline_info_24,
                    0
                )
            }
        }
        return emailAddress.text.toString().trim() != "" && emailAddress.text.toString()
            .substring(0, 1) != "@" && emailAddress.text.toString().contains("@")
    }

    fun ipAddress(iPAddress: EditText):Boolean{

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
                }else{
                    iPAddress.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
                }
            }catch (e:NumberFormatException){
                iPAddress.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
            }

        }

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


            return ip1 in 0..255 && ip2 in 0..255 && ip3 in 0..255 && ip4 in 0..255
        }catch (e:NumberFormatException){
            return false
        }

    }

    fun telephoneNumber(telephoneNumber: EditText):Boolean{
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
                } else {
                    telephoneNumber.setCompoundDrawablesWithIntrinsicBounds(
                        0,
                        0,
                        R.drawable.ic_baseline_info_24,
                        0
                    )
                }
            }
        }
        return telephoneNumber.text.toString().substring(
            0,
            1
        ) == "+" && telephoneNumber.text.toString().length >= 10 && telephoneNumber.text.toString().length <= 15 && telephoneNumber.text.toString()
            .trim() != ""
    }

    fun zipCode(zipCode: EditText):Boolean{
        zipCode.addTextChangedListener {
            if (zipCode.text.toString().trim()!="" && zipCode.text.toString().length<=10 && zipCode.text.toString().length>=5){
                zipCode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24,0)
            }else{
                zipCode.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
            }
        }
        return zipCode.text.toString().trim()!="" && zipCode.text.toString().length<=10 && zipCode.text.toString().length>=5

    }

    fun year(year: EditText):Boolean{

        year.addTextChangedListener {
            if (year.text.toString().trim()!="" && year.text.toString().toInt()<=2004 && year.text.toString().toInt()>=1910){
                year.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_check_24, 0)
            }else{
                year.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_baseline_info_24, 0)
            }
        }
        return year.text.toString().trim()!="" && year.text.toString().toInt()<=2004 && year.text.toString().toInt()>=1910
    }

}