
public class BoardDao {
	
	// singleton ����
	
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return instance;
	}
	
	public int insert(Board board) {
		// �� ����� �Ǿ��ٰ� ����
		return 1;
	}
		
}
