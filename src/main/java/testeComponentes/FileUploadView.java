package testeComponentes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
 
@ManagedBean
public class FileUploadView {
	private List<String> imagens=new ArrayList<>();
 
    public void handleFileUpload(FileUploadEvent event) {
    	imagens.add( event.getFile().getFileName());
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
       
        for (String string : imagens) {
        	System.out.println("Imagem "+string);
        	
		}
        	
        
        
    }



}