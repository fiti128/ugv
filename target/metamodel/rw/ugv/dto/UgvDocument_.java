package rw.ugv.dto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UgvDocument.class)
public abstract class UgvDocument_ {

	public static volatile SingularAttribute<UgvDocument, String> kodOperacii;
	public static volatile SingularAttribute<UgvDocument, String> form;
	public static volatile SingularAttribute<UgvDocument, String> documentNumber;
	public static volatile ListAttribute<UgvDocument, UgvOperation> operationList;
	public static volatile SingularAttribute<UgvDocument, String> statusDoc;
	public static volatile SingularAttribute<UgvDocument, String> depoDocumenta;
	public static volatile SingularAttribute<UgvDocument, String> stanciaDocumenta;
	public static volatile SingularAttribute<UgvDocument, String> stanciaDislokacii;
	public static volatile SingularAttribute<UgvDocument, Date> documentDate;
	public static volatile SingularAttribute<UgvDocument, Date> id;
	public static volatile SingularAttribute<UgvDocument, String> kodPrichiniDocumenta;

}

