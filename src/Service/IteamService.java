package Service;

import java.util.List;

import bean.Iteam;

public interface IteamService {
	public List<Iteam> select();
	public Iteam selectbyid(int id);
	public void update(Iteam i);
}
