package com.fruit.web.fruit;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class FruitDao {

	private ArrayList<Fruit> fruitList;
	private int index;
	
	public FruitDao() {
		fruitList = new ArrayList<Fruit>();
		index = 0;
	}
	
	public ArrayList<Fruit> getFruitList() {
		return fruitList;
	}
	
	public void insertFruit(Fruit fruit) {
		fruit.setFruitId(++index);
		fruitList.add(fruit);
	}

	public Fruit getFruitByFruitId(int fruitId) {
		Fruit returnFruit = null;
		for (Fruit fruit : fruitList) {
			if(fruit.getFruitId() == fruitId) {
				returnFruit = fruit;
			}
		}
		return returnFruit;
	}

	public void updateFruit(Fruit newFruit) {
		for (Fruit fruit : fruitList) {
			if(fruit.getFruitId() == newFruit.getFruitId()) {
				fruit.setName(newFruit.getName());
			}
		}
	}
	
	public void deleteFruitByFruitId(int fruitId) {
		for (Fruit fruit : fruitList) {
			if(fruit.getFruitId() == fruitId) {
				fruitList.remove(fruit);
				break;
			}
		}
	}



}
