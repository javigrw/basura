package es.uva.inf.tds.pr2;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackBoxContest.class, BlackBoxContestWithWrappers.class, ConcursoTest.class,
		SequenceTestContest.class })
public class ConcursoSuite {

}
