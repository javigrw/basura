package es.uva.inf.tds.pr2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackBoxContest.class, BlackBoxContestWithWrappers.class, BlackBoxRanking.class,
		BlackBoxRankingWithWrappers.class, ConcursoTest.class, RankingTest.class, SequenceTestContest.class,
		SequenceTestRanking.class })
public class AllTestsSuite {

}
