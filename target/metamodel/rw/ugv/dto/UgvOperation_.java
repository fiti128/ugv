package rw.ugv.dto;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UgvOperation.class)
public abstract class UgvOperation_ {

	public static volatile SingularAttribute<UgvOperation, String> kodGosudarstvaSobstvennika;
	public static volatile SingularAttribute<UgvOperation, String> kodNovogiGosudarstvaSobstvennika;
	public static volatile SingularAttribute<UgvOperation, String> wagonNumber;
	public static volatile SingularAttribute<UgvOperation, UgvZajavka> ugvZajavkaId;
	public static volatile SingularAttribute<UgvOperation, Calendar> closingDateInAB;
	public static volatile SingularAttribute<UgvOperation, Calendar> dataRegistraciiParnojOperacii;
	public static volatile SingularAttribute<UgvOperation, UgvDocument> ugvDocId;
	public static volatile SingularAttribute<UgvOperation, String> sviaznojNomerVagona;
	public static volatile SingularAttribute<UgvOperation, UgvTechnicalDetails> ugvTechId;
	public static volatile SingularAttribute<UgvOperation, String> kodParnojOperacii;
	public static volatile SingularAttribute<UgvOperation, Date> id;
	public static volatile SingularAttribute<UgvOperation, String> priznakZapisi;
	public static volatile SingularAttribute<UgvOperation, String> kodVGO;
	public static volatile SingularAttribute<UgvOperation, Calendar> openDateInAB;

}

