package br.com.b2w.starwars.api.domain;

import lombok.ToString;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@ToString
public class Terrain {
	
	private final Set<String> vegetations;
	
	private Terrain() {
		this.vegetations = new HashSet<String>();
	}
	
	public static Terrain init() {
		return new Terrain();
	}
	
	public static Terrain init(Set<String> vegetations) {
		Terrain terrain = new Terrain();
		terrain.addAllVegetation(vegetations);
		return terrain;
	}
	
	public Set<String> getVegetations() {
		return Collections.unmodifiableSet(vegetations);
	}
	
	public Terrain addVegetation(String vegetation) {
		if (vegetation == null) {
			throw new NullPointerException("Vegetation can not be null");
		}
		this.vegetations.add(vegetation);
		return this;
	}
	
	public Boolean addAllVegetation(Set<String> vegetations) {
		return this.vegetations.addAll(vegetations);
	}
	
	public void clearVegetation() {
		this.vegetations.clear();
	}

}