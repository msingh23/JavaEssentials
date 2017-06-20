/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class AnimalShelter2 {

	public Queue<Dog> dogs;
	public Queue<Cat> cats;

	public AnimalShelter2() {
		dogs = new Queue<Dog>();
		cats = new Queue<Cat>();
	}

	public Animal dequeueAny() throws Exception {
		if (dogs.isEmpty()) {
			return cats.dequeue();
		}
		if (cats.isEmpty()) {
			return dogs.dequeue();
		}

		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (cat.order < dog.order) {
			return cats.dequeue();
		} else {
			return dogs.dequeue();
		}

	}

	public Dog dequeueDog() throws Exception {
		if (dogs.isEmpty()) {
			throw new Exception("No more dogs");
		}
		return dogs.dequeue();
	}

	public Cat dequeueCat() throws Exception {
		if (cats.isEmpty()) {
			throw new Exception("No more cats");
		}
		return cats.dequeue();
	}

	public void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.enqueue((Dog) animal);
		}
		if (animal instanceof Cat) {
			cats.enqueue((Cat) animal);
		}
	}
}
