package localizacaoapp.com.br.localizacaoapp.cdn
import android.content.Context
import localizacaoapp.com.br.localizacaoapp.informacao_sistema.Sistema


class ServicoCordenadas{

     fun getCordenada( context: Context) : Cordenada{
         var cordenada = Cordenada()
         var localizacao = Localizacao(context)
         cordenada.latitude = localizacao.getLatitude()
         cordenada.logitude =  localizacao.getLogitude()
         cordenada.imei = Sistema(context).getIMEI()
         return  cordenada
     }



}