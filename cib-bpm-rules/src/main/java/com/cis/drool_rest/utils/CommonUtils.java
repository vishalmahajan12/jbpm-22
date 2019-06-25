package com.cis.drool_rest.utils;

import java.io.InputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import org.drools.template.ObjectDataCompiler;
import org.drools.template.jdbc.ResultSetGenerator;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.cis.drool_rest.drools.DroolsTest;
import com.cis.drool_rest.models.QIBGroupInfo;

public class CommonUtils {

	private static KieContainer kieContainer = null;
	public static final String drlFile = "template.drl";

		public static KieSession createKession() throws Exception {
			System.out.println("Creating KieSession!");
			/*
			 * KieServices ks = KieServices.Factory.get(); KieContainer kContainer =
			 * ks.getKieClasspathContainer(); KieSession kSession =
			 * kContainer.newKieSession("ksession-rules"); return kSession;
			 */
			if(null == kieContainer){
				initialize();
			}
			return kieContainer.newKieSession();
		}

		public static void initialize() throws Exception {
			
			
			
			Collection<QIBGroupInfo> qibGroupInfos = extractRulesDataFromDB();
			
//			Collection<QIBGroupInfo> qibGroupInfos = extractRulesDataFromObjects();
		 
			KieServices kieServices = KieServices.Factory.get();
			KieFileSystem kfs = kieServices.newKieFileSystem();
			ObjectDataCompiler converter = new ObjectDataCompiler();
//			ResultSetGenerator converter = new ResultSetGenerator();
			InputStream fis = DroolsTest.class.getClassLoader().getResourceAsStream(drlFile) ;
			
			  String drl2 = converter.compile(qibGroupInfos,  fis);
				try {
					kfs.write( "src/main/resources/simple.drl",
						    kieServices.getResources().newReaderResource( new StringReader(drl2) ) );
				} catch (Exception e) {
					e.printStackTrace();
				}
	
			KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
			Results results = kieBuilder.getResults();
			if (results.hasMessages(Message.Level.ERROR)) {
				System.out.println(results.getMessages());
				throw new IllegalStateException(results.getMessages().toString());
			}
			kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
			System.out.println("Kie Container Created!");
		}

		private static Collection<QIBGroupInfo> extractRulesDataFromObjects() {
			Collection<QIBGroupInfo> qibGroupInfos = new ArrayList<>();
			qibGroupInfos.add(new QIBGroupInfo(1, "g1", 11, false, true, "eid1", 1, 1, 10, 500));
			qibGroupInfos.add(new QIBGroupInfo(2, "g2", 11, true, true, "eid2", 1, 1, 10, 500));
			qibGroupInfos.add(new QIBGroupInfo(3, "g3", 11, true, true, "eid1", 1, 1, 400, 5000));
			qibGroupInfos.add(new QIBGroupInfo(1, "g1", 12, true, true, "eid1", 1, 1, 10, 500));
			return qibGroupInfos;
		}

		private static Collection<QIBGroupInfo> extractRulesDataFromDB() throws ClassNotFoundException, SQLException {
			String jdbcUrl ="jdbc:mysql://localhost:3306/mydb";
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection(jdbcUrl, "root", "mysql");
			
			 
			 PreparedStatement preparedStmt = conn.prepareStatement(
						"select groupId, name, rimNumber, verifierGroup, isActive, entitlementUuid, affrimationCount, sequence, minLimit, maxLimit from QIB_GROUP_INFO");
	
				ResultSet resultSet = preparedStmt.executeQuery();
				Collection<QIBGroupInfo> qibGroupInfos = new ArrayList<>();
				while (resultSet.next()) {
					qibGroupInfos.add(new QIBGroupInfo(resultSet.getLong("groupId"), resultSet.getString("name"),
							resultSet.getLong("rimNumber"), resultSet.getBoolean("verifierGroup"),
							resultSet.getBoolean("isActive"), resultSet.getString("entitlementUuid"),
							resultSet.getInt("affrimationCount"), resultSet.getInt("sequence"), resultSet.getLong("minLimit"),
							resultSet.getLong("maxLimit")));
				}
			return qibGroupInfos;
		}
}
