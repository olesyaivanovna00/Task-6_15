package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static demo.NormalDistributionDemo2.createChart;

public class VisualiseMapCompare extends JDialog {
    private JComboBox boxOfDataType;

    private JComboBox boxOfActions;
    private JButton buttonComplete;
    private JScrollPane scrollChartArea;
    private JPanel chartArea;
    private JPanel contentPane;

    private JTextField inputLenOfKey;

    private XYSeriesCollection series = new XYSeriesCollection();

    public VisualiseMapCompare() {
        setContentPane(contentPane);
        setModal(true);

        ChartPanel panel = new ChartPanel(createChart(series));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.white);
        chartArea.setLayout(new FlowLayout());
        chartArea.add(panel);

        boxOfDataType.addItem("Integer");
        boxOfDataType.addItem("Double");

        boxOfActions.addItem("Add");
        boxOfActions.addItem("Search");
        boxOfActions.addItem("Delete");
        boxOfActions.addItem("Add and delete");
        boxOfActions.addItem("Delete and Add");

        buttonComplete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                series.removeAllSeries();
                int lenOfKey = 0;

                try {
                    lenOfKey = Integer.parseInt(inputLenOfKey.getText());
                    int countOfEl[] = {100, 500, 1000, 1500, 2000, 2500};
                    countOfEl = new int[500];
                    for (int i = 0; i < countOfEl.length; i++)
                        countOfEl[i] = (i+1)*100;

                    ArrayList<MapInfo> exp = new ArrayList<>();

                    XYSeries hashMapJava = new XYSeries("HashMapJava");
                    XYSeries treeMapJava = new XYSeries("TreeMapJava");
                    XYSeries myHashMap = new XYSeries("MyHashMap");
                    XYSeries myTreeMap = new XYSeries("MyTreeMap");

                    for (int i = 0; i < countOfEl.length; i++) {
                        //System.out.println("Iteration #" + i);
                        exp = AllMapInfo.buildPoints(boxOfActions.getSelectedItem().toString(), boxOfDataType.getSelectedItem().toString(), lenOfKey, countOfEl[i]);

                        hashMapJava.add(countOfEl[i], exp.get(0).getTimeMs());

                        treeMapJava.add(countOfEl[i], exp.get(1).getTimeMs());

                        myHashMap.add(countOfEl[i], exp.get(2).getTimeMs());

                        myTreeMap.add(countOfEl[i], exp.get(3).getTimeMs());
                    }
                    series.addSeries(hashMapJava);
                    series.addSeries(treeMapJava);
                    series.addSeries(myHashMap);
                    series.addSeries(myTreeMap);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null,
                            "Не число!", "Ошибка", JOptionPane.ERROR_MESSAGE);

                }


            }
        });


    }
}

