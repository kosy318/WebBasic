
public class BoardDao {
	
	// singleton 적용
	
	private static BoardDao instance = new BoardDao();
	private BoardDao() {}
	public static BoardDao getInstance() {
		return instance;
	}
	
	public int insert(Board board) {
		// 글 등록이 되었다고 가정
		return 1;
	}
		
}
