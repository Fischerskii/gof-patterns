package org.example.proxy;

import org.example.Analyzer;
import org.example.PollAnalyzer;
import org.example.components.PollFillingData;
import org.example.strategy.AnalyzeStrategy;

import java.lang.reflect.Field;
import java.util.List;

public class PollAnalyzerProxy implements Analyzer {

    private final Analyzer delegate;
    private String currentStrategy;

    public PollAnalyzerProxy(PollAnalyzer delegate) {
        this.delegate = delegate;
        this.currentStrategy = extractCurrentStrategyName();
    }

    private String extractCurrentStrategyName() {
        try {
            Field field = delegate.getClass().getDeclaredField("strategy");
            field.setAccessible(true);
            Object currentStrategy = field.get(delegate);
            return currentStrategy.getClass().getSimpleName();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return "Unknown strategy";
        }
    }

    @Override
    public void analyzePoll(List<PollFillingData> pollFillingDataList) {

        System.out.println("Current strategy: " + currentStrategy);

        System.out.println("Start analyzing poll data");

        long startTime = System.currentTimeMillis();
        delegate.analyzePoll(pollFillingDataList);
        long endTime = System.currentTimeMillis();
        System.out.println("Poll analysing time: " + (endTime - startTime) + "ms");

        System.out.println("End analyzing poll data \n\n");

    }

    @Override
    public void changeAnalyzeStrategy(AnalyzeStrategy strategy) {
        delegate.changeAnalyzeStrategy(strategy);

        currentStrategy = strategy.getClass().getSimpleName();
    }
}
