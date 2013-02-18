import java.util.ArrayList;

import edu.cmu.mse.rui.J2EE.HW8.DAO.FavoriteDAO;
import edu.cmu.mse.rui.J2EE.HW8.DAO.UserDAO;
import edu.cmu.mse.rui.J2EE.HW8.DataBean.Favorite;
import edu.cmu.mse.rui.J2EE.HW8.DataBean.User;


public class DBOperationTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		User a = new User();
		a.setEmailAdd("ruiliwonder");
		a.setPassword("pasw");
		UserDAO dao = new UserDAO();
		dao.save(a);
		dao.changePassword("hello3", 1);
		User b=dao.findById(1);
		System.out.println(b.getEmailAdd());
//		FavoriteDAO fdao = new FavoriteDAO();
//		
//		Favorite f = new Favorite();
//		f.setClickCounter(0);
//		f.setComment("comment");
//		f.setUrl("url");
//		f.setUserId(1);
//		fdao.save(f);
//		ArrayList<Favorite> firstarr = new ArrayList<Favorite>();
//		firstarr = (ArrayList<Favorite>) fdao.queryUserFavorites(1);
//		System.out.println(firstarr.size());
//		for (Favorite one : firstarr) {
//			System.out.println(one.getClickCounter());
//
//		}
//		fdao.increaseCounter(1);
//		
//		ArrayList<Favorite> secondarr = new ArrayList<Favorite>();
//		secondarr = (ArrayList<Favorite>) fdao.queryUserFavorites(1);
//		System.out.println(secondarr.size());
//		for (Favorite one : secondarr) {
//			System.out.println(one.getClickCounter());
//
//		}

	}

}
