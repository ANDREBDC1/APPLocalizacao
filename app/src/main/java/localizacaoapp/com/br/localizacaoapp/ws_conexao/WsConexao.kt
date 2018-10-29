package localizacaoapp.com.br.localizacaoapp.ws_conexao
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import localizacaoapp.com.br.localizacaoapp.cdn.ServicoCordenadas
import java.net.HttpURLConnection
import java.net.URL
import java.util.*
import java.io.PrintStream


var url = "https://andre-rian-da-conceicao-silva.000webhostapp.com/WSCordenadasPHP/ServicosWs.php"

class WsConexao{
    fun salvarCordenadasWs(context: Context) : Boolean{
        var cordenada = ServicoCordenadas().getCordenada(context)

        var g = Gson()
        var json = g.toJson(cordenada)
        var teste = sendPost(url, json)
        Log.e("Ws", teste)

        return true

    }

    fun sendPost(url : String, json: String) : String{

        try {
            var  url = URL(url)
            var con = url.openConnection() as HttpURLConnection

            con.setRequestProperty("Accept", "application/json")
            con.setRequestProperty("Content-type", "application/json")
            con.requestMethod ="POST"
            con.doInput = true
            con.doOutput = true
            con.setConnectTimeout(20000)
            con.setReadTimeout(20000)

            val printStream = PrintStream(con.getOutputStream())
            printStream.println(json)
            con.connect()
            var inputStream = con.inputStream
            var jsonDeResposta =  Scanner(inputStream, "UTF-8").next()

            return  jsonDeResposta;
        }catch (ex : Exception){
            Log.e("Ws",ex.message)
        }
        return ""
    }
}