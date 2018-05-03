package com.api.pw.projsw.msg;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.api.pw.projsw.exceptions.InvalidCredentialsException;
import com.api.pw.projsw.exceptions.MessageInvalidException;
import com.api.pw.projsw.exceptions.MessageNotFoundException;
import com.api.pw.projsw.frontend.FrontEnd;
import com.api.pw.projsw.frontend.FrontEndService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageService {

  @Autowired
  private MessageRepository messageRepository;

  @Autowired
  private FrontEndService frontEndService;

  private Map<String, String> response = new HashMap<String, String>();

  public List<Message> getAll() {
    return messageRepository.findAll();
  }
    
	public Map<String, String> save (Message message){
    checkInvalidParams(message);

    messageRepository.save(message);
    response.put("response", "Messagem foi persistida com sucesso");
    return response;
  }
  
  // Talvez criar uma nova camada no futuro
  private void checkInvalidParams (Message message) {
    String errorMessage = "";

    if (message.getAuthor() == null || (message.getAuthor().trim() == "")) {
      errorMessage += "A mensagem deve ter um autor válido;";
    }

    if (message.getMsg().trim() == "" || message.getMsg() == null) {
      errorMessage += "O request deve ter uma mensagem válida;";
    }

    if (message.getTitle() == null || message.getTitle().trim() == "" ) {
      errorMessage += "A mensagem deve ter um titulo válido;";
    }

    if (!errorMessage.equals("")) {
      throw new MessageInvalidException(errorMessage);
    }

    frontEndService.getFrontEnd(message.getCredentials());
  }

  public MessageDTO getById (Long id) {
    Optional<Message> optMessage = messageRepository.findById(id);

    if (!optMessage.isPresent()) {
      throw new MessageNotFoundException("Mensagem não existe");
    }

    Message message = optMessage.get();
    return new MessageDTO(message.getId(), message.getTitle(), message.getMsg(), message.getAuthor(), 
                          message.getCreated_At(), message.getCredentials());
  } 
	
	public Map<String, String> delete(Long id, FrontEnd credentials){
    Optional<Message> optMessage = messageRepository.findById(id);

    if (!optMessage.isPresent()) {
      throw new MessageNotFoundException("Mensagem não existe");
    }

    Message message = optMessage.get();

    if (credentials == null || !message.getCredentials().equals(credentials)) {
      throw new InvalidCredentialsException("Credenciais invalidas");
    }

    messageRepository.deleteById(id);
    response.put("response", "Messagem foi deletada com sucesso");
		return response;
  }
	
	
	
}