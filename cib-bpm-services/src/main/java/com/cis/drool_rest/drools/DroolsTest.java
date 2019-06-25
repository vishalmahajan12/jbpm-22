package com.cis.drool_rest.drools;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.template.ObjectDataCompiler;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.cis.drool_rest.models.Payload;
import com.cis.drool_rest.models.QIBGroupInfo;
import com.cis.drool_rest.utils.TrackingAgendaEventListener;

public class DroolsTest {

	private static KieContainer kieContainer = null;
//	private static String drlFileLocation = "C:\\Users\\06645\\git\\jbpm-22\\cib-bpm-services\\src\\main\\resources\\template.drl";

	public static final String drlFile = "template.drl";
	
	public static KieSession getKieSession() throws IOException, SQLException, ClassNotFoundException {
		
//		 String jdbcUrl ="jdbc:mysql://localhost:3306/mydb";
//		 Class.forName("com.mysql.jdbc.Driver");
//		 Connection conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
//		
//		 
//		 PreparedStatement preparedStmt = conn.prepareStatement(
//					"select groupId, name, rimNumber, verifierGroup, isActive, entitlementUuid, affrimationCount, sequence, minLimit, maxLimit from QIB_GROUP_INFO");
//
//			ResultSet resultSet = preparedStmt.executeQuery();
//			Collection<QIBGroupInfo> qibGroupInfos = new ArrayList<>();
//			while (resultSet.next()) {
//				qibGroupInfos.add(new QIBGroupInfo(resultSet.getLong("groupId"), resultSet.getString("name"),
//						resultSet.getLong("rimNumber"), resultSet.getBoolean("verifierGroup"),
//						resultSet.getBoolean("isActive"), resultSet.getString("entitlementUuid"),
//						resultSet.getInt("affrimationCount"), resultSet.getInt("sequence"), resultSet.getLong("minLimit"),
//						resultSet.getLong("maxLimit")));
//			}
			
			Collection<QIBGroupInfo> qibGroupInfos = new ArrayList<>();
			qibGroupInfos.add(new QIBGroupInfo(1, "g1", 11, false, true, "eid1", 1, 1, 10, 500));
			qibGroupInfos.add(new QIBGroupInfo(2, "g2", 11, true, true, "eid2", 1, 1, 10, 500));
			qibGroupInfos.add(new QIBGroupInfo(3, "g3", 11, true, true, "eid1", 1, 1, 400, 5000));
			qibGroupInfos.add(new QIBGroupInfo(1, "g1", 12, true, true, "eid1", 1, 1, 10, 500));
		 
		 
//		 		ResultSetGenerator converter = new ResultSetGenerator();
				ObjectDataCompiler converter = new ObjectDataCompiler();
		 		InputStream fis = DroolsTest.class.getClassLoader().getResourceAsStream(drlFile) ;
		 		
				  String drl2 = converter.compile(qibGroupInfos, 
						  fis);
//				  resultSet.close();
//				  preparedStmt.close();
//				  conn.close();
				  
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
			for (int i = 0; i < 1; i++) {
				KieSession kieSession = getKieSession();
				kieSession.addEventListener(ad);
				System.out.println(kieSession);
				
				Payload e1 = new Payload(11, "eid1", 450);
				List approvalList = new ArrayList();
				List verifierList = new ArrayList();
				
				kieSession.setGlobal("approvalList", approvalList);
				kieSession.setGlobal("verifierList", verifierList);

				System.out.println(e1);
				System.out.println("approvalList - " + approvalList);
				System.out.println("verifierList - " + verifierList);
				kieSession.insert(e1);
//				kieSession.getAgenda().getAgendaGroup("ag1").setFocus();
				// kieSession.getAgenda().getActivationGroup("A1");
				kieSession.fireAllRules();
				System.out.println(e1);
				System.out.println("approvalList - " + approvalList);
				System.out.println("verifierList - " + verifierList);
			}
			System.out.println(ad.matchsToString());
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}