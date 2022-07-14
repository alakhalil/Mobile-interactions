package com.example.moodtracker.views;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.moodtracker.databinding.FragmentAnalysisBinding;
import com.example.moodtracker.viewmodels.AnalysisViewModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.example.moodtracker.R;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class AnalysisFragment extends Fragment {

    private FragmentAnalysisBinding binding;
    ArrayList barArraylist;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnalysisViewModel analysisViewModel =
                new ViewModelProvider(this).get(AnalysisViewModel.class);

        binding = FragmentAnalysisBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        BarChart barChart = binding.barchart;
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry (1, 10));
        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry (3, 5));
        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry (5, 10));
        ArrayList<BarEntry> entries4 = new ArrayList<>();
        entries4.add(new BarEntry (7, 14));
        ArrayList<BarEntry> entries5 = new ArrayList<>();
        entries5.add(new BarEntry (9, 12));
        List<IBarDataSet> bars = new ArrayList<IBarDataSet>();
        BarDataSet dataset = new BarDataSet(entries, "Depressed");
        dataset.setColor(Color.parseColor("#6EB2E5"));
        bars.add(dataset);
        BarDataSet dataset2 = new BarDataSet(entries2, "Sad");
        dataset2.setColor(Color.parseColor("#FF6400"));
        bars.add(dataset2);
        BarDataSet dataset3 = new BarDataSet(entries3, "Neutral");
        dataset3.setColor(Color.parseColor("#F0E11D"));
        bars.add(dataset3);
        BarDataSet dataset4 = new BarDataSet(entries4, "Happy");
        dataset4.setColor(Color.parseColor("#469C76"));
        bars.add(dataset4);
        BarDataSet dataset5 = new BarDataSet(entries5, "Hyperactive");
        dataset5.setColor(Color.parseColor("#A810E0"));
        bars.add(dataset5);
        BarData data = new BarData(bars);
        data.setValueTextColor(Color.BLACK);
        data.setBarWidth(1.5f);
        data.setValueTextSize(16f);
        barChart.setData(data);
        barChart.animateY(1000);
        barChart.getAxisLeft().setDrawLabels(false);
        barChart.getAxisRight().setDrawLabels(false);
        barChart.getXAxis().setDrawGridLines(false);
        YAxis rightYAxis = barChart.getAxisRight();
        rightYAxis.setEnabled(false);
        rightYAxis.setDrawGridLines(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(1f);
        barChart.getDescription().setEnabled(false);
        barChart.getLegend().setEnabled(false);
        barChart.invalidate();

        return root;
    }

    private void getData()
    {
        barArraylist = new ArrayList();
        barArraylist.add(new BarEntry(2f,10));
        barArraylist.add(new BarEntry(3f,5));
        barArraylist.add(new BarEntry(4f,10));
        barArraylist.add(new BarEntry(5f,14));
        barArraylist.add(new BarEntry(6f,12));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}