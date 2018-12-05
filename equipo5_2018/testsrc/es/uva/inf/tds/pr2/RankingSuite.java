package es.uva.inf.tds.pr2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackBoxRanking.class, BlackBoxRankingWithWrappers.class, RankingTest.class,
		SequenceTestRanking.class })
public class RankingSuite {

}
