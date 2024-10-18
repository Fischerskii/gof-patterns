package org.example;

import org.example.strategy.AnalyzeStrategy;

public class PollAnalyzerProxy extends PollAnalyzer {
    public PollAnalyzerProxy(AnalyzeStrategy fullCountStrategy) {
        super(fullCountStrategy);
    }
}
