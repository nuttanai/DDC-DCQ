package namedcq.controller;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;
 
public class ContactAttributeMapper implements AttributesMapper{
 
	public Object mapFromAttributes(Attributes attributes) throws NamingException {
		ContactDTO contactDTO = new ContactDTO();
 
		Attribute mail = attributes.get("mail");
		 // Attribute sap = attributes.get("employeeNumber"); displayname
		 Attribute sap = attributes.get("displayname");
		if(mail != null)
			contactDTO.setMail((String)mail.get());
		if(sap != null)
			contactDTO.setSap((String)sap.get());
 
		return contactDTO;
	}
 
}