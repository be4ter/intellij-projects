package com.example.practice.spring.Repository;

import com.example.practice.spring.Model.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
	private static final String MAPPER_NAME_SPACE = "sample.mapper.userMapper.";

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List getUserInfoAll() {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
	}

	public void addUserInfo(UserVO userVO) {
		sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "addUserInfo", userVO);
	}

	public List findByUserNameLike(String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", username);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserNameLike", params);
	}

	public UserVO findByUserName(String username) {
		Map<String, Object> params = new HashMap<>();
		params.put("userName", username);
		return sqlSessionTemplate.selectOne(MAPPER_NAME_SPACE + "findByUserName", params);
	}

}
