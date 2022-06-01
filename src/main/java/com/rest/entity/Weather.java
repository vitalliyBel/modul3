package com.rest.entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.net.URL;
@Component
public class Weather {

    private String temperatura;

    public Weather(String temperatura) {
        this.temperatura = temperatura;
    }

    public Weather() {
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }


    private static Document getPage() throws IOException {

        String url="http://localhost:8081/modul2/api/weather";

        Document page = Jsoup.parse(new URL(url), 3000 );
        return page;
    }

    public String getTemp() throws Exception {

        Document page = getPage();
        Element tableTemp = page.select("body").first();
        temperatura = tableTemp.text();
        return temperatura;
    }
}
