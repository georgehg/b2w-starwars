package br.com.b2w.starwars.api.service;

import java.util.List;

import br.com.b2w.starwars.api.domain.Planet;
import br.com.b2w.starwars.api.repository.PlanetRepository;

public class PlanetService {
	
	private final PlanetRepository planetRepo;
	
	public PlanetService(PlanetRepository planetRepo) {
		this.planetRepo = planetRepo;
	}

	public Planet newPlanet(Planet planet) {
		return planetRepo.save(planet);
	}

	public List<Planet> getPlanetsList() {
		return planetRepo.findAll();
	}

	public boolean notExists(String planetId) {
		return ! planetRepo.exists(planetId);
	}

	public Planet getPlanet(String planetId) {
		return planetRepo.findOne(planetId);
	}

	public Planet searchPlanet(String name) {
		return planetRepo.findByName(name);
	}

	public void remove(String planetId) {
		planetRepo.delete(planetId);		
	}

}
