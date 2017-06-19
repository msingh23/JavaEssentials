/**
 * 
 */
package ctci.chap3;

/**
 * @author manu
 *
 */
public class AnimalShelter {

	private Stack<Animal> animals;
	private Stack<Cat> cats;
	private Stack<Dog> dogs;

	public AnimalShelter() {
		animals = new Stack<Animal>();
		cats = new Stack<Cat>();
		dogs = new Stack<Dog>();
	}

	public void enqueue(Animal animal) {
		if (animal instanceof Dog) {
			dogs.push((Dog) animal);
		}
		if (animal instanceof Cat) {
			cats.push((Cat) animal);
		}
		animals.push(animal);
	}

	public Animal dequeueAny() throws Exception {
		if (animals.isEmpty() || (dogs.isEmpty() && cats.isEmpty())) {
			throw new Exception("Stack is Empty");
		}
		Animal animal = animals.pop();
		if (animal instanceof Dog) {
			if (dogs.isEmpty()) {
				return dequeueAny();
			} else if (animal.name.equals(dogs.peek().name)) {
				dogs.pop();
			} else {
				return dequeueAny();
			}
		}

		if (animal instanceof Cat) {
			if(cats.isEmpty()){
				return dequeueAny();
			}
			else if ( animal.name.equals(cats.peek().name)) {
				cats.pop();
			} else {
				return dequeueAny();
			}
		}
		return animal;
	}

	public Dog dequeueDog() throws Exception {
		if (dogs.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		Dog dog = dogs.pop();
		if (dog.name.equals(animals.peek().name)) {
			animals.pop();
		}
		return dog;
	}

	public Cat dequeueCat() throws Exception {
		if (cats.isEmpty()) {
			throw new Exception("Stack is empty");
		}
		Cat cat = cats.pop();
		if (cat.name.equals(animals.peek().name)) {
			animals.pop();
		}
		return cat;
	}

}
