package ctci.starter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ctci.chap1.IsUnique2Test;
import ctci.chap1.IsUnique3Test;
import ctci.chap1.IsUniqueTest;
import ctci.chap1.StringPermutationOfOtherTest;

@RunWith(Suite.class)
@SuiteClasses({ IsUnique2Test.class, IsUniqueTest.class, IsUnique3Test.class, 
	StringPermutationOfOtherTest.class})
public class AllTests {

}
