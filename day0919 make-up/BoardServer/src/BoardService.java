
public class BoardService {

	private BoardDao dao = BoardDao.getInstance();
	
	// singleton 적용
	
	private static BoardService instance = new BoardService();
	private BoardService() {}
	public static BoardService getInstance() {
		return instance;
	}
	
	public int registBoard(Board board) { // DAO로 가야함
		int cnt = dao.insert(board);
		return cnt;
	}
	
}
