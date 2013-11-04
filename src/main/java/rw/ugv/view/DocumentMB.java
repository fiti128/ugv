package rw.ugv.view;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import org.apache.log4j.Logger;
import org.primefaces.model.LazyDataModel;

import rw.ugv.dto.UgvDocument;
import rw.ugv.qualifiers.LazyDocumentModel;
import rw.ugv.qualifiers.Selected;
@Model
public class DocumentMB implements Serializable {
	@Inject
	private transient Logger logger;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2768724854452921037L;
	@Inject @LazyDocumentModel
	private LazyDataModel<UgvDocument> documentModel;
	private UgvDocument ugvDocument;
	private LazyDataModel<UgvDocument> filteredDocuments = null;



	public LazyDataModel<UgvDocument> getDocumentModel() {
		return documentModel;
	}

	public void setDocumentModel(LazyDataModel<UgvDocument> documentModel) {
		this.documentModel = documentModel;
	}
	
	@Produces @Selected @RequestScoped
	public UgvDocument getUgvDocument() {
		logger.debug("In DocumentMB getUgvDocument()");
		if (ugvDocument == null) {
			ugvDocument = new UgvDocument();
		}
		return ugvDocument;
	}

	public void setUgvDocument(UgvDocument ugvDocument) {
		logger.debug("In DocumentMB setUgvDocument()");
		this.ugvDocument = ugvDocument;
	}

	public LazyDataModel<UgvDocument> getFilteredDocuments() {
		return filteredDocuments;
	}

	public void setFilteredDocuments(LazyDataModel<UgvDocument> filteredDocuments) {
		this.filteredDocuments = filteredDocuments;
	}
	


}
