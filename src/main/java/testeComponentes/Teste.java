package testeComponentes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named
@RequestScoped
public class Teste {

	private UploadedFile file;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload(FileUploadEvent event) {
		file = event.getFile();

		if (file != null) {
			File arquivo = new File("C:\\imagens", file.getFileName());
			if (arquivo.exists()) {
				System.out.println("Já existe um arquivo com esse nome, renomei o arquivo e tente novamnete!");
				FacesContext instance = FacesContext.getCurrentInstance();
				instance.addMessage("mensagens",
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Já existe um arquivo com esse nome '"
								+ file.getFileName() + ",' renomei o arquivo e tente novamnete!", null));
				
			} else {
				File file1 = new File("C:\\imagens", file.getFileName());

				//File file1 = new File("com/weliton/fotos/", file.getFileName());
				try {
					FileOutputStream fos = new FileOutputStream(file1);

					

					fos.write(event.getFile().getContents());
					fos.close();

					FacesContext instance = FacesContext.getCurrentInstance();
					instance.addMessage("mensagens", new FacesMessage(FacesMessage.SEVERITY_INFO,
							file.getFileName() + " anexado com sucesso", null));

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
			}
		}
	}
}