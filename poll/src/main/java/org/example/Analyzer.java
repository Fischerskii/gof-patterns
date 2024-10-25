package org.example;

import org.example.components.PollFillingData;
import org.example.strategy.AnalyzeStrategy;

import java.util.List;

public interface Analyzer {

    void analyzePoll(List<PollFillingData> pollFillingDataList);

    void changeAnalyzeStrategy(AnalyzeStrategy strategy);
}
