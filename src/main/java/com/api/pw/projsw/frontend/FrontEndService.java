package com.api.pw.projsw.frontend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.api.pw.projsw.exceptions.InvalidCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class FrontEndService {

  @Autowired
  private FrontEndRepository frontEndRepository;
  
  private Map<String, String> response = new HashMap<String, String>();

  @Autowired
  private PasswordEncoder passwordEnconder;

  public List<FrontEnd> getAll () {
    return frontEndRepository.findAll();
  }

  public FrontEnd getFrontEnd (FrontEnd frontEnd) {
    Optional<FrontEnd> optFrontEnd = frontEndRepository.findById(frontEnd.getId());

    if (!optFrontEnd.isPresent()) {
      throw new InvalidCredentialsException("Credenciais invalidas");
    }

    FrontEnd dbFrontEnd = optFrontEnd.get();

    if (!dbFrontEnd.equals(frontEnd)) {
      throw new InvalidCredentialsException("Credenciais invalidas");
    }

    return optFrontEnd.get();
  }

  public Map<String, String> save (FrontEnd frontend){
    checkInvalidParams(frontend);

    frontend.setSecret(passwordEnconder.encode(frontend.getSecret()));
    frontEndRepository.save(frontend);
    response.put("response", "Frontend foi persistido com sucesso");
    return response;
  }

  //Should be in a interceptor
  public void checkAdmin (FrontEnd admin) {
    
    if (!"admin".equals(admin.getId())) {
      throw new InvalidCredentialsException("Admin não válido");
    }                                                

    String hash = "$2a$10$LHcA2Yysy6hARcWGDZ0LjOSdmToouLR5VEqt2iSru5JbVHPD09hFi";
    
    if (!passwordEnconder.matches(admin.getSecret(), hash)) {
      throw new InvalidCredentialsException("Admin não válido");
    }    

  }
  
  // Talvez criar uma nova camada no futuro
  private void checkInvalidParams (FrontEnd frontend) {
    String errorMessage = "";

    if (frontend.getId() == null || (frontend.getId().trim() == "")) {
      errorMessage += "O frontend deve ter um id válido;";
    }

    if (frontend.getSecret() == null || frontend.getSecret().trim() == "") {
      errorMessage += "O frontend deve ter um secret válido;";
    }

    if (!errorMessage.equals("")) {
      throw new InvalidCredentialsException(errorMessage);
    }

  }
}