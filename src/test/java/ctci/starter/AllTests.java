package ctci.starter;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ctci.chap1.IsUnique2Test;
import ctci.chap1.IsUnique3Test;
import ctci.chap1.IsUniqueTest;
import ctci.chap1.OneEditDistanceStringTest;
import ctci.chap1.PalindromePermTest;
import ctci.chap1.RotateMatrixTest;
import ctci.chap1.StringCompressionTest;
import ctci.chap1.URLifyStringTest;
import ctci.chap1.ZeroMatrixTest;
import ctci.chap2.KthElementFromEndTest;
import ctci.chap2.NodeTest;
import ctci.chap2.RemoveDuplicatesTest;
import ctci.chap1.StringPermutationOfOtherTest;
import ctci.chap1.StringRotationTest;

@RunWith(Suite.class)
@SuiteClasses({ IsUnique2Test.class, IsUniqueTest.class, IsUnique3Test.class, StringPermutationOfOtherTest.class,
		URLifyStringTest.class, PalindromePermTest.class, OneEditDistanceStringTest.class, StringCompressionTest.class,
		RotateMatrixTest.class, ZeroMatrixTest.class, StringRotationTest.class, NodeTest.class,
		RemoveDuplicatesTest.class, KthElementFromEndTest.class })
public class AllTests {

}
