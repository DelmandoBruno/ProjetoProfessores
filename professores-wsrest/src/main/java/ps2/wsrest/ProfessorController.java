package ps2.wsrest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProfessorController {
	
	@Autowired
	private ProfessorRepo professorRepo;
	
	@GetMapping("/api/professores")
	public List<Professor> getProfessores(){
		List<Professor> professores = new ArrayList<>();
		professorRepo.findAll().forEach(professores::add);
		return professores;
	}
	
	@GetMapping("/api/professores/{id}")
	public Professor getProfessor(@PathVariable long id) {
		Optional <Professor> retorno = professorRepo.findById(id);
		Professor p = null;
		if (retorno.isPresent()) {
			p = retorno.get();
		}
		return p;
	}
	
	@PostMapping ("/api/professores")
	public Professor createProfessor (@RequestBody Professor p) {
		professorRepo.save(p);
		return p;
	}
	
	@PutMapping("/api/professores/{id}")
	public Professor updateProfessor(@RequestBody Professor p, @PathVariable long id) {
		Professor professor = null;
		professor = this.getProfessor(id);
		if (professor != null) {
			professorRepo.save(p);
			return p;
		}
		return professor;		
	}
	@DeleteMapping (value = "/api/professores/{id}", produces = "apliccation/json")
	public String deleteProfessor (@PathVariable long id) {
		Professor professor = this.getProfessor(id);
		boolean result = false;
		if(professor != null) {
			professorRepo.delete(professor);
			result = true;
		}
		return "{ \"success\" : "+ (result ? "true" : "false") +" }";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

