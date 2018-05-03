package com.api.pw.projsw.frontend;

import java.util.List;
import java.util.Optional;

import com.api.pw.projsw.exceptions.InvalidCredentialsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FrontEndService {

  @Autowired
  private FrontEndRepository frontEndRepository;
      
  public List<FrontEnd> getAll () {
    return frontEndRepository.findAll();
  }

  public FrontEnd getFrontEnd (FrontEnd frontEnd) {
    Optional<FrontEnd> optFrontEnd = frontEndRepository.findByIdAndSecret(frontEnd.getId(), frontEnd.getSecret());

    if (!optFrontEnd.isPresent()) {
      throw new InvalidCredentialsException("Credenciais invalidas");
    }

    return optFrontEnd.get();
  }
}