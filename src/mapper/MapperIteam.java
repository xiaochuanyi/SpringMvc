package mapper;

import java.util.List;

import bean.Iteam;
public interface MapperIteam {
	public List<Iteam> selectList();
	public Iteam selectbyid(int id);
}
