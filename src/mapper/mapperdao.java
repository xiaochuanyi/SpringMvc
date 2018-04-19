package mapper;

import java.util.List;

import bean.QueryVo;
import bean.user;

public interface mapperdao {
	public user findbyuserid(int id);
	public List<user> findbyQueryVo(QueryVo vo);
	public List<user> findbynameandmoney(user u);
	public List<user> findbyids(QueryVo vo);
}
