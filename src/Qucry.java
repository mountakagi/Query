

import java.sql.*;

public class Qucry
	{public static void main(String[] args)
		{
			Query query=new Query();
			query.select();
		}
		public void select()
		{
		Connection conn=null;

		ResultSet rs=null;


			try{
				Class.forName("com.mysql.jdbc.Driver");

				String uri="jdbc:mysql://localhost:3306/sql_lesson?useSSL=false";
				conn=DriverManager.getConnection(uri,"root","rootpass");
				stmt=conn.createStatement();
				rs=stmt.excuteQuery("SELECT"+"staff_code as 社員番号"+"staff_name as 社員名"+"work_years as 勤務年数"+"wages as 給料"+"FROM staff");

				while(rs.next())
					{System.out.println(rs.getInt(1))
					+"\t\t"
						+rs.getString(2)
					+"\t"
						+rs.getInt(3)
					+"\t\t"
						+rs.getInt(4)
					};
					}

		}catch (classNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
				try{rs.close();
					stmt.close();
					conn.close();
				}
			catch(SQLException e){//例外処理
			}
		}
	}
}


