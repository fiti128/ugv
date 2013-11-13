package rw.ugv.view;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import rw.ugv.dao.DocumentDAO;
import rw.ugv.dto.UgvDocument;

@Model
public class CreatingDocumentController {
	@Inject
	private DocumentDAO documentDao;
	
	private UgvDocument ugvDocument;
	
	@Produces @Model
	public UgvDocument getDocument() {
		ugvDocument = new UgvDocument();
		return ugvDocument;
	}
	
	public void addDocument(UgvDocument document) throws Exception {
        System.out.println("Creatring" + document);
        UgvDocument newDocument = new UgvDocument();
        newDocument.setDocumentNumber(document.getDocumentNumber());
        newDocument.setId(document.getId());

		documentDao.create(document.clone());
	}
	public void sayHi() {
		System.out.println("Hi from creatingDocument");
	}
	
	
}
