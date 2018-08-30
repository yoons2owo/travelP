package kr.co.kke.app.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class Dao implements DaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	
	
	@Override
	public Object call(HashMap<String, Object> param) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		String sql = param.get("sql").toString();
		String sqlType = param.get("sqlType").toString();
		
		if("selectOne".equals(sql)) {
			return session.selectOne(sqlType, param);
		}else if("selectList".equals(sql)){
			return session.selectList(sqlType, param);
		}else if("update".equals(sql)){
			return session.update(sqlType, param);
		}else if("insert".equals(sql)) {
			return session.insert(sqlType, param);
		}
		
		return null;
	}

}
