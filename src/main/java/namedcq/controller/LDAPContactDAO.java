package namedcq.controller;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;

import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.AndFilter;
import org.springframework.ldap.filter.EqualsFilter;
 
public class LDAPContactDAO implements ContactDAO{
	private LdapTemplate ldapTemplate;
 
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}
 
	public List getAllContactNames() {
		return ldapTemplate.search("", "(objectClass=person)",
				new AttributesMapper() {
					public Object mapFromAttributes(Attributes attrs)
							throws NamingException {
						return attrs.get("mail").get();
					}
				});
	}
 
	public List getContactDetails(String objectclass){
		AndFilter andFilter = new AndFilter();
		andFilter.and(new EqualsFilter("objectClass",objectclass));
		System.out.println("LDAP Query " + andFilter.encode());
		return ldapTemplate.search("", andFilter.encode(),new ContactAttributeMapper());
 
	}
}