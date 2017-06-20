package ctci.chap3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalShelterTest2 {
	public AnimalShelter2 shelter;

	@Before
	public void setUp() throws Exception {
		shelter = new AnimalShelter2();
		shelter.enqueue(new Dog("dog1", 1));
		shelter.enqueue(new Cat("cat1", 2));
		shelter.enqueue(new Cat("cat2", 3));
		shelter.enqueue(new Cat("cat3", 4));
		shelter.enqueue(new Dog("dog2", 5));
		shelter.enqueue(new Dog("dog3", 6));
		shelter.enqueue(new Cat("cat4", 7));
	}

	@Test
	public void test() throws Exception {
		Assert.assertTrue(shelter.dequeueDog().name.equals("dog1"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("cat1"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat2"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat3"));
		Assert.assertTrue(shelter.dequeueCat().name.equals("cat4"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("dog2"));
		Assert.assertTrue(shelter.dequeueAny().name.equals("dog3"));
	}

}
