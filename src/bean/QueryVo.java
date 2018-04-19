package bean;

import java.io.Serializable;
import java.util.List;

public class QueryVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private user u ;
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	private List<Integer> list;
	public user getU() {
		return u;
	}

	public void setU(user u) {
		this.u = u;
	}
}
