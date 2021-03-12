package com.company.cryptocurrencies;

import org.json.JSONArray;
import org.json.JSONObject;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketDataApi {

    private static JSONObject apiDataObject;
    private static Cryptocurrency cryptocurrency;
    private static Chart chart;

    public MarketDataApi(Cryptocurrency cryptocurrency, Chart chart)
    {
        this.cryptocurrency=cryptocurrency;
        this.chart = chart;

    }

    public void getData()
    {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://min-api.cryptocompare.com/data/pricemultifull?fsyms=" + cryptocurrency.getCurrentCryptocurrency() + "&tsyms=" + cryptocurrency.getCurrentCurrency())).build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenAccept(MarketDataApi::parseData)
                    .join();
    }

    private static void parseData(String responseData)
    {

            apiDataObject = new JSONObject(responseData);
            apiDataObject = apiDataObject.getJSONObject("RAW").getJSONObject(cryptocurrency.getCurrentCryptocurrency()).getJSONObject(cryptocurrency.getCurrentCurrency());
            setData(apiDataObject);

    }

    private static void setData(JSONObject dataObject)
    {
        cryptocurrency.setPrice(dataObject.getFloat("PRICE"));
        cryptocurrency.setChange24H(dataObject.getFloat("CHANGE24HOUR"));
        cryptocurrency.setAveragePrice((dataObject.getFloat("HIGHDAY")+dataObject.getFloat("LOWDAY"))/2);
    }

    public void getHourlyChartData()
    {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://min-api.cryptocompare.com/data/v2/histohour?fsym="+cryptocurrency.getCurrentCryptocurrency()+"&tsym="+ cryptocurrency.getCurrentCurrency()+"&limit=10")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(MarketDataApi::parseChartData)
                .join();
    }

    public void getDailyChartData()
    {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://min-api.cryptocompare.com/data/v2/histoday?fsym="+cryptocurrency.getCurrentCryptocurrency()+"&tsym="+ cryptocurrency.getCurrentCurrency()+"&limit=10")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(MarketDataApi::parseChartData)
                .join();
    }

    private static void parseChartData(String responseData)
    {
        JSONObject data = new JSONObject(responseData);
        JSONArray array = data.getJSONObject("Data").getJSONArray("Data");
        setChartData(array);

    }

    private static void setChartData(JSONArray array)
    {
        JSONObject tmp;
        for(int i=2;i<array.length();i++)
        {
            tmp=array.getJSONObject(i);
            chart.addPrice(tmp.getFloat("open"));
            chart.addTimestamp(tmp.getInt("time"));
        }


    }


}
