package command;

import java.io.IOException;

import javax.activation.CommandObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command extends CommandObject {
	
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}



