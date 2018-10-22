package localizacaoapp.com.br.localizacaoapp.cdn;

import android.content.Intent;

import java.util.Date;

public class Cordenada {
    private int id;
    private double Latitude;
    private double Logitude;
    private Date Data;
    private String IMEI;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLogitude() {
        return Logitude;
    }

    public void setLogitude(double logitude) {
        Logitude = logitude;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }
}
