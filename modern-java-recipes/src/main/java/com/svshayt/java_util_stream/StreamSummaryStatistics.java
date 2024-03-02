package com.svshayt.java_util_stream;

import com.svshayt.models.Team;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class StreamSummaryStatistics {
    public static void main(String[] args) {
        // Сводные статистики
        DoubleSummaryStatistics stats = DoubleStream.generate(Math::random)
                .limit(1_000_000)
                .summaryStatistics();
        System.out.println(stats); // Печатать методом toString
        System.out.println("count: " + stats.getCount());
        System.out.println("min : " + stats.getMin());
        System.out.println("max : " + stats.getMax());
        System.out.println("sum : " + stats.getSum());
        System.out.println("ave : " + stats.getAverage());

        var teams = List.of(
                new Team(1, "Los Angeles Dodgers", 245_269_535.00),
                new Team(2, "Boston Red Sox", 202_135_939.00),
                new Team(3, "New York Yankees", 202_095_552.00)
        );
        // Метод collect с поставщиком, аккумулятором и комбинатором
        DoubleSummaryStatistics teamStats = teams.stream()
                .mapToDouble(Team::getSalary)
                .collect(DoubleSummaryStatistics::new,
                        DoubleSummaryStatistics::accept,
                        DoubleSummaryStatistics::combine);

        System.out.println(teamStats);

        // Метод collect с использованием summarizingDouble
        teamStats = teams.stream()
                .collect(Collectors.summarizingDouble(Team::getSalary));
        System.out.println(teamStats);
    }
}
