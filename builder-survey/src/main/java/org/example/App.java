package org.example;

import org.example.components.PollFillingData;
import org.example.components.PollQuestion;
import org.example.components.PollQuestionResponse;
import org.example.strategy.AnalyzeStrategy;
import org.example.strategy.impl.FullCountStrategy;
import org.example.strategy.impl.LeastFrequentAnswerStrategy;
import org.example.strategy.impl.MostFrequentAnswerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        Poll poll = Poll.builder()
                .withPollName("Programming Survey")
                .yesNoPollQuestion("Are you programmer?")
                .oneVariantPollQuestion("How many years of programming experience do y ou have?")
                .withAnswerVariant("0-1 years")
                .withAnswerVariant("1-3 years")
                .withAnswerVariant("3-5 years")
                .withAnswerVariant("5+ years")
                .and()
                .oneVariantPollQuestion("What is your favorite programming language?")
                .withAnswerVariant("Java")
                .withAnswerVariant("Python")
                .withAnswerVariant("C++")
                .and()
                .notMandatoryQuestion("Do you like your job?")
                .withMaxAnswers(1)
                .withAnswerVariant("Who knows..")
                .withAnswerVariant("Of course")
                .and()
                .pollQuestion("What are your strong qualities?")
                .withMinAnswers(0)
                .withMaxAnswers(5)
                .withAnswerVariant("Leadership")
                .withAnswerVariant("Teamwork")
                .withAnswerVariant("Problem-solving")
                .withAnswerVariant("Communication")
                .withAnswerVariant("Creativity")
                .and()
                .build();

        List<PollFillingData> pollFillingDataList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            pollFillingDataList.add(generateRandomFillingData(poll));
        }

        AnalyzeStrategy fullCountStrategy = new FullCountStrategy();
        AnalyzeStrategy leastFrequentAnswerStrategy = new LeastFrequentAnswerStrategy();
        AnalyzeStrategy mostFrequentAnswerStrategy = new MostFrequentAnswerStrategy();

//        PollAnalyzer analyzer = new PollAnalyzerProxy(fullCountStrategy);
        PollAnalyzer analyzer = new PollAnalyzer(fullCountStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(leastFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        analyzer.changeAnalyzeStrategy(mostFrequentAnswerStrategy);
        analyzer.analyzePoll(pollFillingDataList);

        }

    private static PollFillingData generateRandomFillingData(Poll poll) {
        Random random = new Random();
        List<PollQuestionResponse> responses = new ArrayList<>();

        for (PollQuestion question : poll.getPollQuestionList()) {
            int minAnswers = question.minAnswers();
            int maxAnswers = question.maxAnswers();
            List<String> answerVariants = question.answers();

            int numberOfAnswers = minAnswers + random.nextInt(maxAnswers - minAnswers + 1);
            List<String> selectedVariants = new ArrayList<>();

            for (int i = 0; i < numberOfAnswers; i++) {
                String randomVariant = answerVariants.get(random.nextInt(answerVariants.size()));
                if(!selectedVariants.contains(randomVariant)) {
                    selectedVariants.add(randomVariant);
                }
            }
            responses.add(new PollQuestionResponse(question, selectedVariants));
        }

        return new PollFillingData("User №" + random.nextInt(), responses);
    }
}
