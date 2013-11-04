package rw.ugv.dto;

import java.util.Calendar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UgvZajavka.class)
public abstract class UgvZajavka_ {

	public static volatile SingularAttribute<UgvZajavka, String> kodOperacii;
	public static volatile SingularAttribute<UgvZajavka, String> zajavkaForm;
	public static volatile SingularAttribute<UgvZajavka, String> statusZajavki;
	public static volatile SingularAttribute<UgvZajavka, String> zajavkaNomer;
	public static volatile SingularAttribute<UgvZajavka, Date> id;
	public static volatile SingularAttribute<UgvZajavka, Calendar> zajavkaDate;
	public static volatile SingularAttribute<UgvZajavka, String> kodPrichiniZajavki;

}

