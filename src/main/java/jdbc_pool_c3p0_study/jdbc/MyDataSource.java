package jdbc_pool_c3p0_study.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

public class MyDataSource {
	//singleton pattern 적용
	private static final MyDataSource instance = new MyDataSource();
	
	//alt+shift+s => getter, setters
	public static MyDataSource getInstance() {
		return instance;
	}

	//필드 선언
	private DataSource dataSource;
	
	//dataSource에 대한 getter(dataSource에 get만 체크하기)
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	
	//close하기 위해
	public void close() {
		try {
			DataSources.destroy(dataSource);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	//생성자 추가 => superclass
	// ========== 중요!!!! public 아니고 private!!!!!!!!! ==========
	private MyDataSource() {
		// resource 폴더에 있는 db.properties를 불러 온다.
		Properties prop = loadProperties();
		
			DataSource ds_unpooled;
			try {
				ds_unpooled = DataSources.unpooledDataSource(prop.getProperty("url"), prop);
				Map<String, Object> overrides = new HashMap<>();
				overrides.put("maxStatements", "200");
				overrides.put("maxPoolSize", new Integer(50));
				dataSource = DataSources.pooledDataSource(ds_unpooled, overrides);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
/*		//entryset(키 값과 value값을 알 수 있다)
		for(Entry<Object, Object> e: prop.entrySet()) {
			System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
		}*/
	}



	private Properties loadProperties() {
		Properties properties = new Properties();
		//파일명 db.properties를 불러온다.
		try(InputStream is = ClassLoader.getSystemResourceAsStream("db.properties")){
			//파일 불러온 것을 is에 넣는다.(is에 db.properties가 들어있다.)
			properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
