package localizacaoapp.com.br.localizacaoapp.ws_conexao
import android.content.Context
import com.google.gson.Gson
import localizacaoapp.com.br.localizacaoapp.cdn.ServicoCordenadas
import java.io.DataOutputStream
import java.net.HttpURLConnection
import java.net.URL



var url = "http://localhost:8080/AplicacaoWebService/webresources/wsConection/cordenada/inserir/"

class WsConexao{
    fun salvarCordenadasWs(context: Context) : Boolean{
        var cordenada = ServicoCordenadas().getCordenada(context)

        //var type = TypeToken<Cordenada>().type

        var g = Gson()

        var jason = g.toJson(cordenada)


        return false
    }

    fun sendPost(url : String, urlParameters: String, metodo: String){
        var obj = URL(url)
        var conn = obj.openConnection() as HttpURLConnection

        conn.requestMethod = metodo
        conn.setRequestProperty("Content-Type", "application/json")
        conn.setRequestProperty("User-Agent", "USER_AGENT")
        conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5")

        conn.setDoOutput(true)
        val wr = DataOutputStream(conn.getOutputStream())
        wr.writeBytes(urlParameters)
        wr.flush()
        wr.close()

        var responseCode = conn.getResponseCode()

//        var inn = BufferedReader(InputStreamReader(conn.getInputStream()))
//        var inputLine = inn.readLine()
//        val response = StringBuffer()
//           while (inputLine = inn?.readLine()) {
//               response.append(inputLine)
//           }
//
//
//
//        inn.close()
    }
}