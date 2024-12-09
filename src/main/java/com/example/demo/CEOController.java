package com.example.demo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpSession;

@RestController
public class CEOController {
  private final CEORepository ceoRepository;

  public CEOController(CEORepository ceoRepository) {
    this.ceoRepository = ceoRepository;
  }

  @PostMapping("/saveCEO")
  @CrossOrigin(origins = "*")
  public String saveCEO(@RequestBody CEO ceo) {
    if (ceo == null) {
      return "This CEO is invalid";
    }
    this.ceoRepository.save(ceo);
    return "success";
  }
  
  
  @GetMapping("/findByIndustry")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<CEO> findByIndustry(@RequestParam String industry) {
  	Iterable<CEO> ceos = this.ceoRepository.findByIndustry(industry);
    List<CEO> CEOList = new ArrayList<>();
    ceos.forEach(CEOList::add);
    return CEOList;
  }
  

  @GetMapping("/findAllCEOs")
  @ResponseBody
  @CrossOrigin(origins = "*")
  public List<CEO> findAllCEOs() {
  	Iterable<CEO> ceos = this.ceoRepository.findAll();
    List<CEO> CEOList = new ArrayList<>();
  ceos.forEach(CEOList::add);
    return CEOList;
  }
}