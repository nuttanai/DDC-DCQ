package namedcq.controller;

import java.util.List;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.LDAPSearchException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

public class LDP {
/*	
    <property name="url" value="ldap://10.4.1.82:389" />
    <property name="base" value="ou=People,dc=buu,dc=ac,dc=th" />
    <property name="userName" value="54160403" />
    <property name="password" value="1j22430k1" />
    
    		LDP ldp = new LDP();
		ldp.getConnection();
*/	
	public static LDAPConnection getConnection() throws LDAPException {
	    // host, port, username and password
	    return new LDAPConnection("ldap://10.4.1.82", 389, "54160403", "1j22430k1");
	}
	
	public static List<SearchResultEntry> getResults(LDAPConnection connection, String baseDN, String filter) throws LDAPSearchException {
	    SearchResult searchResult;

	    if (connection.isConnected()) {
	        searchResult = connection.search(baseDN, SearchScope.ONE, filter);

	        return searchResult.getSearchEntries();
	    }

	    return null;
	}
	
}
