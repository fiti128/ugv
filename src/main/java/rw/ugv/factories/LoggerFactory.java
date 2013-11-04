package rw.ugv.factories;




import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;

public class LoggerFactory {

	@Produces
	public Logger getLogger(InjectionPoint ip) {
//		Member member = ip.getMember();
//		Class<?> myClass = member.getDeclaringClass();
//		return Logger.getLogger(myClass);
		return Logger.getLogger(this.getClass());
	}
}
