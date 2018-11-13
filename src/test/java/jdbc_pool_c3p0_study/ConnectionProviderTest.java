package jdbc_pool_c3p0_study;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import jdbc_pool_c3p0_study.jdbc.ConnectionProvider;
import jdbc_pool_c3p0_study.jdbc.LogUtil;

public class ConnectionProviderTest {

	//순서 1
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("START ConnectionProviderTest");
	}

	//순서 4
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println();
		LogUtil.prnLog("END ConnectionProviderTest");
	}

	//순서 2
	@Before
	//setUp() => 메서드 호출되기 전에 호출 된다.
	public void setUp() throws Exception {
		System.out.println();
	}

	//순서3
	@Test
	public void testConnection() {
		try(Connection connection = ConnectionProvider.getConnection()){
			LogUtil.prnLog(connection.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
