package org.example;

import org.example.components.PollFillingData;
import org.example.facade.PollLifecycleFacade;

import java.util.List;

public class App {
    public static void main(String[] args) {
        PollLifecycleFacade pollLifecycleFacade = new PollLifecycleFacade();

        Poll poll = pollLifecycleFacade.createPoll();

        List<PollFillingData> userResponses = pollLifecycleFacade.getUserResponses(poll);

        pollLifecycleFacade.makeAnalyzePoll(userResponses);
    }
}
