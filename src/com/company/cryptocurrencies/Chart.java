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
    private ChartFrame previousChart;
    private boolean dailyChartDataRange = false;
    private  JFreeChart chart;
    private DefaultCategoryDataset chartDataSet;
    private Toolkit kit = Toolkit.getDefaultToolkit();
    private Dimension screenSize = kit.getScreenSize();




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
        deletePreviousChart();
        createDataset("Price");

        if(dailyChartDataRange=true) {
           chart = ChartFactory.createLineChart(currentCurrency, "Date", "", chartDataSet);
        }
        else
        {
             chart = ChartFactory.createLineChart(currentCurrency, "Time", "", chartDataSet);
        }

        setChartProperties();
        createChartFrame();


    }



    private void createDataset(String legendName)
    {
        chartDataSet = new DefaultCategoryDataset();

            for(int i =0;i<prices.size();i++)
            {
                chartDataSet.addValue(prices.get(i),legendName,convertTimestamp(timestamps.get(i)));
            }
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

    private void deletePreviousChart()

    {
        if(previousChart !=null)
        {
            previousChart.dispatchEvent(new WindowEvent(previousChart,WindowEvent.WINDOW_CLOSING));
        }
    }

    private void setChartProperties()
    {
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.GREEN);
        chart.getLegend().setFrame(BlockBorder.NONE);
        chart.getLegend().setItemFont(new Font("Serif", Font.BOLD, 20 ));
    }

    private void createChartFrame()
    {
        ChartFrame chartFrame = new ChartFrame("Chart",chart);
        chartFrame.setSize(500,430);
        chartFrame.setResizable(false);
        chartFrame.setAlwaysOnTop(true);
        chartFrame.setVisible(true);

        previousChart =chartFrame;

        chartFrame.setLocation(screenSize.width/2-screenSize.width/20,screenSize.height/4+screenSize.height/80);
    }

}
