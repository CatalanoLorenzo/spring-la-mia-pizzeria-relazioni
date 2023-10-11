package org.java.app.db.pojo;

import org.java.app.db.pojo.pizza.OffertaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OffertaService {

	@Autowired
	OffertaRepo offertaRepo;

	public void OffertaSave(Offerta offerta) {
		offertaRepo.save(offerta);
	}
	public Offerta findById(int id) {

		return offertaRepo.findById(id).get();
	}
	public void offertaDelete(Offerta offerta) {
		 offertaRepo.delete(offerta);
		
	}
}
