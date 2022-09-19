import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	
	private BoardService service = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String act = req.getParameter("act");
		
		switch(act) {
		case "regist":
			resp.sendRedirect(req.getContextPath() + "/regist.jsp");
			break;
		case "regist_board": // db까지 가야함
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String userid = req.getParameter("userid");
			
			System.out.println(title + " " + content + " " + userid);
			
			Board registBoard = new Board(0, title, content, userid, null);
			int cnt = service.registBoard(registBoard); // 글이 잘 등록되면 cnt == 1
			
			req.setAttribute("cnt", cnt);
			RequestDispatcher disp = req.getRequestDispatcher("/regist_result.jsp"); // contextPath가 이미 root 경로인 상태로 생각하고 사용.
			disp.forward(req, resp);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		doGet(req, resp); // 위의 doGet 함수로 전달되는거임
	}
}
