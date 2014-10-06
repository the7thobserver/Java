import java.util.ArrayList;
import java.util.List;

/**
 * The Person class is used to model a family tree. The references to father,
 * mother, and children allow you to link the Person objects together so that
 * you can build a representation of a real family tree.
 */
public class Person {
	Person father;
	Person mother;
	Gender gender;
	Integer age;
	List<Person> children;

	public enum Gender {
		Male, Female;
	}
	/**
	 * Returns a list of Person objects which represent the oldest sisters of
	 * this Person instance. A sister of a Person is someone who shares at least
	 * one parent, but not necessarily both parents. The reason the return value
	 * is a List<Person> instead of a single Person instance is because it's
	 * possible that there are multiple female siblings that are the same age
	 * (twins, oldest daughter and mother's and father's side same age, etc...)
	 * There will be no duplicate Person objects. The returned list should not
	 * include this Person
	 * 
	 * @return List of Person or empty List if there are no sisters
	 */
	public List<Person> getOldestSisters() {
		// Hold the final result
		List<Person> oldestChildren = new ArrayList<Person>();

		// Temp
		List<Person> temp = father.children;
		// Keep track of oldest
		Person oldest = new Person();
		oldest.age = -1;

		// Check if not null
		if(temp .get(0) != null)
		{          
			// Look at all the childrens ages and find oldest
			for(int i = 0; i < temp.size(); i++)
			{
				// Pretty sure Integer objects can be compared with < operator
				// Unsure how to do
				if((oldest.age < temp.get(i).age) && (temp.get(i).gender == Gender.Female))
					oldest = temp.get(i);
				// need to check if equals for twins
				else if ((oldest.age == temp.get(i).age) && (temp.get(i).gender == Gender.Female))
				{
					oldestChildren.add(temp.get(i));
				}
			}
		}

		temp = mother.children;
		
		// Check if not null
		if (temp.get(0) != null) {
			// Look at all the childrens ages and find oldest
			for (int i = 0; i < temp.size(); i++) {
				// Pretty sure Integer objects can be compared with < operator
				// Unsure how to do
				if((oldest.age < temp.get(i).age) && (temp.get(i).gender == Gender.Female))
					oldest = temp.get(i);
				// need to check if equals for twins
				else if ((oldest.age == temp.get(i).age) && (temp.get(i).gender == Gender.Female))			
				{
					// Check if same person
					if(temp.get(i).father.equals(oldest.father))
						continue;
					else
						oldestChildren.add(temp.get(i));
				}
			}
		}

		
		
		// Check if there were any children
		if (!oldest.age.equals(-1))
			oldestChildren.add(oldest);

		return oldestChildren;
	}
	
	public boolean equals(Person person)
	{
		if(person.children.size() != father.children.size())
			return false;
		
		// Sorted?
		for(int i = 0; i < person.children.size(); i++)
		{
			if (person.children.get(i).age == father.children.get(i).age)
			{
				if(person.children.get(i).gender == father.children.get(i).gender)
				{
					continue;
				}
				else
					return false;
			}
			else
				return false;
		}
		
		return true;
	}
}