package com.company.cryptocurrencies;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.block.BlockBorder;
import org.jfree.data.category.DefaultCategoryDataset;


import java.awt.*;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;

public class Chart {

    private ArrayList<Long>timestamps;
    private ArrayList<Float>prices;
    private ChartFrame previousFrame;
    private boolean dailyChartDataRange = false;
    private  JFreeChart chart;




    public Chart()
    {
        timestamps = new ArrayList<>();
        prices = new ArrayList<>();

    }


    public void clearArray()
    {
        timestamps.clear();
        prices.clear();
    }

    public void addPrice(float value)
    {
        prices.add(value);
    }

    public void addTimestamp(long timestamp)
    {
        timestamps.add(timestamp);
    }

    public void setDailyChartDataRange(boolean tmp)
    {
        dailyChartDataRange =tmp;
    }





    public void createChart(String currentCurrency)
    {

        if(previousFrame!=null)
        {
            previousFrame.dispatchEvent(new WindowEvent(previousFrame,WindowEvent.WINDOW_CLOSING));
        }

        DefaultCategoryDataset dataset = createDataset("Price");

        if(dailyChartDataRange=true) {
           chart = ChartFactory.createLineChart(currentCurrency, "Date", "", dataset);
        }
        else
        {
             chart = ChartFactory.createLineChart(currentCurrency, "Time", "", dataset);
        }

        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.GREEN);
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.getLegend().setItemFont(new Font("Serif", Font.BOLD, 20 ));


     ChartFrame chartFrame = new ChartFrame("Chart",chart);
     chartFrame.setSize(500,430);
     chartFrame.setResizable(false);

    chartFrame.setAlwaysOnTop(true);
    chartFrame.setVisible(true);

     previousFrame=chartFrame;

       Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        chartFrame.setLocation(screenSize.width/2-screenSize.width/20,screenSize.height/4+screenSize.height/80);
    }



    private DefaultCategoryDataset createDataset(String currentCurrency)
    {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for(int i =0;i<prices.size();i++)
            {
                dataset.addValue(prices.get(i),currentCurrency,convertTimestamp(timestamps.get(i)));
            }
            return dataset;
    }

    private String convertTimestamp( long timestamp)
    {

        Instant instant = Instant.ofEpochSecond(timestamp);
        Timestamp tmp = Timestamp.from(instant);
        Date date = new Date(tmp.getTime());

        if(dailyChartDataRange) {
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM");
            String stringDate = DateFor.format(date);
            return stringDate;
        }
        else
        {
            SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm");
            String stringDate = DateFor.format(date);
            return stringDate;
        }
    }

}
