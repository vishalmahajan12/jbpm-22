package com.cis.drool_rest.drools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.drools.template.jdbc.ResultSetGenerator;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.cis.drool_rest.models.Customer;
import com.cis.drool_rest.utils.TrackingAgendaEventListener;

/*
 * put sample.drl file in any location and put that location name against drlFileLocation
 */

public class DroolsTest {

	private static KieContainer kieContainer = null;
	private static String drlFileLocation = "C:\\Users\\06645\\git\\Drools\\src\\main\\resources\\rules";

	public static KieSession getKieSession() throws IOException, SQLException, ClassNotFoundException {
		
		 String jdbcUrl ="jdbc:mysql://localhost:3306/mydb";
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
		
		 
//		Collection<RuleData> paramSets = new ArrayList<RuleData>();
//		paramSets.add( new RuleData( 2, 5, 10000 ) );
//		paramSets.add( new RuleData( 5, 10, 50000 ) );
//		ObjectDataCompiler converter = new ObjectDataCompiler();
//		FileInputStream fis2 = new FileInputStream("C:\\Users\\06645\\git\\Drools\\src\\main\\resources\\template.drl");
//		String drl = converter.compile( paramSets, fis2);
		 
		 PreparedStatement preparedStmt = conn.prepareStatement("select condLessThan, condGreaterThan, actSalary from rules_data");
		 		ResultSet resultSet = preparedStmt.executeQuery();
		 		ResultSetGenerator resultSetGenerator = new ResultSetGenerator();
		 		FileInputStream fis = new FileInputStream("C:\\Users\\06645\\git\\Drools\\src\\main\\resources\\template.drl");
				  String drl2 = resultSetGenerator.compile(resultSet, 
						  fis);
				  resultSet.close();
				  preparedStmt.close();
				  conn.close();
				  
				  
				  System.out.println("drl " + drl2);
				  
				  // build rule base
		if (kieContainer == null) {
			KieServices kieServices = KieServices.Factory.get();
			KieFileSystem kfs = kieServices.newKieFileSystem();
			kfs.write( "src/main/resources/simple.drl",
			    kieServices.getResources().newReaderResource( new StringReader(drl2) ) );
			
			KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
			Results results = kieBuilder.getResults();
			if (results.hasMessages(Message.Level.ERROR)) {
				System.out.println(results.getMessages());
				throw new IllegalStateException("### errors ###");
			}
			kieContainer = kieServices.newKieContainer(kieServices
					.getRepository().getDefaultReleaseId());
		}
		return kieContainer.newKieSession();
	}

	public static final void main(String[] args) {
		try {
			TrackingAgendaEventListener ad = new TrackingAgendaEventListener();
			for (int i = 0; i < 5; i++) {
				KieSession kieSession = getKieSession();
				kieSession.addEventListener(ad);
				System.out.println(kieSession);
				
				Customer e1 = new Customer("Vishal", 0, 4);
				Customer e2 = new Customer("Abhay", 0, 7);
				System.out.println(e1);
				System.out.println(e2);
				kieSession.insert(e1);
				kieSession.insert(e2);
//				kieSession.getAgenda().getAgendaGroup("ag1").setFocus();
				// kieSession.getAgenda().getActivationGroup("A1");
				kieSession.fireAllRules();
				System.out.println(e1);
				System.out.println(e2);
			}
			System.out.println(ad.matchsToString());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
