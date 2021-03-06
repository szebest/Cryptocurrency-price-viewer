package com.company.cryptocurrencies;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketDataApi {

    private static JSONObject dataObject;
    private static Cryptocurrency cryptocurrency;

    public void getData(Cryptocurrency cryptocurrency)
    {
        this.cryptocurrency = cryptocurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://min-api.cryptocompare.com/data/pricemultifull?fsyms="+cryptocurrency.getCurrentCryptocurrency()+"&tsyms="+cryptocurrency.getCurrentCurrency())).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(MarketDataApi::parse)
                .join();
    }

    private static void parse(String responseData)
    {
        dataObject= new JSONObject(responseData);
        dataObject= dataObject.getJSONObject("RAW").getJSONObject(cryptocurrency.getCurrentCryptocurrency()).getJSONObject(cryptocurrency.getCurrentCurrency());
        setData(dataObject);

    }

    private static void setData(JSONObject dataObject)
    {
        cryptocurrency.setPrice(dataObject.getFloat("PRICE"));
        cryptocurrency.setChange24H(dataObject.getFloat("CHANGE24HOUR"));
        cryptocurrency.setAveragePrice((dataObject.getFloat("HIGHDAY")+dataObject.getFloat("LOWDAY"))/2);
    }


}
