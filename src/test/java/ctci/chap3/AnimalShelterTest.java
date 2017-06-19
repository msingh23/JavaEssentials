package ctci.chap3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalShelterTest {
	public AnimalShelter shelter;

	@Before
	public void setUp() throws Exception {
		shelter = new AnimalShelter();
		shelter.enqueue(new Dog("dog1"));
		shelter.enqueue(new Cat("cat1"));
		shelter.enqueue(new Cat("cat2"));
		shelter.enqueue(new Cat("cat3"));
		shelter.enqueue(new Dog("dog2"));
		shelter.enqueue(new Dog("dog3"));
		shelter.enqueue(new Cat("cat4"));
	}

	@Test
	public void test() throws Exception {
		Assert.assertTrue(shelter.dequeueDog().name.equals("dog3"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("cat4"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat3"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat2"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat1"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("dog2"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("dog1"));
	}

}
