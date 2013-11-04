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
	
	public void addDocument() throws Exception {
		documentDao.create(ugvDocument);
	}
	
	
}
