package localizacaoapp.com.br.localizacaoapp.informacao_sistema

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.telephony.TelephonyManager
import localizacaoapp.com.br.localizacaoapp.permissoes.Permissoes

public class Sistema(var context: Context){
    @SuppressLint("MissingPermission")
    fun getIMEI() : String{
        if(!Permissoes.solicitarPermissoes(context)){
            return ""
        }
        var telephonyManager  = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        var IMEI = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            telephonyManager.imei
        } else {
           telephonyManager.getDeviceId();
        }
        return IMEI
    }
}