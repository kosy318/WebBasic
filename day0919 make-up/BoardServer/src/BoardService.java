
public class BoardService {

	private BoardDao dao = BoardDao.getInstance();
	
	// singleton ����
	
	private static BoardService instance = new BoardService();
	private BoardService() {}
	public static BoardService getInstance() {
		return instance;
	}
	
	public int registBoard(Board board) { // DAO�� ������
		int cnt = dao.insert(board);
		return cnt;
	}
	
}
