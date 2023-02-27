package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.inti.entities.Offre;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>{
//	List<Offre> findByVille(String ville);
//	List<Offre> findByTypeOffre(String typeOffre);
//	List<Offre> findByPrix(float prix);
//	List<Offre> findBySurface(float surface);
//	List<Offre> findByOrientation(String orientation);
	
	List<Offre> findByVille(String ville);

}
