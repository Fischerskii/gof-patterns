package org.example;

import org.example.dataObjects.PollFillingData;
import org.example.dataObjects.PollQuestion;
import org.example.dataObjects.PollQuestionResponse;
import org.example.strategy.AnalyzeStrategy;
import org.example.strategy.impl.FullCountStrategy;
import org.example.strategy.impl.LeastFrequentAnswerStrategy;
import org.example.strategy.impl.MostFrequentAnswerStrategy;

import java.util.List;

public class App {
    public static void main(String[] args) {

        List<PollFillingData> pollFillingDataList = List.of(
                new PollFillingData("sid", List.of(new PollQuestionResponse(new PollQuestion(), List.of(""))))
        );


        AnalyzeStrategy fullCountStrategy = new FullCountStrategy();
        AnalyzeStrategy leastFrequentAnswerStrategy = new LeastFrequentAnswerStrategy();
        AnalyzeStrategy mostFrequentAnswerStrategy = new MostFrequentAnswerStrategy();

        PollAnalyzer analyzer = new PollAnalyzerProxy(fullCountStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(leastFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(mostFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);
    }
}
